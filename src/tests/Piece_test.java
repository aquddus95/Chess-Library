package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class Piece_test{
// test to check the piece class and its methods
	@Test
	public void test() {
		Piece sample= new Piece(null,2,2,2);
		boolean valid= true;
		
		if(sample.get_Board() != null ) {
			valid=false;
		}
	
		if(sample.get_Owner() != 2 ) {
			valid=false;
		}
		
		if(sample.get_Row_Num() != 2 ) {
			valid=false;
		}
		
		if(sample.get_Col_Num() != 2 ) {
			valid=false;
		}
	
	assertTrue("Checking Player",valid);
	
	}

}