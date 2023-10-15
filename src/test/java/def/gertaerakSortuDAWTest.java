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

	 @Test
	    public void testKutxaTxuria() {
	        System.out.println("Kutxa txurien probak:");
	        DataAccess db = new DataAccess();
	        // Prueba 1: Crear un evento válido
	        boolean result1 = db.gertaerakSortu("Real Madrid-Barcelona", new Date(), "Fútbol");
	        assertTrue(result1);

	        // Prueba 2: Intentar crear un evento con una fecha duplicada
	        boolean result2 = db.gertaerakSortu("Evento1", new Date(), "Baloncesto");
	        assertFalse(result2);

	        // Prueba 3: Intentar crear un evento sin un deporte existente
	        boolean result3 = db.gertaerakSortu("Evento2", new Date(), "DeporteInexistente");
	        assertFalse(result3);

	        // Prueba 4: Crear un evento con deporte y fecha válidos
	        boolean result4 = db.gertaerakSortu("Evento3", new Date(), "Tenis");
	        assertTrue(result4);

	        // Prueba 5: Crear un evento con un formato de descripción incorrecto
	        boolean result5 = db.gertaerakSortu("DescripciónIncorrecta", new Date(), "Baloncesto");
	        assertFalse(result5);
	    }
}
