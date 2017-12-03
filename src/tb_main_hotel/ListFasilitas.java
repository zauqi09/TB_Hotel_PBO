/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author BINGLE
 */
public class ListFasilitas {
    private Database db;
    private ArrayList<Fasilitas> fasarray;
    private int idHotel;
    
    public ListFasilitas(Database db, int idHotel){
        
        this.db = db;
        this.idHotel = idHotel;
        this.fasarray = new ArrayList();
    }
    
     public int refesh() {

        try{
            ResultSet rs = this.db.getData("select nama, deskripsi from fasilitas where (idHotel = " + this.idHotel + ")");
            
            this.fasarray.clear();
            while(rs.next()){    
                Fasilitas fasarray = new Fasilitas(rs.getInt(1), rs.getString(2), rs.getString(3), this.idHotel);
                this.fasarray.add(fasarray);   
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Error load review " +e.getMessage());
        }
        return this.fasarray.size();
    }
     
     public int cari(int id) {
    
        int out = -1;
        if (this.fasarray.size() > 0) {
            for (int i = 0; i < this.fasarray.size(); i++) {
                Fasilitas fasarray = this.fasarray.get(i);
                if (fasarray.getIdfasilitas() == id) {
                    out = i;
                    break;
                }
            }
        }
        return out;
    }
    


    public int count() {
    
        return this.fasarray.size();
    }
    
      public Fasilitas get(int index) {
    
        if ((index > -1) && (index < this.fasarray.size())) {
            return this.fasarray.get(index);
        } else {
            return null;
        }
    }
      

     
    public boolean deleteFasilitas(int id){
    
        int i = this.cari(id);
        if (i > -1) {
            try {
                if (this.db.query("delete from fasilitas where (idHotel = " + this.idHotel + ") and (idfasilitas = " + id + ")")) {
                    this.fasarray.remove(i);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        } else {
            System.out.println("fasilitas tidak ada.");
            return false;
        }
    
    }
    
    public void tampil() {
    
        if (this.fasarray.size() > 0) {
            for (int i = 0; i < this.fasarray.size(); i++) {
                Fasilitas fasarray = this.fasarray.get(i);
                //System.out.println("#" + (i+1) + " " + hotel.getId() + " " + hotel.getNama());
                fasarray.display();
            }
        
        } else {
            System.out.println("Tidak ada fasilitas");
        }
    }
    
    public void tampil(JTable jtable) {
        
        TableFasilitas data = new TableFasilitas(this);
        jtable.setModel((TableModel) data);
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

    public void tampil(JComboBox jcombo) {
        
        jcombo.removeAllItems();
        if (this.fasarray.size() > 0) {
            for (int i = 0; i < this.fasarray.size(); i++) {
                Fasilitas fasarray = this.fasarray.get(i);
                jcombo.addItem(fasarray.getIdfasilitas());
            }
        }

    }

    public int addFasilitas(String fasilitas, String deskripsi) {
                
         int hasil = 0;
        
        /*id otomatis */
        int id = this.fasarray.size()+1;
        System.out.println("insert into fasilitas (idfasilitas, fasilitas, deskripsi, idHotel) values (" + id + ", '" + fasilitas + "', '" + deskripsi + "', " + this.idHotel +")");
        /* simpan ke db */
        if (this.db.query("insert into fasilitas (idfasilitas, fasilitas, deskripsi, idHotel) values (" + id+ ", '" + fasilitas + "', '" + deskripsi + "', " + this.idHotel +")")) {
            /* add ke list */
            Fasilitas fasarray = new Fasilitas(id, fasilitas, deskripsi, this.idHotel);
            this.fasarray.add(fasarray);

        } else {
            hasil = 2;
        }
        return hasil;
    }
}
