/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;

/**
 *
 * @author Andaresta
 */
public class ListReservasi {
    
    private Database db;
    private ArrayList<Reservasi> reservasiArray;
    private int idHotel;
   
    public ListReservasi(Database db, int idHotel){
        
        this.db = db;
        this.idHotel = idHotel;
        this.reservasiArray = new ArrayList();
    }
    
     private int createId() {
    
        int id = 1;
        try{
            ResultSet rs = this.db.getData("select max(idReservasi) + 1 from reservasi where (idHotel = " + this.idHotel + ")");
            if(rs.next()){    
                id = rs.getInt(1);  
            }
            rs.close();
        }catch(Exception e){
        }
        return id;
    }
    
    public int refesh() {

        try{
            ResultSet rs = this.db.getData("select idReservasi, tanggal, jumOrang, noKamar from reservasi where (idHotel = " + this.idHotel + ") order by tanggal");
            
            this.reservasiArray.clear();
            while(rs.next()){    
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date d = (Date) fmt.parse(rs.getString(2));
                Reservasi reservasi = new Reservasi(rs.getInt(1), d, rs.getInt(3), idHotel, rs.getInt(4));
                this.reservasiArray.add(reservasi);   
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Error load reservasi " +e.getMessage());
        }
        return this.reservasiArray.size();
    }
    
    public int cari(int id) {
    
        int out = -1;
        if (this.reservasiArray.size() > 0) {
            for (int i = 0; i < this.reservasiArray.size(); i++) {
                Reservasi reservasi = this.reservasiArray.get(i);
                if (reservasi.getIdReservasi()== id) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }

   public int count() {
    
        return this.reservasiArray.size();
    }
   
    public Reservasi get(int index) {
    
        if ((index > -1) && (index < this.reservasiArray.size())) {
            return this.reservasiArray.get(index);
        } else {
            return null;
        }
    }
    
    public boolean canReserve(int noKamar, Date tgl) {
    
        boolean hasil = true;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try{
            ResultSet rs = this.db.getData("select idReservasi from reservasi where (idHotel = " + this.idHotel + ") and (tanggal = '" + fmt.format(tgl) + "')");
            if(rs.next()){    
                hasil = false;  
            }
            rs.close();
        }catch(Exception e){
        }
        return hasil;
    }
   
    public int doReservation(int noKamar, Date tgl, int jumOrang){
        
        int hasil = 0;
        
        /* cek kamar dan tanggal */
        if (this.canReserve(noKamar, tgl)) {

            /*id otomatis */
            int id = this.createId();
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            //System.out.println("insert into reservasi (idReservasi, tanggal, jumOrang, idHotel, noKamar) values (" + id + ", '" + fmt.format(tgl) + "', '" + jumOrang + "', '"+ this.idHotel + "', " + noKamar +")");
            /* simpan ke db */
            if (this.db.query("insert into reservasi (idReservasi, tanggal, jumOrang, idHotel, noKamar) values (" + id + ", '" + fmt.format(tgl) + "', '" + jumOrang + "', '"+ this.idHotel + "', " + noKamar +")")) {
                /* add ke list */
                Reservasi reservasi = new Reservasi(id, tgl, jumOrang, this.idHotel, noKamar);
                this.reservasiArray.add(reservasi);
            } else {
                hasil = 2;
            }
        } else {
            hasil = 1;
        }
        return hasil;
    }
    
    public boolean cancleReserv(int id){
       int i = this.cari(id);
        if (i > -1) {
            try {
                if (this.db.query("delete from reservasi where (idHotel = " + this.idHotel + ") and (idReservasi = " + id + ")")) {
                    this.reservasiArray.remove(i);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        } else {
            System.out.println("reservasi tidak ada.");
            return false;
        }
    }
    
    public void tampil() {
    
        if (this.reservasiArray.size() > 0) {
            for (int i = 0; i < this.reservasiArray.size(); i++) {
                Reservasi reservasi = this.reservasiArray.get(i);
                //System.out.println("#" + (i+1) + " " + hotel.getId() + " " + hotel.getNama());
                reservasi.tampil();
            }
        
        } else {
            System.out.println("Tidak ada data reservasi");
        }
    }
    
    public void tampil(JTable jtable) {
        
        TableReservasi data = new TableReservasi(this);
        jtable.setModel(data);
        
    }
}
