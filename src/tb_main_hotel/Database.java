package tb_main_hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andaresta
 */
public class Database {
    private String server = "jdbc:mysql://localhost/db_hotel";//nama database
    private String dbuser = "root";
    private String dbpasswd = "";
    private Connection connection = null;

    public Database() { //constructor untuk mengkoneksikan database
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        connect();//manggil method connect
    }
    public void connect() { //method untuk mengkoneksikan database 
        try {
            this.connection = DriverManager.getConnection(server, dbuser, dbpasswd);
            
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan saat koneksi");
        }
    }
    
    public ResultSet getData(String str) { //string disini merupakan query
        try{
            Statement statement = connection.createStatement();
            //System.out.println(str);
            ResultSet rs = statement.executeQuery(str);
            return rs;
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public boolean query(String str) { //string disini merupakan query
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
