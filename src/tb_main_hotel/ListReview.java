/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.util.ArrayList;

/**
 *
 * @author Andaresta
 */
public class ListReview {
    private ArrayList<Review> reviewArray;
    
    public ListReview(){
        this.reviewArray = new ArrayList();
    }
    
    public int cari(int id) {
    
        int out = -1;
        if (this.reviewArray.size() > 0) {
            for (int i = 0; i < this.reviewArray.size(); i++) {
                Review review = this.reviewArray.get(i);
                if (review.getId() == id) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }
    
    public int doReview(String ulasan, int rating, Hotel h){
        Review review = new Review(ulasan, rating, h);
        
        this.reviewArray.add(review);
        review.setId(this.reviewArray.size());
        return review.getId();
    }
    
    public void deleteReview(int id){
        int i = this.cari(id);
        if (i > -1) {
            this.reviewArray.remove(i);
        } else {
            System.out.println("review tidak ada.");
        }
    }
    
    public void tampil() {
    
        if (this.reviewArray.size() > 0) {
            for (int i = 0; i < this.reviewArray.size(); i++) {
                Review review = this.reviewArray.get(i);
                //System.out.println("#" + (i+1) + " " + hotel.getId() + " " + hotel.getNama());
                review.tampil();
            }
        
        } else {
            System.out.println("Tidak ada data review");
        }
    }
}
