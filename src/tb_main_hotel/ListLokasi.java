/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.util.ArrayList;

/**
 *
 * @author BINGLE
 */
public class ListLokasi {
          private ArrayList<Lokasi> lokasi;
    
    public ListLokasi(){
        this.lokasi = new ArrayList();
    }
    
    public int cari(String kota) {
    
        int out = -1;
        if (this.lokasi.size() > 0) {
            for (int i = 0; i < this.lokasi.size(); i++) {
                Lokasi lokasi = this.lokasi.get(i);
                if (kota.equals(lokasi.getKota())) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }
    
    public Lokasi get(int index) {
    
        if ((index > -1) && (index < this.lokasi.size())) {
            return this.lokasi.get(index);
        } else {
            return null;
        }
    }

    public Lokasi get(String kota) {
    
        int index = this.cari(kota);
        if ((index > -1) && (index < this.lokasi.size())) {
            return this.lokasi.get(index);
        } else {
            return null;
        }
    }


    public void tambah(String kota, String provinsi){
        
        Lokasi lokasi = new Lokasi(kota,provinsi);
        
        if (this.cari(kota) > -1) {
            System.out.println("id salah.");
        } else {
            this.lokasi.add(lokasi);
        }            
    }
    

    public void delete(String kota) {
    
        int i = this.cari(kota);
        if (i > -1) {
            this.lokasi.remove(i);
        } else {
            System.out.println("Lokasi tidak ada.");
        }
    }
    
    public void tampil() {
    
        if (this.lokasi.size() > 0) {
            for (int i = 0; i < this.lokasi.size(); i++) {
                Lokasi lokasi = this.lokasi.get(i);
                //System.out.println("#" + (i+1) + " " + hotel.getId() + " " + hotel.getNama());
                lokasi.tampil();
            }
        
        } else {
            System.out.println("Tidak ada data fasilitas");
        }
    }
}
