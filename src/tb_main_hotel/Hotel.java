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
    
    Hotel(int id, String nama, String informasi){
        
        this.idHotel = id;
        this.nama = nama;
        this.informasi = informasi;
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
    
     
    public void tampil() {
    
        System.out.println("Hotel #" + this.idHotel + ": " + this.nama);
    }

}
