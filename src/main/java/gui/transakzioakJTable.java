package gui;

import java.net.MalformedURLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.BLFacade;
import businessLogic.BLFacadeFactory;
import domain.Transakzio;
import iterator.transakzioModelAdapter;

public class transakzioakJTable {

	
	public static void main(String[] args) throws MalformedURLException {
		
		boolean isLocal=true;
		
		BLFacadeFactory  BLFF= new BLFacadeFactory();
		
		BLFacade facadeInterface= BLFF.createBLFacade(isLocal);
		
		Vector<Transakzio> t = facadeInterface.getTransakzioak2();
		

		transakzioModelAdapter model=new transakzioModelAdapter(t);

		JFrame j=new JFrame();
		JTable table = new JTable(model);
		j.add(new JScrollPane(table));

		 j.setTitle("Transakzioak");
		 j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 j.pack();
		 j.setVisible(true);
		 } 
}
