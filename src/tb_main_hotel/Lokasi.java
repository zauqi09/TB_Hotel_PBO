/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

/**
 *
 * @author BINGLE
 */
public class Lokasi {

    
    
        private String kota;
    private String provinsi;
    
    public Lokasi(String kota, String provinsi){
        this.kota=kota;
        
        this.provinsi=provinsi;
    }
  
    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
    
    public void tampil() {
    
        System.out.println("Kota :" + this.kota + ", Provinsi " + this.provinsi);
    }
    
}
