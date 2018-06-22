package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class Bishop_test{
// check to see if bishop piece is setup correctly and movement method for this piece follows the rules in place for the bishop piece in chess
	
	@Test
	public void test_diagonal_movement() {
		Chess_Board sample_game= new Chess_Board();
		sample_game.set_Up();
		Space[][] playing_board=sample_game.get_Board();
		boolean valid=true;
		
		
		
		Piece bishop1=playing_board[0][2].get_Piece();
		playing_board[1][3].set_Empty(false);
		playing_board[1][1].set_Empty(false);
		
		if(bishop1.can_move(1, 3) != true) {
			valid=false;
		}	
		
		if(bishop1.can_move(1,1) != true) {
			valid=false;
		}

		
		if(bishop1.can_move(10,15) == true) {
			valid=false;
		}
		
		
		assertTrue("Checking Bishop",valid);
	}
}