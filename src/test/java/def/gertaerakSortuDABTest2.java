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
import dataaccess.DataAccess;
import dataaccess.DataAccessGertaerakSortu;
import domain.Event;
import domain.Question;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;
import test.businessLogic.TestFacadeImplementation;
import test.dataAccess.TestDataAccess;

public class gertaerakSortuDABTest2 {

	 //sut:system under test
	 static DataAccessGertaerakSortu sut=new DataAccessGertaerakSortu(); 
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();
	 
	 @Test
		//sut.gertaerakSortu: gertaera egoki bat sortu.  
		public void test1() {
		 
		 String description = "TeamA1-TeamB2";
		 String sport = "Futbol";
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate=null;;
			try {
				oneDate = sdf.parse("08/10/2023");
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		 boolean result1 = sut.gertaerakSortu(description,oneDate, "Futbol");
	        assertTrue(result1);
	        
	        
	 }
	 
	 @Test
		//sut.gertaerakSortu:  existitzen ez den Kirol batekin gertaera sortu.  
		public void test2() {
		 
		 String description = "Team1-Team2";
		 String sport = "not exist";
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate=null;;
			try {
				oneDate = sdf.parse("05/10/2023");
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		 boolean result2 = sut.gertaerakSortu(description,oneDate, sport);
	        assertFalse(result2);

	 }
	 
	 @Test
		//sut.gertaerakSortu: Data berean bi gertaera berdin egotea.  
		public void test3() {
		 
		 String description = "Atletico-Athletic";
		 String sport =  "Futbol";
		 
		 Calendar today = Calendar.getInstance();
		   
		   int month=today.get(Calendar.MONTH);
		   month+=1;
		   int year=today.get(Calendar.YEAR);
		   if (month==12) { month=0; year+=1;}  
		   
		   Date oneDate = UtilDate.newDate(year,month,17);
		   
		   try {
			   boolean result3 = sut.gertaerakSortu(description,oneDate, sport);
			   fail();
		   }catch(Exception e) {
			   assertTrue(true);
		   }
		  
		   
	 }

	 @Test
	//sut.gertaerakSortu: Deskripzio ez egoki batekin sortu gertaera
			public void test4() {
			 
			 String description = "Ez egokia";
			 String sport =  "Futbol";
			 
			 Calendar today = Calendar.getInstance();
			   
			   int month=today.get(Calendar.MONTH);
			   month+=1;
			   int year=today.get(Calendar.YEAR);
			   if (month==12) { month=0; year+=1;}  
			   
			   Date oneDate = UtilDate.newDate(year,month,17);
			   
			   try {
				    boolean result4 = sut.gertaerakSortu(description,oneDate,sport);
				    fail();
			   }catch(Exception e) {
				   assertTrue(true);
			   }
			  
		 }
	 
	 @Test
		//sut.gertaerakSortu: Deskripzioa null
				public void test5() {
				 
				 String description = null;
				 String sport = "Futbol";
				 
				 Calendar today = Calendar.getInstance();
				   
				   int month=today.get(Calendar.MONTH);
				   month+=1;
				   int year=today.get(Calendar.YEAR);
				   if (month==12) { month=0; year+=1;}  
				   
				   Date oneDate = UtilDate.newDate(year,month,17);
				   
				   try {
					    boolean result5 = sut.gertaerakSortu(description,oneDate, sport);
					    fail();
				   }catch(Exception e) {
					   assertTrue(true);
				   }
				  
			 }
	 
	 @Test
		//sut.gertaerakSortu: Data null
				public void test6() {
				 
				 String description = null;
				 String sport = "not exist";
				 
				
				   try {
					    boolean result5 = sut.gertaerakSortu(description,null, "Futbol");
					    fail();
				   }catch(Exception e) {
					   assertTrue(true);
				   }
				  
			 }
	 
	 @Test
		//sut.gertaerakSortu: Kirola null
				public void test7() {
				 
				 String description = null;
				 
				 
				 Calendar today = Calendar.getInstance();
				   
				   int month=today.get(Calendar.MONTH);
				   month+=1;
				   int year=today.get(Calendar.YEAR);
				   if (month==12) { month=0; year+=1;}  
				   
				   Date oneDate = UtilDate.newDate(year,month,17);
				   
				   try {
					    boolean result5 = sut.gertaerakSortu(description,oneDate,null);
					    fail();
				   }catch(Exception e) {
					   assertTrue(true);
				   }
				  
			 }
	 
	 
}
