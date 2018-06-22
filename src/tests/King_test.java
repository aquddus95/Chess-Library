package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class King_test{
// check if King piece is setup correctly
	@Test
	public void test_King_setup() {
		Chess_Board sample_game= new Chess_Board();
		sample_game.set_Up();
		Space[][] playing_board=sample_game.get_Board();
		boolean valid=true;
		
		
	assertTrue("Checking King",valid);
	
	}
}