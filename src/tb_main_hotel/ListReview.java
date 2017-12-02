/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import tb_main_hotel.Hotel;

/**
 *
 * @author Andaresta
 */
public class ListReview {
    
    private Database db;
    private ArrayList<Review> reviewArray;
    private int idHotel;
    
    public ListReview(Database db, int idHotel){
        
        this.db = db;
        this.idHotel = idHotel;
        this.reviewArray = new ArrayList();
    }
    
    public int refesh() {

        try{
            ResultSet rs = this.db.getData("select idReview, ulasan, rating from review where (idHotel = " + this.idHotel + ")");
            
            this.reviewArray.clear();
            while(rs.next()){    
                Review review = new Review(rs.getInt(1), rs.getString(2), rs.getInt(3), this.idHotel);
                this.reviewArray.add(review);   
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Error load review " +e.getMessage());
        }
        return this.reviewArray.size();
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
    
    public Review get(int index) {
    
        if ((index > -1) && (index < this.reviewArray.size())) {
            return this.reviewArray.get(index);
        } else {
            return null;
        }
    }

    public int count() {
    
        return this.reviewArray.size();
    }
    
    public int doReview(String ulasan, int rating){
        
         int hasil = 0;
        
        /*id otomatis */
        int id = this.reviewArray.size()+1;
        System.out.println("insert into review (idReview, ulasan, rating, idHotel) values (" + id + ", '" + ulasan + "', '" + rating + "', " + this.idHotel +")");
        /* simpan ke db */
        if (this.db.query("insert into review (idReview, ulasan, rating, idHotel) values (" + id + ", '" + ulasan + "', '" + rating + "', " + this.idHotel +")")) {
            /* add ke list */
            Review review = new Review(id , ulasan, rating, this.idHotel);
            this.reviewArray.add(review);

        } else {
            hasil = 2;
        }
        return hasil;
    }
    
    public boolean deleteReview(int id){
    
        int i = this.cari(id);
        if (i > -1) {
            try {
                if (this.db.query("delete from review where (idHotel = " + this.idHotel + ") and (idReview = " + id + ")")) {
                    this.reviewArray.remove(i);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        } else {
            System.out.println("review tidak ada.");
            return false;
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
    
    public void tampil(JTable jtable) {
        
        TableReview data = new TableReview(this);
        jtable.setModel(data);
        /*
        if (this.hotelArray.size() > 0) {
            for (int j = 0; j < this.hotelArray.size(); j++) {
                jtable.setValueAt(this.hotelArray.get(j).getId(), j, 0);
                jtable.setValueAt(this.hotelArray.get(j).getNama(), j, 1);
                jtable.setValueAt(this.hotelArray.get(j).getInformasi(), j, 2);
            }
        }
        */
    }
}
