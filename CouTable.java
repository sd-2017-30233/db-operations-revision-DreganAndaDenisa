/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadata2;

/**
 *
 * @author Anda
 */

import javax.swing.table.AbstractTableModel;
public class CouTable  extends AbstractTableModel {

			private static final long serialVersionUID = 8780040575178841382L;

			private String[][] data;
			private String[] columnNames = { "CourseId", "CourseName","Teacher","Year"};
			
			public CouTable(Object[][] tabledata){
				this.data = (String[][]) tabledata;
			}
			

		    
    public int getColumnCount() {
        return columnNames.length;
    }

    public Object[][] getData() {
		return data;
	}


	public void setData(Object[][] tabledata) {
		this.data = (String[][]) tabledata;
	}


	public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

  
    public void setValueAt(String value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

	}
