/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

/**
 *
 * @author Andaresta
 */
public class Kamar {
    private int noKamar;
    private String jenis;
    private int jmlKasur;
    private int harga;
    private int idHotel;
    
    public Kamar(int id, String jenis, int jmlKasur, int harga, int idHotel){
        this.noKamar = id;
        this.jenis = jenis;
        this.jmlKasur = jmlKasur;
        this.harga = harga;
        this.idHotel = idHotel;
    }

    /**
     * @return the noKamar
     */
    public int getNoKamar() {
        return noKamar;
    }

    /**
     * @return the jenis
     */
    public String getJenis() {
        return jenis;
    }

    /**
     * @return the jmlKasur
     */
    public int getJmlKasur() {
        return jmlKasur;
    }

    /**
     * @return the harga
     */
    public int getHarga() {
        return harga;
    }

    /**
     * @return the idHotel
     */
    public int getIdHotel() {
        return idHotel;
    }
    
    public void tampil() {
    
  //      System.out.println("ID #" + this.idReview + " Rating : " + this.rating + "Hotel : "+ this.hotel.getNama() + "Ulasan :" + this.ulasan);
    }
    
    
}
