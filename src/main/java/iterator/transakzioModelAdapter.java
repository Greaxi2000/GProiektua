package iterator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Transakzio;

public class transakzioModelAdapter extends AbstractTableModel{

	
	
	private final List<Transakzio> transakzioak;
	 private String[] colNames = new String[] {"Data", "Eragiketa mota", "Kontua"};
	
	 public transakzioModelAdapter(List<Transakzio> t) {
	 //copy the HashMap data to a sequential data structure
	 transakzioak= t;
	 
	 }
	 @Override
	 public Object getValueAt(int rowIndex, int columnIndex) {
	 switch(columnIndex) {
	 case 0: return ((Object) transakzioak.get(rowIndex).getData());
	 case 1: return ((Object) transakzioak.get(rowIndex).getEragiketa());
	 case 2: return ((Object) transakzioak.get(rowIndex).getKontu().getID());
	 }
	 return null;
	 }
	 @Override
	 public String getColumnName(int col) {
	 return colNames[col];
	 }
	 @Override
	 public int getColumnCount() {
	 return 3;
	 }
	 @Override
	 public int getRowCount() {
	 return transakzioak.size(); }
	}
	

