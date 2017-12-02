/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andaresta
 */
public class Hotel {

    private int idHotel = 0;
    private String nama;
    private String informasi;
    private ListReview listReview;
    private ListKamar listKamar;
    private ListReservasi listReservasi;
    
    public Hotel(int id, String nama, String informasi){
        
        this.idHotel = id;
        this.nama = nama;
        this.informasi = informasi;
        this.listReview = new ListReview(new Database(), id);
        this.listKamar = new ListKamar(new Database(), id);
        this.listReservasi = new ListReservasi(new Database(), id);
    }

    /**
     * @return the id
     */
    public int getId() {
        
        return idHotel;
    }
    
    public String getNama() {
        
        return nama;
    }
    
    /**
     * @return the informasi
     */
    public String getInformasi() {
        return informasi;
    }
    
    
    public ListReview getReview() {
    
        this.listReview.refesh();
        return this.listReview;
    }
     
    public ListKamar getKamar() {
        this.listKamar.refesh();
        return this.listKamar;
    }
    
     public ListReservasi getReservasi() {
        this.listReservasi.refesh();
        return this.listReservasi;
    }   
    
    public void tampil() {
    
        System.out.println("Hotel #" + this.idHotel + ": " + this.nama);
    }

}
