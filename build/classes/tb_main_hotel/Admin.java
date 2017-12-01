/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Admin {
    private String nama;
    private String akun;
    private String password;
    private ArrayList<User> userList;

    public Admin(String nama, String akun, String password) {
        this.nama = nama;
        this.akun = akun;
        this.password = password;
        this.userList = new ArrayList<>();
    }
    
    public void deleteUser(String akun){
        boolean b = false;
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getAkun() == akun){
                userList.remove(i);
                System.out.println("User terhapus");
                b = true;
            }
        }
        if(b == false){
            System.out.println("User tidak ditemukan");
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(User user) {
        this.userList.add(user);
        System.out.println("User ditambahkan");
    }
}
