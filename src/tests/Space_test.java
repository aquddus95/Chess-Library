package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class Space_test{
// test to check if space class is working correctly 
	@Test
	public void test_Space_setter_getter() {
		Space sample= new Space(null,true);
		boolean valid= true;
		
		if(sample.get_Piece() != null ) {
			valid=false;
		}
	
		if(sample.get_Empty() != true ) {
			valid=false;
		}
	
	assertTrue("Checking Player",valid);
	
	}


}