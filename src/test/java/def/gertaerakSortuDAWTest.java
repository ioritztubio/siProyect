package def;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import configuration.ConfigXML;
import configuration.UtilDate;
//import dataAccess.DataAccessInterface;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;
import test.businessLogic.TestFacadeImplementation;
import test.dataAccess.TestDataAccess;

public class gertaerakSortuDAWTest {

	 //sut:system under test
	 static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess(); 

	 
	 @Test
	 //sut.gertaeraSortu: gertaera ondo sortu.
	    public void test1() {
		 //Parametroak definitu:
		 String description = "Team1-Team2";
		 String sport = "Futbol";
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 Date oneDate=null;
			try { 
				oneDate = sdf.parse("01/10/2022");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		 
		// Proba 1: Sortu gertaera bat egokia dena.
	        boolean result1 = sut.gertaerakSortu(description, oneDate, sport);
	        assertTrue(result1);
	       
	       
	        
	        
	 }
	       
	 @Test
	 //sut.gertaeraSortu: gertaera bat sortu baina kirol batekin db-an ez dagoena.
	    public void test2() {
		 //Parametroak definitu:
		 String description = "Barcelona-Real Madrid";
		 String sport = "not exist";
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 Date oneDate=null;;
			try {
				oneDate = sdf.parse("05/10/2022");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		 
		// Proba 2: gertaera bat sortu baina kirol batekin db-an ez dagoena.
	        boolean result2 = sut.gertaerakSortu(description, oneDate, sport);
	        assertFalse(result2);
	        
	 }
	 
	 @Test
	 //sut.gertaeraSortu: gertaera bat sortu baina deskripzio ez egoki batekin.
	    public void test3() {
		 //Parametroak definitu:
		 String description = "team1";
		 String sport = "Futbol";
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 Date oneDate=null;;
			try {
				oneDate = sdf.parse("05/10/2022");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		 
		// Proba 2: gertaera bat sortu baina deskripzio ez egoki batekin.
	       try { 
	    	   boolean result3 = sut.gertaerakSortu(description, oneDate, sport);   
	    	   fail();
	       }catch(Exception e) {
	    	   assertTrue(true);   
	       }
			
	        
	        
	 } 
	     
	 @Test
	 //sut.gertaeraSortu: data berean duen gertaera bat sortu.
	    public void test4() {
		 //Parametroak definitu:
		 String description = "Atletico-Athletic";
		 String sport = "Futbol";
		
		 Calendar today = Calendar.getInstance();
		 int month=today.get(Calendar.MONTH);
		   month+=1;
		   int year=today.get(Calendar.YEAR);
		   if (month==12) { month=0; year+=1;}  
		   
		   Date oneDate = UtilDate.newDate(year,month,17);
		 
		// Proba 4:data berean duen gertaera bat sortu.
				try {
				boolean result4 = sut.gertaerakSortu(description, oneDate, sport);   
				fail();
				}catch(Exception e) {
					assertTrue(true);
				}
	    
	      }  			 
	        
	        
	

	    
}
