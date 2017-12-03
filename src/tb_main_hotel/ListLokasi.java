/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author BINGLE
 */
public class ListLokasi {
        private Database db;
    private ArrayList<Lokasi> lokasi;
    private int idHotel;
    
    public ListLokasi(Database db, int idHotel){
        
        this.db = db;
        this.idHotel = idHotel;
        this.lokasi = new ArrayList();
    }
    
     public int refesh() {

        try{
            ResultSet rs = this.db.getData("select nama, deskripsi from fasilitas where (idHotel = " + this.idHotel + ")");
            
            this.lokasi.clear();
            while(rs.next()){    
                Lokasi lokasi = new Lokasi(rs.getInt(1), rs.getString(2), rs.getString(3), this.idHotel);
                this.lokasi.add(lokasi);   
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Error load review " +e.getMessage());
        }
        return this.lokasi.size();
    }
     
     public int cari(int id) {
    
        int out = -1;
        if (this.lokasi.size() > 0) {
            for (int i = 0; i < this.lokasi.size(); i++) {
                Lokasi lokasi = this.lokasi.get(i);
                if (lokasi.getIdLokasi() == id) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }
    


    public int count() {
    
        return this.lokasi.size();
    }
    
      public Lokasi get(int index) {
    
        if ((index > -1) && (index < this.lokasi.size())) {
            return this.lokasi.get(index);
        } else {
            return null;
        }
    }
      

     
    public boolean deleteLokasi(int id){
    
        int i = this.cari(id);
        if (i > -1) {
            try {
                if (this.db.query("delete from lokasi where (idHotel = " + this.idHotel + ") and (idlokasi = " + id + ")")) {
                    this.lokasi.remove(i);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        } else {
            System.out.println("fasilitas tidak ada.");
            return false;
        }
    
    }
    
    public void tampil() {
    
        if (this.lokasi.size() > 0) {
            for (int i = 0; i < this.lokasi.size(); i++) {
                Lokasi lokasi = this.lokasi.get(i);
                //System.out.println("#" + (i+1) + " " + hotel.getId() + " " + hotel.getNama());
                lokasi.display();
            }
        
        } else {
            System.out.println("Tidak ada lokasi");
        }
    }
    
    public void tampil(JTable jtable) {
        
        TableLokasi data = new TableLokasi(this);
        jtable.setModel((TableModel) data);
        /*
        if (this.hotelArray.size() > 0) {
            for (int j = 0; j < this.hotelArray.size(); j++) {
                jtable.setValueAt(this.hotelArray.get(j).getId(), j, 0);
                jtable.setValueAt(this.hotelArray.get(j).getNama(), j, 1);
                jtable.setValueAt(this.hotelArray.get(j).getInformasi(), j, 2);
            }
        }
        */
    }

    public void tampil(JComboBox jcombo) {
        
        jcombo.removeAllItems();
        if (this.lokasi.size() > 0) {
            for (int i = 0; i < this.lokasi.size(); i++) {
                Lokasi lokasi = this.lokasi.get(i);
                jcombo.addItem(lokasi.getIdLokasi());
            }
        }

    }

    public int addLokasi(String kota, String provinsi) {
                
         int hasil = 0;
        
        /*id otomatis */
        int id = this.lokasi.size()+1;
        System.out.println("insert into lokasi (idlokasi, kota, provinsi, idHotel) values (" + id + ", '" + kota + "', '" + provinsi + "', " + this.idHotel +")");
        /* simpan ke db */
        if (this.db.query("insert into lokasi (idlokasi, kota, provinsi, idHotel) values (" + id+ ", '" + kota + "', '" + provinsi  + "', " + this.idHotel +")")) {
            /* add ke list */
            Lokasi lokasi = new Lokasi(id, kota, provinsi, this.idHotel);
            this.lokasi.add(lokasi);

        } else {
            hasil = 2;
        }
        return hasil;
    }
}
