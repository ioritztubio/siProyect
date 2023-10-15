package def;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import configuration.ConfigXML;
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
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 Date oneDate=null;;
			try {
				oneDate = sdf.parse("17/11/2023");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		 
		// Proba 4:data berean duen gertaera bat sortu.
				try {
				boolean result4 = sut.gertaerakSortu(description, oneDate, sport);   
				fail();
				}catch(Exception e) {
					assertTrue(true);
				}
	    
	      }  			
	        
	        
	

	        /**
	         * 
	         *  
	         *  // Prueba 1: Sortu gertaera bat egokia dena.
	        boolean result1 = db.gertaerakSortu("Barcelona-Barcelona", new Date(), "Futbol");
	        assertTrue(result1);
	         * 	        // Prueba 2: Sortu gertaera bat Kirol bat ez datubasean ez dagoenarekin.
	        boolean result2 = db.gertaerakSortu("Real Madrid-Barcelona", new Date(), "asdfasdf");
	        assertFalse(result2);
	         * 
	         * 
	         *     
	        //Prueba 3: Deskripzio bat gaizki 
	        boolean result3 = sut.gertaerakSortu("Barcelona", new Date(), "Futbol");
	        assertEquals(result3);
	      
	        
	        Date d = new Date("11/12/2020");
	        boolean result3= db.gertaerakSortu("Barcelona-Barcelona",d , "Futbol");
	        assertTrue(result3);
	            
	        // Prueba 3: Sortu gertaera bat deskripzio gaizki duena.
	        boolean result3 = db.gertaerakSortu("Real k-Real Sociedad", new Date(), "Futbol");
	        assertFalse(result3);
	    
	        // Prueba 4: Crear un evento con deporte y fecha válidos
	        boolean result4 = db.gertaerakSortu("Evento3", new Date(), "Tenis");
	        assertTrue(result4);

	        // Prueba 5: Crear un evento con un formato de descripción incorrecto
	        boolean result5 = db.gertaerakSortu("DescripciónIncorrecta", new Date(), "Baloncesto");
	        assertFalse(result5);
	        **/
	    
}
