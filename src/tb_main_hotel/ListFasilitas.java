/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author BINGLE
 */
public class ListFasilitas {
        private ArrayList<Fasilitas> fasilitasArray;
    
    public ListFasilitas(){
        this.fasilitasArray = new ArrayList();
    }
    
    public int cari(int id) {
    
        int out = -1;
        if (this.fasilitasArray.size() > 0) {
            for (int i = 0; i < this.fasilitasArray.size(); i++) {
                Fasilitas fasilitas = this.fasilitasArray.get(i);
                if (fasilitas.getId() == id) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }

    public int cari(String nama) {
    
        int out = -1;
        if (this.fasilitasArray.size() > 0) {
            for (int i = 0; i < this.fasilitasArray.size(); i++) {
                Fasilitas fasilitas = this.fasilitasArray.get(i);
                if (nama.equals(fasilitas.getNama_fasilitas())) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }
    
    public Fasilitas get(int index) {
    
        if ((index > -1) && (index < this.fasilitasArray.size())) {
            return this.fasilitasArray.get(index);
        } else {
            return null;
        }
    }

    public Fasilitas get(String nama) {
    
        int index = this.cari(nama);
        if ((index > -1) && (index < this.fasilitasArray.size())) {
            return this.fasilitasArray.get(index);
        } else {
            return null;
        }
    }


    public void tambah(int id, String nama, String deskripsi){
        
        Fasilitas fasilitas = new Fasilitas(id, nama, deskripsi);
        
        if (this.cari(id) > -1) {
            System.out.println("id salah.");
        } else {
            this.fasilitasArray.add(fasilitas);
        }            
    }
    
//    public void delete(int id) {
//    
//        int i = this.cari(id);
//        if (i > -1) {
//            this.fasilitasArray.remove(i);
//        } else {
//            System.out.println("fasilitas tidak ada.");
//        }
//    }
//
//    public void delete(String nama) {
//    
//        int i = this.cari(nama);
//        if (i > -1) {
//            this.fasilitasArray.remove(i);
//        } else {
//            System.out.println("fasilitas tidak ada.");
//        }
//    }
    
    public void tampil() {
    
        if (this.fasilitasArray.size() > 0) {
            for (int i = 0; i < this.fasilitasArray.size(); i++) {
                Fasilitas fasilitas = this.fasilitasArray.get(i);
                //System.out.println("#" + (i+1) + " " + hotel.getId() + " " + hotel.getNama());
                fasilitas.tampil();
            }
        
        } else {
            System.out.println("Tidak ada data fasilitas");
        }
    }
}
