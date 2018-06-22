package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class Knight_test{
// check to see if knight piece is setup correctly and movement method for this piece follows the rules in place for the knight piece in chess

	@Test
	public void test_horizontal_vertical_skip() {
		Chess_Board sample_game= new Chess_Board();
		sample_game.set_Up();
		Space[][] playing_board=sample_game.get_Board();
		boolean valid=true;
		
		
		
		Piece Knight1=playing_board[0][6].get_Piece();

		
		if(Knight1.can_move(2, 7) != true) {
			valid=false;
		}	
		
		if(Knight1.can_move(10,15) == true) {
			valid=false;
		}
		
		
	assertTrue("Checking Knight",valid);
	
	}
	
	
}