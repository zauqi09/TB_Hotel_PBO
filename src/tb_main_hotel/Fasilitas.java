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
    private int id;
     private String nama_fasilitas;
    private String deskripsi;
    
    public Fasilitas(int id, String nama_fasilitas, String deskripsi){
        this.nama_fasilitas = nama_fasilitas;
        this.deskripsi = deskripsi;
    }
    


    public String getNama_fasilitas() {
        return nama_fasilitas;
    }

    public void setNama_fasilitas(String nama_fasilitas) {
        this.nama_fasilitas = nama_fasilitas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public void tampil() {
    
        System.out.println("Fasilitas #" + this.id + ": " + this.nama_fasilitas);
    }
}
