/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.util.Date;


/**
 *
 * @author Andaresta
 */
public class Reservasi {
    private int idReservasi = 0;
    private Date tgl;
    private int jumOrang;
    private int idHotel ;
    private int noKamar;
    
    public Reservasi(int id, Date tgl, int jumOrang, int idHotel, int noKamar) {
        this.idReservasi = id;
        this.tgl = tgl;
        this.jumOrang = jumOrang;
        this.idHotel = idHotel;
        this.noKamar = noKamar;
    }    
    
    /**
     * @return the tgl
     */
    public Date getTgl() {
        return tgl;
    }

    /**
     * @return the jumOrang
     */
    public int getJumOrang() {
        return jumOrang;
    }

  

    /**
     * @return the idReservasi
     */
 
    public void setId(int id) {
    
        this.idReservasi = id;
    }
    
    public void tampil() {
    
        //System.out.println("ID #" + this.idReservasi + ": " + this.tgl + " Jumlah orang : " + this.jumOrang + "Hotel : "+ this.hotel.getNama());
    }

    /**
     * @return the idReservasi
     */
    public int getIdReservasi() {
        return idReservasi;
    }

    /**
     * @return the idHotel
     */
    public int getIdHotel() {
        return idHotel;
    }

    /**
     * @return the noKamar
     */
    public int getNoKamar() {
        return noKamar;
    }
    
    
}
    
    

