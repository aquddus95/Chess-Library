package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class Queen_test{

// check to see if Queen piece is setup correctly and movement method for this piece follows the rules in place for the queen piece in chess
	@Test
	public void test_diagonal_invalid_movements() {
		Chess_Board sample_game= new Chess_Board();
		sample_game.set_Up();
		Space[][] playing_board=sample_game.get_Board();
		boolean valid=true;
		
		
		
		Piece queen1=playing_board[0][4].get_Piece();
		playing_board[1][3].set_Empty(false);
		playing_board[1][4].set_Empty(true);
		if(queen1.can_move(4, 4) != true) {
			valid=false;
		}	
		
		if(queen1.can_move(1,3) != true) {
			valid=false;
		}
		
		if(queen1.can_move(0,0)== true) {
			valid=false;
		}
		
		if(queen1.can_move(1,5) != true) {
			valid=false;
		}
		
		
	assertTrue("Checking Queen",valid);
	
	}
}