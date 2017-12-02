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
public class Review {
    private String ulasan;
    private int rating;
    private int idHotel;
    private int idReview = 0;
    
    
    public Review(int id, String ulasan, int rating, int idHotel){
       
        this.idReview = id;
        this.ulasan = ulasan;
        this.rating = rating;
        this.idHotel = idHotel;
    }
    
    
        

    /**
     * @return the ulasan
     */
    public String getUlasan() {
        return ulasan;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @return the hotel
     */
    public int getIdHotel() {
        return idHotel;
    }

    /**
     * @return the idReview
     */
    public int getId() {
        return idReview;
    }

    /**
     * @param idReview the idReview to set
     */
    public void setId(int idReview) {
        this.idReview = idReview;
    }
 
    public void tampil() {
    
  //      System.out.println("ID #" + this.idReview + " Rating : " + this.rating + "Hotel : "+ this.hotel.getNama() + "Ulasan :" + this.ulasan);
    }
}
