/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.util.ArrayList;
import tb_main_hotel.UI.UI_Kamar;

/**
 *
 * @author BINGLE
 */
public class ListKamar {
        private ArrayList<Kamar> kamar;
    
    public ListKamar(){
        this.kamar = new ArrayList();
    }
    
    public int cari(int no) {
    
        int out = -1;
        if (this.kamar.size() > 0) {
            for (int i = 0; i < this.kamar.size(); i++) {
                Kamar kamar = this.kamar.get(i);
                if (kamar.getNoKamar() == no) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }

    
    public Kamar get(int index) {
    
        if ((index > -1) && (index < this.kamar.size())) {
            return this.kamar.get(index);
        } else {
            return null;
        }
    }



    public void tambah(int no, String jenis, int jml){
        
        Kamar kamar = new Kamar(no, jenis, jml);
        
        if (this.cari(no) > -1) {
            System.out.println("no salah.");
        } else {
            this.kamar.add(kamar);
        }            
    }
    
    public void delete(int no) {
    
        int i = this.cari(no);
        if (i > -1) {
            this.kamar.remove(i);
        } else {
            System.out.println("kamar tidak ada.");
        }
    }

    
    public void tampil() {
    
        if (this.kamar.size() > 0) {
            for (int i = 0; i < this.kamar.size(); i++) {
                Kamar kamar = this.kamar.get(i);
                //System.out.println("#" + (i+1) + " " + hotel.getId() + " " + hotel.getNama());
                kamar.tampil();
            }
        
        } else {
            System.out.println("Tidak ada data fasilitas");
        }
    }
}
