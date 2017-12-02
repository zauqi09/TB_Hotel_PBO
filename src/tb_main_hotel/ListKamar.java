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
import tb_main_hotel.Database;
import tb_main_hotel.Hotel;
import tb_main_hotel.Review;
import tb_main_hotel.TableKamar;
import tb_main_hotel.TableReview;

/**
 *
 * @author Andaresta
 */
public class ListKamar {
    private Database db;
    private ArrayList<Kamar> kamarArray;
    private int idHotel;
    
    public ListKamar(Database db, int idHotel){
        
        this.db = db;
        this.idHotel = idHotel;
        this.kamarArray = new ArrayList();
    }
    
     public int refesh() {

        try{
            ResultSet rs = this.db.getData("select noKamar, jenis, jmlKasur, harga from kamar where (idHotel = " + this.idHotel + ")");
            
            this.kamarArray.clear();
            while(rs.next()){    
                Kamar kamar = new Kamar(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), this.idHotel);
                this.kamarArray.add(kamar);   
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Error load review " +e.getMessage());
        }
        return this.kamarArray.size();
    }
     
     public int cari(int id) {
    
        int out = -1;
        if (this.kamarArray.size() > 0) {
            for (int i = 0; i < this.kamarArray.size(); i++) {
                Kamar kamar = this.kamarArray.get(i);
                if (kamar.getNoKamar() == id) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }
    


    public int count() {
    
        return this.kamarArray.size();
    }
    
      public Kamar get(int index) {
    
        if ((index > -1) && (index < this.kamarArray.size())) {
            return this.kamarArray.get(index);
        } else {
            return null;
        }
    }
      
     public int addKamar(int noKamar, String jenis, int jmlKasur, int harga){
        
         int hasil = 0;
        
        /*id otomatis */
        int id = this.kamarArray.size()+1;
        System.out.println("insert into kamar (noKamar, jenis, jmlKasur, harga, idHotel) values (" + noKamar + ", '" + jenis + "', '" + jmlKasur + "', '"+ harga+ "', " + this.idHotel +")");
        /* simpan ke db */
        if (this.db.query("insert into kamar (noKamar, jenis, jmlKasur, harga, idHotel) values (" + noKamar + ", '" + jenis + "', '" + jmlKasur + "', '"+ harga+ "', " + this.idHotel +")")) {
            /* add ke list */
            Kamar kamar = new Kamar(noKamar , jenis, jmlKasur, harga, this.idHotel);
            this.kamarArray.add(kamar);

        } else {
            hasil = 2;
        }
        return hasil;
    }
     
    public boolean deleteKamar(int id){
    
        int i = this.cari(id);
        if (i > -1) {
            try {
                if (this.db.query("delete from kamar where (idHotel = " + this.idHotel + ") and (noKamar = " + id + ")")) {
                    this.kamarArray.remove(i);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        } else {
            System.out.println("kamar tidak ada.");
            return false;
        }
    
    }
    
    public void tampil() {
    
        if (this.kamarArray.size() > 0) {
            for (int i = 0; i < this.kamarArray.size(); i++) {
                Kamar kamar = this.kamarArray.get(i);
                //System.out.println("#" + (i+1) + " " + hotel.getId() + " " + hotel.getNama());
                kamar.tampil();
            }
        
        } else {
            System.out.println("Tidak ada data review");
        }
    }
    
    public void tampil(JTable jtable) {
        
        TableKamar data = new TableKamar(this);
        jtable.setModel(data);
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
        if (this.kamarArray.size() > 0) {
            for (int i = 0; i < this.kamarArray.size(); i++) {
                Kamar kamar = this.kamarArray.get(i);
                jcombo.addItem(kamar.getNoKamar());
            }
        }

    }
}
