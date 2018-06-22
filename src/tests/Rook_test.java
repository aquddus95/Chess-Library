package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class Rook_test{
// check to see if rook piece is setup correctly and movement method for this piece follows the rules in place for the rook piece in chess

	@Test
	public void test_vertical_movement() {
		Chess_Board sample_game= new Chess_Board();
		sample_game.set_Up();
		Space[][] playing_board=sample_game.get_Board();
		boolean valid=true;
		
		
		
		Piece rook=playing_board[0][0].get_Piece();
		playing_board[3][0].set_Empty(false);
		playing_board[0][1].set_Empty(false);
		if(rook.can_move(3, 0) == true) {
			valid=false;
		}	
		
		if(rook.can_move(0,1) != true) {
			valid=false;
		}
		
		if(rook.can_move(0,7)== true) {
			valid=false;
		}
		
		if(rook.can_move(10,15) == true) {
			valid=false;
		}
		
		
	assertTrue("Checking Rook",valid);
	
	}
	
	@Test
	public void test_horizontal_movement(){
		Chess_Board sample_game= new Chess_Board();
		sample_game.set_Up();
		Space[][] playing_board=sample_game.get_Board();
		boolean valid=true;
		Piece rook2=playing_board[7][7].get_Piece();
		
		
		if(rook2.can_move(6,7) != true) {
			valid=false;
		}
		
		if(rook2.can_move(7,0) == true) {
			valid=false;
		}
		
		
		assertTrue("Checking Rook",valid);	
		
	}
	
	
}