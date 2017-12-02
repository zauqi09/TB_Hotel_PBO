/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andaresta
 */
public class TableReservasi extends AbstractTableModel {
    private String[] columnNames = { "Id Reservasi", "No Kamar", "Tanggal", "Jumlah Orang" };
    private ListReservasi listReservasi;

    public TableReservasi(ListReservasi listReservasi) {
    
        this.listReservasi = listReservasi;
    }
    
    public int getColumnCount() {
        
        return this.columnNames.length;
    }

    public int getRowCount() {
        
        return this.listReservasi.count();
    }

    public String getColumnName(int col) {
        
        return this.columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        
        Reservasi reservasi = this.listReservasi.get(row);
        if (reservasi != null) {
            switch (col) {
                case 0: return reservasi.getIdReservasi();
                case 1: return reservasi.getNoKamar();
                case 2: 
                    DateFormat fmt = new SimpleDateFormat("dd MMM yyyy");
                    Date d = reservasi.getTgl();
                    return fmt.format(d);
                case 3: return reservasi.getJumOrang();
            }
        }
        return "";
    }
}
