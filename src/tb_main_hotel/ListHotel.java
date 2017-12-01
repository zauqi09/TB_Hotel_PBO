package tb_main_hotel;


import java.util.ArrayList;
import tb_main_hotel.Hotel;

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

    private ArrayList<Hotel> hotelArray;
    
    public ListHotel() {
    
        this.hotelArray = new ArrayList();
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


    public void tambah(int id, String nama, String informasi){
        
        Hotel hotel = new Hotel(id, nama, informasi);
        
        if (this.cari(id) > -1) {
            System.out.println("id salah.");
        } else {
            this.hotelArray.add(hotel);
        }            
    }
    
    public void delete(int id) {
    
        int i = this.cari(id);
        if (i > -1) {
            this.hotelArray.remove(i);
        } else {
            System.out.println("hotel tidak ada.");
        }
    }

    public void delete(String nama) {
    
        int i = this.cari(nama);
        if (i > -1) {
            this.hotelArray.remove(i);
        } else {
            System.out.println("hotel tidak ada.");
        }
    }

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
}
