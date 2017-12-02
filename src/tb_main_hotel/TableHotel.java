/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andaresta
 */
public class TableHotel extends AbstractTableModel {
    
    private String[] columnNames = { "Id Hotel", "Nama", "Informasi" };
    private ListHotel listHotel;

    public TableHotel(ListHotel listHotel) {
    
        this.listHotel = listHotel;
    }
    
    public int getColumnCount() {
        
        return this.columnNames.length;
    }

    public int getRowCount() {
        
        return this.listHotel.count();
    }

    public String getColumnName(int col) {
        
        return this.columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        
        Hotel hotel = this.listHotel.get(row);
        if (hotel != null) {
            switch (col) {
                case 0: return hotel.getId();
                case 1: return hotel.getNama();
                case 2: return hotel.getInformasi();
            }
        }
        return "";
    }
}
