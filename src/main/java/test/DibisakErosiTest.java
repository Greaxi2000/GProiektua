package test;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;
import org.mockito.Mockito;

import dataAccess.DataAccess;
import domain.Bezero;
import domain.Dibisa;
import domain.Kontua;
import domain.Sukurtsal;
import domain.SukurtsalDibisa;

public class DibisakErosiTest {

	private final DataAccess db = new DataAccess(true);
	
	@Test
	public void testBiakZero() {
		
		
			int kontID = 0;
			int sukurID = 0;
			String mota = "USD";
			float kop = (float)3000000.2;
			
			int emaitza = db.dibisaErosi(kontID, sukurID, mota, kop);
			System.out.println(emaitza);
			assertTrue(emaitza == 1);
			
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
