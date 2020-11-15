package businessLogic;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import javax.jws.WebMethod;
import javax.jws.WebService;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Bezero;
import domain.Dibisa;
import domain.Kontua;
import domain.Sukurtsal;
import domain.Transakzio;
import iterator.ExtendedIterator;
import iterator.transakzioExtendedIterator;

import java.util.ArrayList;
/**
 * It implements the business logic as a web service.
 */
@WebService(endpointInterface = "businessLogic.BLFacade")
public class BLFacadeImplementation implements BLFacade {
	
	private static final String INITIALIZE = "initialize";
	DataAccess dbManager;
	
	public BLFacadeImplementation()  {		
		System.out.println("Creating BLFacadeImplementation instance");
		ConfigXML c=ConfigXML.getInstance();
		
		boolean equals = c.getDataBaseOpenMode().equals(INITIALIZE);
		if (equals) {
			DataAccess dbManager=new DataAccess(equals);
			dbManager.initializeDB();
			dbManager.close();
			}
		
	}
	public BLFacadeImplementation(DataAccess da)  {		
		System.out.println("Creating BLFacadeImplementation instance");
		ConfigXML c=ConfigXML.getInstance();
		
		if (c.getDataBaseOpenMode().equals(INITIALIZE)) {
			da.open(true);
			da.initializeDB();
			da.close();
			}
			dbManager=da;
	}

	@Override
	public void initializeBD() {
		
	}
	@Override
	public Bezero getUser(String nan) {
		dbManager.open(false);
		return dbManager.getUser(nan);
	}
	
	@WebMethod
	public Collection<Sukurtsal> getSukurtsalak(){
		dbManager.open(false);
		return dbManager.getSukurtsalak();
		
	}
	@WebMethod
	public Collection<Dibisa> getDibisak(){
		dbManager.open(false);
		return dbManager.getDibisak();
		
	}

	@WebMethod
	public void dibisaSaldu(Integer kontID, Integer sukurID, String mota, float kop){
		dbManager.open(false);
		dbManager.dibisaSaldu(kontID, sukurID, mota, kop);
		
	}
	@WebMethod
	public int dibisaErosi(Integer kontID, Integer sukurID, String mota, float kop){
		dbManager.open(false);
		return dbManager.dibisaErosi(kontID, sukurID, mota, kop);
		
	}
	@Override
	public ExtendedIterator getTransakzioak() {
		// TODO Auto-generated method stub
		dbManager.open(false);
		return new transakzioExtendedIterator(new ArrayList<Transakzio>(dbManager.getTransakzioak()));
	}
	
	@Override
	public Vector<Transakzio> getTransakzioak2() {
		// TODO Auto-generated method stub
		dbManager.open(false);
		return dbManager.getTransakzioak();
	}


	
	

}

