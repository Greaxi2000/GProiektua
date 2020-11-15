package businessLogic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;

public class BLFacadeFactory {

	public BLFacadeFactory() {}
	
	public BLFacade createBLFacade(boolean local) throws MalformedURLException {
	    
		ConfigXML c=ConfigXML.getInstance();
		
		if (local) {
			 
			 DataAccess da = new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
			 return new BLFacadeImplementation(da);		
			}
			else { //If remote			
				 String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
				URL url = new URL(serviceName);
		        QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");		 
		        Service service = Service.create(url, qname);	 
		         return service.getPort(BLFacade.class);
			} 
		
		
	}
	
	
}
