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
public class Fasilitas {
    private int idfasilitas;
    private String nama;
    private String deskripsi;
    private int idHotel;
    
    public Fasilitas(int id2, String nama_fasilitas, String deskripsi, int id){
        this.idfasilitas = id2;
        this.nama = nama_fasilitas;
        this.deskripsi = deskripsi;
        this.idHotel = id;
    }
    
   

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getIdfasilitas() {
        return idfasilitas;
    }

    public void setIdfasilitas(int idfasilitas) {
        this.idfasilitas = idfasilitas;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
    public void display() {
    
  //      System.out.println("ID #" + this.idReview + " Rating : " + this.rating + "Hotel : "+ this.hotel.getNama() + "Ulasan :" + this.ulasan);
    }
}
