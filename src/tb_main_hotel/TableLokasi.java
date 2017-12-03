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
public class TableLokasi {
    private String[] columnNames = { "IdLokasi", "Kota", "Provinsi" };
    private ListLokasi list;

    public TableLokasi(ListLokasi list) {
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
        
        Lokasi lok = this.list.get(row);
            if (lok != null) {
            switch (col) {
                case 0: return lok.getIdLokasi();
                case 1: return lok.getKota();
                case 2: return lok.getProvinsi();
            }
        }
        return "";
    }
}
