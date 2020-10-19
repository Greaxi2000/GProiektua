package test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Bezero;
import domain.Dibisa;
import domain.Kontua;
import domain.Sukurtsal;
import domain.SukurtsalDibisa;
import domain.Transakzio;


public class MockitoDibisakErosiTest {
     DataAccess dataAccess=Mockito.mock(DataAccess.class);
     EntityManager mockedEM=Mockito.mock(EntityManager.class);
     Sukurtsal mockedSukurtsal = Mockito.mock(Sukurtsal.class);
     Dibisa mockedDibisa = Mockito.mock(Dibisa.class);
     Calendar mockedCalendar = Mockito.mock(Calendar.class);
     Transakzio mockedTransakzio = Mockito.mock(Transakzio.class);
     SukurtsalDibisa mockedSK = Mockito.mock(SukurtsalDibisa.class);
     Kontua mockedKontua = Mockito.mock(Kontua.class);
     
	@InjectMocks
	 BLFacade sut=new BLFacadeImplementation(dataAccess);
	
	//sut.createQuestion:  The event has one question with a queryText. 
    
	
	
	@Test
	public void test1() {
		try {
			
			int kontID = 2;
			int sukurID = 2;
			String mota = "USD";
			float kop = (float)30.2;
			
			Mockito.doReturn(null).when(mockedEM).find(Kontua.class, Mockito.anyInt());
			
			sut.dibisaErosi(kontID, sukurID, mota, kop);
			assertTrue(false);
		}catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test2() {
		try {
			
			int kontID = 2;
			int sukurID = 2;
			String mota = "USD";
			float kop = (float)30.2;
			
			Bezero bezero = new Bezero("495752237W", "Asier", "Legorburu");
			
			
			
			Mockito.doReturn(new Kontua(kontID, 1000, bezero)).when(mockedEM).find(Kontua.class,  Mockito.anyInt());
			Mockito.doReturn(null).when(mockedEM).find(Sukurtsal.class, sukurID);
			
			sut.dibisaErosi(kontID, sukurID, mota, kop);
			assertTrue(false);
			
		}catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test3() {
		try {
			
			int kontID = 2;
			int sukurID = 2;
			String mota = "USD";
			float kop = (float)30.2;
			
			Bezero bezero = new Bezero("495752237W", "Asier", "Legorburu");
			
			
			
			Mockito.doReturn(new Kontua(kontID, 1000, bezero)).when(mockedEM).find(Kontua.class,  Mockito.anyInt());
			Mockito.doReturn(new Sukurtsal(2,"Donostia")).when(mockedEM).find(Sukurtsal.class, Mockito.anyInt());
			Mockito.doReturn(null).when(mockedEM).find(Dibisa.class, Mockito.anyString());
			
			
			sut.dibisaErosi(kontID, sukurID, mota, kop);
			assertTrue(false);
			
		}catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test4() {
		try {
			
			int kontID = 2;
			int sukurID = 2;
			String mota = "USD";
			float kop = (float)30.2;
			
			Bezero bezero = new Bezero("495752237W", "Asier", "Legorburu");
			
			
			
			Mockito.doReturn(new Kontua(kontID, 1000, bezero)).when(mockedEM).find(Kontua.class,  Mockito.anyInt());
			Mockito.doReturn(new Sukurtsal(2,"Donostia")).when(mockedEM).find(Sukurtsal.class, Mockito.anyInt());
			Mockito.doReturn(new Dibisa("USD", (float)0.84)).when(mockedEM).find(Dibisa.class, Mockito.anyString());
			Mockito.doReturn(null).when(mockedSukurtsal).getSukurtsalDibisa(Mockito.any(Dibisa.class));
			
			sut.dibisaErosi(kontID, sukurID, mota, kop);
			assertTrue(false);
			
		}catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test5() {
		try {
			
			int kontID = 2;
			int sukurID = 2;
			String mota = "USD";
			float kop = (float)30.2;
			
			Sukurtsal sukurtsal = new Sukurtsal(2,"Donostia");
			Dibisa dibisa = new Dibisa("USD", (float)0.84);
			
			Bezero bezero = new Bezero("495752237W", "Asier", "Legorburu");
			
			
			
			Mockito.doReturn(new Kontua(kontID, 1000, bezero)).when(mockedEM).find(Kontua.class,  Mockito.anyInt());
			Mockito.doReturn(sukurtsal).when(mockedEM).find(Sukurtsal.class, Mockito.anyInt());
			Mockito.doReturn(dibisa).when(mockedEM).find(Dibisa.class, Mockito.anyString());
			Mockito.doReturn(new SukurtsalDibisa(2, (float)2000.4, 5, sukurtsal, dibisa)).when(mockedSukurtsal).getSukurtsalDibisa(Mockito.any(Dibisa.class));
			Mockito.doReturn(null).when(mockedEM).find(SukurtsalDibisa.class, Mockito.anyInt());
			
			sut.dibisaErosi(kontID, sukurID, mota, kop);
			assertTrue(false);
			
		}catch(Exception e) {
			assertTrue(true);
		}
	}
	
	
	
	@Test
	public void test6() {
		
			
			int kontID = 2;
			int sukurID = 2;
			String mota = "USD";
			float kop = (float)30000.2;
			
			Sukurtsal sukurtsal = new Sukurtsal(2,"Donostia");
			Dibisa dibisa = new Dibisa("USD", (float)0.84);
			SukurtsalDibisa sk = new SukurtsalDibisa(2, (float)2000.4, 5, sukurtsal, dibisa);
			
			Bezero bezero = new Bezero("495752237W", "Asier", "Legorburu");
			
			
			
			Mockito.doReturn(new Kontua(kontID, (float)10.3, bezero)).when(mockedEM).find(Mockito.any(),  Mockito.anyInt());
			Mockito.doReturn(sukurtsal).when(mockedEM).find(Mockito.any(), Mockito.anyInt());
			Mockito.doReturn(dibisa).when(mockedEM).find(Mockito.any(), Mockito.anyString());
			Mockito.doReturn(sk).when(mockedSukurtsal).getSukurtsalDibisa(Mockito.any(Dibisa.class));
			Mockito.doReturn(sk).when(mockedEM).find(Mockito.any(), Mockito.anyInt());
			Mockito.doReturn((float)0.84).when(mockedDibisa).getBalioEur();
			
			
			Mockito.verify(mockedSK,Mockito.times(1)).kenduEtaSetKop(Mockito.anyFloat());
			
			Mockito.verify(mockedKontua,Mockito.times(1)).kenduEtaSetDiruKop(Mockito.anyFloat());
			Mockito.verify(mockedKontua,Mockito.times(1)).addTransakzio(Mockito.any(Transakzio.class));
			
			try {
			
			int emaitza = sut.dibisaErosi(kontID, sukurID, mota, kop);
			assertTrue(2 == emaitza);
			
		}catch(Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void test7() {
		try {
			
			int kontID = 2;
			int sukurID = 2;
			String mota = "USD";
			float kop = (float)30.2;
			
			Sukurtsal sukurtsal = new Sukurtsal(2,"Donostia");
			Dibisa dibisa = new Dibisa("USD", (float)0.84);
			SukurtsalDibisa sk = new SukurtsalDibisa(2, (float)2000.4, 5, sukurtsal, dibisa);
			
			Bezero bezero = new Bezero("495752237W", "Asier", "Legorburu");
			
			
			
			Mockito.doReturn(new Kontua(kontID, (float)1000.3, bezero)).when(mockedEM).find(Mockito.any(),  Mockito.anyInt());
			Mockito.doReturn(sukurtsal).when(mockedEM).find(Mockito.any(), Mockito.anyInt());
			Mockito.doReturn(dibisa).when(mockedEM).find(Mockito.any(), Mockito.anyString());
			Mockito.doReturn(sk).when(mockedSukurtsal).getSukurtsalDibisa(Mockito.any(Dibisa.class));
			Mockito.doReturn(sk).when(mockedEM).find(Mockito.any(), Mockito.anyInt());
			Mockito.doReturn((float)0.84).when(mockedDibisa).getBalioEur();
			
			int emaitza = sut.dibisaErosi(kontID, sukurID, mota, kop);
			assertTrue(0 == emaitza);
			
		}catch(Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void test8() {
		int kontID = 2;
		int sukurID = 2;
		String mota = "USD";
		float kop = (float)30.2;
		
		Sukurtsal sukurtsal = new Sukurtsal(2,"Donostia");
		Dibisa dibisa = new Dibisa("USD", (float)0.84);
		SukurtsalDibisa sk = new SukurtsalDibisa(2, (float)2.4, 5, sukurtsal, dibisa);
		
		Bezero bezero = new Bezero("495752237W", "Asier", "Legorburu");
		
		
		Mockito.doReturn(new Kontua(kontID, (float)10.3, bezero)).when(mockedEM).find(Mockito.any(),  Mockito.anyInt());
		Mockito.doReturn(sukurtsal).when(mockedEM).find(Mockito.any(), Mockito.anyInt());
		Mockito.doReturn(dibisa).when(mockedEM).find(Mockito.any(), Mockito.anyString());
		Mockito.doReturn(sk).when(mockedSukurtsal).getSukurtsalDibisa(Mockito.any(Dibisa.class));
		
		
		
		Mockito.doReturn(2).when(mockedSK).getId();
		Mockito.doReturn(sk).when(mockedEM).find(Mockito.any(), Mockito.anyInt());
		
		Mockito.doReturn(5).when(mockedSK).getKomisioa();
		
		Mockito.doReturn((float)0.84).when(mockedDibisa).getBalioEur();
	
		
		
		
		Mockito.doReturn((float)2.4).when(mockedSK).getKop();
		Mockito.doReturn((float)-1000).when(mockedKontua).getDiruKop();
		
		Mockito.verify(mockedSK,Mockito.times(1)).kenduEtaSetKop(Mockito.anyFloat());
		
		Mockito.verify(mockedKontua,Mockito.times(1)).kenduEtaSetDiruKop(Mockito.anyFloat());
		Mockito.verify(mockedKontua,Mockito.times(1)).addTransakzio(Mockito.any(Transakzio.class));
		
//		Mockito.verify(mockedSK,Mockito.times(1)).kenduEtaSetKop(Mockito.anyFloat());
//		
//		Mockito.verify(mockedKontua,Mockito.times(1)).kenduEtaSetDiruKop(Mockito.anyFloat());
//		Mockito.verify(mockedKontua,Mockito.times(1)).addTransakzio(Mockito.any(Transakzio.class));
//		
		try {
		
		//Mockito.doReturn(cal).when(mockedCalendar).getInstance(Mockito.any(TimeZone.class));
		
	
		int emaitza = sut.dibisaErosi(kontID, sukurID, mota, kop);
		assertTrue(1 == emaitza);
		
	}catch(Exception e) {
		assertTrue(false);
	}
}

//@Test
//public void test9() {
//	
//		
//		int kontID = 2;
//		int sukurID = 2;
//		String mota = "USD";
//		float kop = (float)30000.2;
//		
//		Sukurtsal sukurtsal = new Sukurtsal(2,"Donostia");
//		Dibisa dibisa = new Dibisa("USD", (float)0.84);
//		SukurtsalDibisa sk = new SukurtsalDibisa(2, (float)2000.4, 5, sukurtsal, dibisa);
//		
//		Bezero bezero = new Bezero("495752237W", "Asier", "Legorburu");
//		
//		
//		
//		Mockito.doReturn(new Kontua(kontID, (float)10.3, bezero)).when(mockedEM).find(Mockito.any(),  Mockito.anyInt());
//		Mockito.doReturn(sukurtsal).when(mockedEM).find(Mockito.any(), Mockito.anyInt());
//		Mockito.doReturn(dibisa).when(mockedEM).find(Mockito.any(), Mockito.anyString());
//		Mockito.doReturn(sk).when(mockedSukurtsal).getSukurtsalDibisa(Mockito.any(Dibisa.class));
//		Mockito.doReturn(sk).when(mockedEM).find(Mockito.any(), Mockito.anyInt());
//		Mockito.doReturn((float)0.84).when(mockedDibisa).getBalioEur();
//		
//		try {
//		
//		int emaitza = sut.dibisaErosi(kontID, sukurID, mota, kop);
//		System.out.println(emaitza);
//		assertTrue(2 == emaitza);
//		
//	}catch(Exception e) {
//		assertTrue(false);
//	}
//		
//	}
	
	

}
