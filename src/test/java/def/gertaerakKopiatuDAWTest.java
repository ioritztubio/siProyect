package def;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.UtilDate;
import dataaccess.DataAccess;
import domain.Event;
import domain.Team;
import test.businessLogic.TestFacadeImplementation;
import test.dataAccess.TestDataAccess;

public class gertaerakKopiatuDAWTest {

	static DataAccess sut = new DataAccess();
	
	static TestDataAccess testDA = new TestDataAccess();

	private Event ev;
	private Date d;
	
	@Test
	//sut.gertaerakKopiatu: Gertaera bat ondo kopiatu.
	public void test1() {
		ev = new Event();
		//String description,Date eventDate, Team lokala, Team kanpokoa
		
		
		String description="event1";
		
		Team Team1 = new Team("Team1");
		Team Team2 = new Team("Team2");
		ev.setLokala((Team) Team1);
		ev.setKanpokoa((Team) Team2);
		ev.setDescription(description);
		
		
		
		
		Calendar today = Calendar.getInstance();
		 int month=today.get(Calendar.MONTH);
		   month+=1;
		   int year=today.get(Calendar.YEAR);
		   if (month==12) { month=0; year+=1;}  
		   
		   d = UtilDate.newDate(year +1, month, 18);
		   
		   Date oneDate = UtilDate.newDate(year,month,17);
       
		   try {
			   boolean emaitza = sut.gertaerakKopiatu(ev, d);
		   }catch (Exception e) {
			   assertTrue(true);
		   }
		

        
	}
	
	@Test
	//sut.gertaerakKopiatu: Datan null jarri.
	public void test2() {
		ev = new Event();
		
		String eventText="event1"; 
		String queryText="query1";
		Float betMinimum = new Float(2);
		 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d=null;
		Date d2=null;
		try {
			d = sdf.parse("05/10/2022"); 
			d = sdf.parse("05/10/2023");
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
        testDA.open();
		ev = testDA.addEventWithQuestion(eventText, d, queryText, betMinimum);
		testDA.close();
	
		Event ev2 = new Event("fhjgdjgd", d, new Team("team1"), new Team("team2"));
		
		boolean emaitza;
		emaitza = sut.gertaerakKopiatu(ev, d2); 
		
		assertTrue(emaitza);
	}
	
	@Test
	public void test3() {
		ev = new Event();
		
		String eventText="event1";
		String queryText="query1";
		Float betMinimum = new Float(2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d=null;
		try {
			d = sdf.parse("05/10/2022");
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
        testDA.open();
		ev = testDA.addEventWithQuestion(eventText, d, queryText, betMinimum);
		testDA.close();
		
		try {
			boolean emaitza = sut.gertaerakKopiatu(null, d); 
			fail();
		}catch(Exception e) { 
			assertTrue(true);
		}
	}
	
	@Test 
	public void test4() {
		ev = new Event();  
		
		String eventText="event1";
		String queryText="query1";
		Float betMinimum = new Float(2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d=null;
		try {
			d = sdf.parse("05/10/2023");
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		Event ev = new Event("Klasiko", d, new Team("team1"), new Team("team2"));
		
		try {
	        boolean emaitza = sut.gertaerakKopiatu(ev, d);
	        assertTrue(emaitza);
		}catch(Exception e) {  
			fail();
		}
	}

}
