/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import tb_main_hotel.UI.GUIListHotel;

/**
 *
 * @author Andaresta
 */
public class TB_Main_Hotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        // TODO code application logic here
        ListHotel lhotel = new ListHotel();
        lhotel.tambah(1, "hotela", "bintang5");
        lhotel.tambah(2, "hotelb", "bintang5");
        //lhotel.delete("hotela");
        lhotel.tampil();
       
        int i = lhotel.cari("hotelb");
        if (i > -1) {
            Hotel hotel = lhotel.get(i);
            //System.out.println(hotel.getNama());
            hotel.tampil();
        }
        
        ListReservasi lreserv = new ListReservasi();
        int rid = lreserv.doReservation(new Date(2017, 3, 9), 2, lhotel.get("hotelb"));
        lreserv.tampil();
        
        ListReview lreview = new ListReview();
        int rsid = lreview.doReview("bagus", 10, lhotel.get("hotelb"));
        lreview.tampil();
        
        ListUser luser  = new ListUser();
        luser.tambah("user1", "user01", "123");
        luser.tambah("user1", "user01", "123");
        luser.tampil();
*/
        
        GUIListHotel view = new GUIListHotel();
        view.setVisible(true);
    }
    
}
