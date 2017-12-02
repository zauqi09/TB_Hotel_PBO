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
public class Kamar {
     private int noKamar;
    private String jenis;
    private int jml_kasur;
    private int harga;
    
    public Kamar(int noKamar, String jenis, int jml_kasur){
        this.noKamar=noKamar;
        this.jenis=jenis;
        this.jml_kasur=jml_kasur;
        this.harga=harga;
    }

    public int getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(int noKamar) {
        this.noKamar = noKamar;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getJml_kasur() {
        return jml_kasur;
    }

    public void setJml_kasur(int jml_kasur) {
        this.jml_kasur = jml_kasur;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    public void tampil() {
    
        System.out.println("Kamar No. #" + this.noKamar+ ", Jenis: " + this.jenis+", Jml. Kasur: "+this.jml_kasur+", Harga: "+this.harga);
    }
}
