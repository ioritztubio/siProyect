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
import dataaccess.DataAccess;
import domain.Event;
import domain.Question;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;
import test.businessLogic.TestFacadeImplementation;
import test.dataAccess.TestDataAccess;

public class gertaerakKopiatuDABTest {

	 static DataAccess sut = new DataAccess(); 
	 
	 static TestDataAccess testDA = new TestDataAccess();

	 private Event ev;
	
	 @Test
	 public void test1() {
		 try {
			 
			String eventText="event1";
			String queryText="query1";
			Float betMinimum=new Float(2);
				
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate=null;;
			try {
				oneDate = sdf.parse("05/10/2022");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 

			Boolean b = sut.gertaerakKopiatu(null, oneDate);
				
				
			//verify the results
			assertFalse(b);
				
				
		} catch (Exception e) {  
			fail();
		}
	}
	 
}
