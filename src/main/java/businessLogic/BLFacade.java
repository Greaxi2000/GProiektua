package businessLogic;


import java.util.Collection;
import java.util.Date;
import java.util.Vector;

//import domain.Booking;
//import domain.Question;
//import domain.Event;
//import exceptions.EventFinished;
//import exceptions.QuestionAlreadyExist;

import javax.jws.WebMethod;
import javax.jws.WebService;

import domain.Bezero;
import domain.Dibisa;
import domain.Sukurtsal;
import domain.Transakzio;
import iterator.ExtendedIterator;

/**
 * Interface that specifies the business logic.
 */
@WebService
public interface BLFacade  {
	


	
	/**
	 * This method calls the data access to initialize the database with some events and questions.
	 * It is invoked only when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	@WebMethod public void initializeBD();

	@WebMethod public Bezero getUser(String nan);
   
	
	@WebMethod public Collection<Sukurtsal> getSukurtsalak();
	
	@WebMethod public Collection<Dibisa> getDibisak();
	
	@WebMethod public void dibisaSaldu(Integer kontID, Integer sukurID, String mota, float kop);
	
	@WebMethod public int dibisaErosi(Integer kontID, Integer sukurID, String mota, float kop);
	
	@WebMethod public ExtendedIterator getTransakzioak();
	
	@WebMethod public Vector<Transakzio> getTransakzioak2(); 

	
}
