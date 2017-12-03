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
    private int idLokasi;
    private String kota;
    private String provinsi;
    private int idHotel;
    
    public Lokasi(int id,String kota, String provinsi,int idHotel){
        this.idLokasi=id;
        this.kota=kota;
        this.provinsi=provinsi;
        this.idHotel=idHotel;
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

    public int getIdLokasi() {
        return idLokasi;
    }

    public void setIdLokasi(int idLokasi) {
        this.idLokasi = idLokasi;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
    
    public void display() {
    
//        System.out.println("kota : " + this.kota+"provinsi : "+this.provinsi);
    }
}
