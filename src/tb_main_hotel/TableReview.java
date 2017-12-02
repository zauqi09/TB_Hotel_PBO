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
public class TableReview extends AbstractTableModel {
    
    private String[] columnNames = { "Id Review", "Ulasan", "Rating" };
    private ListReview listReview;

    public TableReview(ListReview listReview) {
    
        this.listReview = listReview;
    }
    
    public int getColumnCount() {
        
        return this.columnNames.length;
    }

    public int getRowCount() {
        
        return this.listReview.count();
    }

    public String getColumnName(int col) {
        
        return this.columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        
        Review review = this.listReview.get(row);
        if (review != null) {
            switch (col) {
                case 0: return review.getId();
                case 1: return review.getUlasan();
                case 2: return review.getRating();
            }
        }
        return "";
    }
}
