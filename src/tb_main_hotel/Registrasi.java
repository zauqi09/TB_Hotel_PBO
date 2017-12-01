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
public class Registrasi {
    private String nama;
    private String akun;
    private String password;
    private Admin admin;

    public User tambahUser(String nama, String akun, String password){
       User u = new User(nama, akun, password);
       return u;
    }
}
