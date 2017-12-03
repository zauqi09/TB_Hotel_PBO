/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tb_main_hotel;

/**
 *
 * @author BINGLE
 */
public class TableFasilitas {
    private String[] columnNames = { "IdFasilitas", "Fasilitas", "Deskripsi" };
    private ListFasilitas list;

    public TableFasilitas(ListFasilitas list) {
        this.list = list;
    }
    
    public int getColumnCount() {
        
        return this.columnNames.length;
    }

    public int getRowCount() {    
        return this.list.count();
    }

    public String getColumnName(int col) {  
        return this.columnNames[col];
    }
 public Object getValueAt(int row, int col) {
        
        Fasilitas fasilitas = this.list.get(row);
            if (fasilitas != null) {
            switch (col) {
                case 0: return fasilitas.getIdfasilitas();
                case 1: return fasilitas.getNama();
                case 2: return fasilitas.getDeskripsi();
            }
        }
        return "";
    }
}

