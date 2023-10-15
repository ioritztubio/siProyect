package def;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Team;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class gertaerakKopiatuBLWMTest {

	DataAccess dataAccess=Mockito.mock(DataAccess.class);
    Event mockedEvent=Mockito.mock(Event.class);
	 
	@InjectMocks
	BLFacade sut=new BLFacadeImplementation(dataAccess);
	
	@Test
	public void test1() {
		try {
			String queryText="proba galdera";
			Float betMinimum=new Float(2);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate=null;;
			try {
				oneDate = sdf.parse("05/10/2022");
			} catch (ParseException e) {
				e.printStackTrace();
			}	
				
			Mockito.doReturn(oneDate).when(mockedEvent).getEventDate();
			Mockito.doReturn(new Event("event", oneDate, new Team("team1"), new Team("team2"))).when(mockedEvent);

		//	Boolean b = sut.gertaerakKopiatu(mockedEvent, queryText, betMinimum);
				
			ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
			ArgumentCaptor<String> questionStringCaptor = ArgumentCaptor.forClass(String.class);
			ArgumentCaptor<Float> betMinimunCaptor = ArgumentCaptor.forClass(Float.class);
				
			Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(eventCaptor.capture(),questionStringCaptor.capture(), betMinimunCaptor.capture());
			Float f=betMinimunCaptor.getValue();

			assertEquals(eventCaptor.getValue(),mockedEvent);
			assertEquals(questionStringCaptor.getValue(),queryText);
			assertEquals(betMinimunCaptor.getValue(),betMinimum);

		} catch (QuestionAlreadyExist e) {
			assertTrue(true);
		//} catch (EventFinished e) {
			fail();
			e.printStackTrace();
		}
	}
	
}
