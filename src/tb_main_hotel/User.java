/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

/**
 *
 * @author User
 */
public class User {
    private String nama;
    private String akun;
    private String password;

    public User(String nama, String akun, String password) {
        this.nama = nama;
        this.akun = akun;
        this.password = password;
    }
    
    public void updateNama(String nama){
        this.nama = nama;
    }
    
    public void updatePassword(String password){
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public String getAkun() {
        return akun;
    }
}
