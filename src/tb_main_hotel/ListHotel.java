package tb_main_hotel;


import java.sql.ResultSet;
import java.util.ArrayList;
import tb_main_hotel.Hotel;
import tb_main_hotel.Database;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andaresta
 */
public class ListHotel {

    private Database db;
    private ArrayList<Hotel> hotelArray;
    
    public ListHotel(Database db) {
    
        this.db = db;
        this.hotelArray = new ArrayList();
    }
    
    public int refesh() {
    
        try{
            ResultSet rs = this.db.getData("select idHotel, nama, informasi from hotel");
            
            this.hotelArray.clear();
            while(rs.next()){    
                Hotel hotel = new Hotel(rs.getInt(1), rs.getString(2), rs.getString(3));
                this.hotelArray.add(hotel);   
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Error refresh" +e.getMessage());
        }
        return this.hotelArray.size();
    }
    
    public int cari(int id) {
    
        int out = -1;
        if (this.hotelArray.size() > 0) {
            for (int i = 0; i < this.hotelArray.size(); i++) {
                Hotel hotel = this.hotelArray.get(i);
                if (hotel.getId() == id) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }

    public int cari(String nama) {
    
        int out = -1;
        if (this.hotelArray.size() > 0) {
            for (int i = 0; i < this.hotelArray.size(); i++) {
                Hotel hotel = this.hotelArray.get(i);
                if (hotel.getNama().equals(nama)) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }
    
    public Hotel get(int index) {
    
        if ((index > -1) && (index < this.hotelArray.size())) {
            return this.hotelArray.get(index);
        } else {
            return null;
        }
    }

    public Hotel get(String nama) {
    
        int index = this.cari(nama);
        if ((index > -1) && (index < this.hotelArray.size())) {
            return this.hotelArray.get(index);
        } else {
            return null;
        }
    }
    
    public int count() {
    
        return this.hotelArray.size();
    }

    public int tambah(int id, String nama, String informasi){
        
        int hasil = 0;
        
        if (this.cari(id) > -1) {
            hasil = 1;
        } else {
            /* simpan ke db */
            if (this.db.query("insert into hotel (idHotel, nama, informasi) values (" + id + ", '" + nama + "', '" + informasi + "')")) {
                /* add ke list */
                Hotel hotel = new Hotel(id, nama, informasi);
                this.hotelArray.add(hotel);              
            } else {
                hasil = 2;
            }
        }
        return hasil;
    }
    
    public boolean delete(int id) {
    
        int i = this.cari(id);
        if (i > -1) {
            try {
                if (this.db.query("delete from hotel where idHotel = " + id)) {
                    this.hotelArray.remove(i);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        } else {
            System.out.println("hotel tidak ada.");
            return false;
        }
    }

    /*
    public boolean delete(String nama) {
    
        int i = this.cari(nama);
        if (i > -1) {
            this.hotelArray.remove(i);
            return true;
        } else {
            System.out.println("hotel tidak ada.");
            return false;
        }
    }
    */

    public void tampil() {
    
        if (this.hotelArray.size() > 0) {
            for (int i = 0; i < this.hotelArray.size(); i++) {
                Hotel hotel = this.hotelArray.get(i);
                //System.out.println("#" + (i+1) + " " + hotel.getId() + " " + hotel.getNama());
                hotel.tampil();
            }
        
        } else {
            System.out.println("Tidak ada data hotel");
        }
    }
    
    public void tampil(JTable jtable) {
        
        TableHotel data = new TableHotel(this);
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
    
}
