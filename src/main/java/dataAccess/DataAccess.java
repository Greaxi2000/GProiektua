package dataAccess;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import configuration.ConfigXML;
import configuration.UtilDate;
import domain.Bezero;
import domain.Dibisa;
import domain.Kontua;
import domain.Sukurtsal;
import domain.SukurtsalDibisa;
import domain.Transakzio;

/**
 * It implements the data access to the objectDb database
 */
public class DataAccess {
	protected static EntityManager db;
	protected static EntityManagerFactory emf;

	// HEMEN IMPLEMENTATU BEHAR DIRA LOGIN ETA REGISTERED
	ConfigXML c;
	private static final String GORDETA = "gordeta ";
	private Sukurtsal sukurtsal;
	
	public DataAccess(boolean initializeMode) {

		c = ConfigXML.getInstance();

		System.out.println("Creating DataAccess instance => isDatabaseLocal: " + c.isDatabaseLocal()
				+ " getDatabBaseOpenMode: " + c.getDataBaseOpenMode());

		String fileName = c.getDbFilename();
		if (initializeMode)
			fileName = fileName + ";drop";

		if (c.isDatabaseLocal()) {
			emf = Persistence.createEntityManagerFactory("objectdb:" + fileName);
			db = emf.createEntityManager();
		} else {
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("javax.persistence.jdbc.user", c.getUser());
			properties.put("javax.persistence.jdbc.password", c.getPassword());

			emf = Persistence.createEntityManagerFactory(
					"objectdb://" + c.getDatabaseNode() + ":" + c.getDatabasePort() + "/" + fileName, properties);

			db = emf.createEntityManager();
		}
	}
	public void open(boolean initializeMode) {
		c = ConfigXML.getInstance();

		System.out.println("Creating DataAccess instance => isDatabaseLocal: " + c.isDatabaseLocal()
				+ " getDatabBaseOpenMode: " + c.getDataBaseOpenMode());

		String fileName = c.getDbFilename();
		if (initializeMode)
			fileName = fileName + ";drop";

		if (c.isDatabaseLocal()) {
			emf = Persistence.createEntityManagerFactory("objectdb:" + fileName);
			db = emf.createEntityManager();
		} else {
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("javax.persistence.jdbc.user", c.getUser());
			properties.put("javax.persistence.jdbc.password", c.getPassword());

			emf = Persistence.createEntityManagerFactory(
					"objectdb://" + c.getDatabaseNode() + ":" + c.getDatabasePort() + "/" + fileName, properties);

			db = emf.createEntityManager();
		}
	}

	public DataAccess() {
		new DataAccess(false);
	}

	/**
	 * This is the data access method that initializes the database with some events
	 * and questions. This method is invoked by the business logic (constructor of
	 * BLFacadeImplementation) when the option "initialize" is declared in the tag
	 * dataBaseOpenMode of resources/config.xml file
	 */
	public void initializeDB() {
		
		

		db.getTransaction().begin();
		
		try {

			Calendar today = Calendar.getInstance();

			int month = today.get(Calendar.MONTH);
			month += 1;
			int year = today.get(Calendar.YEAR);
			if (month == 12) {
				month = 0;
				year += 1;
			}


			db.getTransaction().commit();
			System.out.println("Db initialized");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public void close() {
		db.close();
		System.out.println("DataBase closed");
	}

	public Bezero getUser(String nan) {
		
		return db.find(Bezero.class, nan);
	}
	
	
	
	
public Collection<Sukurtsal> getSukurtsalak(){
	
	    TypedQuery<Sukurtsal> query = db.createQuery("SELECT s FROM Sukurtsal s", Sukurtsal.class);
	    
	    List<Sukurtsal> sukurtsalak = query.getResultList();
	    return sukurtsalak;
	
}

public Collection<Dibisa> getDibisak(){
	
    TypedQuery<Dibisa> query = db.createQuery("SELECT d FROM Dibisa d", Dibisa.class);
  
    return query.getResultList();

}

public void dibisaSaldu(Integer kontID, Integer sukurID, String mota, float kop) {
	Kontua kontua = db.find(Kontua.class, kontID);
	Sukurtsal Sukurtsal = db.find(Sukurtsal.class, sukurID);
	Dibisa dibisa = db.find(Dibisa.class, mota);
	SukurtsalDibisa sukDib = Sukurtsal.getSukurtsalDibisa(dibisa);
    SukurtsalDibisa sd = db.find(SukurtsalDibisa.class, sukDib.getId());
	int komisio = sd.getKomisioa();
	float euroKop;
	float prezioEuroko = dibisa.getBalioEur();
	float kendu;
	euroKop = kop/prezioEuroko;
	
	
	
	kendu = (float)(euroKop*komisio)/100;
	euroKop = euroKop - kendu;
	
	db.getTransaction().begin();
	sd.batuEtaSetKop(kop);
	
	db.persist(sd);
	db.getTransaction().commit();
	System.out.println(GORDETA + sd);
	
	db.getTransaction().begin();
	kontua.batuEtaSetDiruKop(euroKop);
	db.persist(kontua);
	db.getTransaction().commit();
	System.out.println(GORDETA + kontua);
	
	Date date = new Date();; 
	Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
	cal.setTime(date);
	
	db.getTransaction().begin();
	Transakzio trans = new Transakzio(date, "Dibisak saldu", kontua);
	db.persist(trans);
	db.getTransaction().commit();
	System.out.println(GORDETA + trans);
	
	db.getTransaction().begin();
	kontua.addTransakzio(trans);
	db.persist(kontua);
	db.getTransaction().commit();
}

public int dibisaErosi(Integer kontID, Integer sukurID, String mota, float kop) {
	Kontua kontua = db.find(Kontua.class, kontID);
	sukurtsal = db.find(Sukurtsal.class, sukurID);
	Dibisa dibisa = db.find(Dibisa.class, mota);	

	SukurtsalDibisa sukDib = sukurtsal.getSukurtsalDibisa(dibisa);
    SukurtsalDibisa sd = db.find(SukurtsalDibisa.class, sukDib.getId());
	int komisio = sd.getKomisioa();
	float euroKop;
	float prezioEuroko = dibisa.getBalioEur();
	float batu;
	euroKop = kop/prezioEuroko;
	
	batu = (float)(euroKop*komisio)/100;
	euroKop = euroKop + batu;
	if(kop > sd.getKop() ) {
		return 1;
	}
	else if(euroKop > kontua.getDiruKop()) {
		return 2;
	}
	else {
	db.getTransaction().begin();
	sd.kenduEtaSetKop(kop);
	
	db.persist(sd);
	db.getTransaction().commit();
	System.out.println(GORDETA + sd);
	
	db.getTransaction().begin();
	kontua.kenduEtaSetDiruKop(euroKop);
	db.persist(kontua);
	db.getTransaction().commit();
	System.out.println(GORDETA + kontua);
	
	Date date = new Date();; 
	Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
	cal.setTime(date);
	
	db.getTransaction().begin();
	Transakzio trans = new Transakzio(date, "Dibisak erosi", kontua);
	db.persist(trans);
	db.getTransaction().commit();
	System.out.println(GORDETA + trans);
	
	db.getTransaction().begin();
	kontua.addTransakzio(trans);
	db.persist(kontua);
	db.getTransaction().commit();
	
	
	
	return 0;
	}
}





}
