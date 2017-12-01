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
 * @author Andaresta
 */
public class ListReservasi {
    
    private ArrayList<Reservasi> reservasiArray;
    
    public ListReservasi(){
        this.reservasiArray = new ArrayList();
    }
    
    public int cari(int id) {
    
        int out = -1;
        if (this.reservasiArray.size() > 0) {
            for (int i = 0; i < this.reservasiArray.size(); i++) {
                Reservasi reservasi = this.reservasiArray.get(i);
                if (reservasi.getId() == id) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }

    public int cari(String nama) {
    
        int out = -1;
        if (this.reservasiArray.size() > 0) {
            for (int i = 0; i < this.reservasiArray.size(); i++) {
                Reservasi reservasi = this.reservasiArray.get(i);
                if (nama.equals(reservasi.getHotel().getNama())) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }
    
    public int doReservation(Date tgl, int jumOrang, Hotel h){
        Reservasi reservasi = new Reservasi(tgl, jumOrang, h);
        
        this.reservasiArray.add(reservasi);
        reservasi.setId(this.reservasiArray.size());
        return reservasi.getId();
    }
    
    public void cancleReserv(int id){
        int i = this.cari(id);
        if (i > -1) {
            this.reservasiArray.remove(i);
        } else {
            System.out.println("reservasi tidak ada.");
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
}
