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
public class TableKamar  extends AbstractTableModel{
    private String[] columnNames = { "noKamar", "Jenis", "jmlKasur", "Harga" };
    private ListKamar listKamar;

    public TableKamar(ListKamar listKamar) {
    
        this.listKamar = listKamar;
    }
    
    public int getColumnCount() {
        
        return this.columnNames.length;
    }

    public int getRowCount() {
        
        return this.listKamar.count();
    }

    public String getColumnName(int col) {
        
        return this.columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        
        Kamar kamar = this.listKamar.get(row);
        if (kamar != null) {
            switch (col) {
                case 0: return kamar.getNoKamar();
                case 1: return kamar.getJenis();
                case 2: return kamar.getJmlKasur();
                case 3: return kamar.getHarga();
            }
        }
        return "";
    }
}
