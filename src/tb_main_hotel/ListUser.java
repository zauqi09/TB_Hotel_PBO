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
public class ListUser {
     private ArrayList<User> userArray;
    
    public ListUser() {
    
        this.userArray = new ArrayList();
    }
    
    public int cari(String akun) {
    
        int out = -1;
        if (this.userArray.size() > 0) {
            for (int i = 0; i < this.userArray.size(); i++) {
                User user = this.userArray.get(i);
                if (user.getAkun().equals(akun)) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }
    
    public User get(String akun) {
    
        int index = this.cari(akun);
        if ((index > -1) && (index < this.userArray.size())) {
            return this.userArray.get(index);
        } else {
            return null;
        }
    }
    
    public void tambah(String nama, String akun, String password){
        
        User user = new User(nama, akun, password);
        
        if (this.cari(akun) > -1) {
            System.out.println("user sudah terdaftar.");
        } else {
            this.userArray.add(user);
        }            
    }
    
    public void tampil() {
    
        if (this.userArray.size() > 0) {
            for (int i = 0; i < this.userArray.size(); i++) {
                User user = this.userArray.get(i);
                //System.out.println("#" + (i+1) + " " + hotel.getId() + " " + hotel.getNama());
                user.tampil();
            }
        
        } else {
            System.out.println("Tidak ada data user");
        }
    }
}
