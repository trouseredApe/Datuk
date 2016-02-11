package commonfunctions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommonFunctionsTest {

	CommonFunctions cf;
	@Before
	public void initialize(){
		cf = new CommonFunctions();  
	}
	@Test
	public void testisNumericNumber() {
		assertTrue(cf.isNumeric("4"));  
	}
	@Test
	public void testisNumericCharacter() { 
		assertFalse(cf.isNumeric("a"));  
	}
	@Test
	public void testisNumericString() { 
		assertFalse(cf.isNumeric("Hello World"));  
	}

}
