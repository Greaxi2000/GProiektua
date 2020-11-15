package iterator;

import java.net.MalformedURLException;

import businessLogic.BLFacade;
import businessLogic.BLFacadeFactory;
import domain.Transakzio;

public class iteratorApp {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		boolean isLocal=true;
		
		BLFacadeFactory  BLFF= new BLFacadeFactory();
		
		BLFacade facadeInterface= BLFF.createBLFacade(isLocal);
		
		ExtendedIterator i = facadeInterface.getTransakzioak();
		
		Transakzio t;
		
		i.goLast();
		while(i.hasPrevious()) {
			t=(Transakzio) i.previous();
			System.out.println("Data: "+ t.getData() + ", eragiketa: " + t.getEragiketa() + ", Kontua: " + t.getKontu().getID());
		}
		System.out.println("");
		i.goFirst();
		while(i.hasNext()) {
			t=(Transakzio) i.next();
			System.out.println("Data: "+ t.getData() + ", eragiketa: " + t.getEragiketa() + ", Kontua: " + t.getKontu().getID());
		}
	}

}
