package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class Pawn_test{
// check to see if pawn piece is setup correctly and movement method for this piece follows the rules in place for the pawn piece in chess
	@Test
	public void initial_pawn_movement() {
		Chess_Board sample_game= new Chess_Board();
		sample_game.set_Up();
		Space[][] playing_board=sample_game.get_Board();
		boolean valid=true;
		
		Piece pwn=playing_board[1][0].get_Piece();
		if((pwn.can_move(3, 0)) == false) {
			valid=false;
		}
		
		playing_board[3][0].set_Empty(false);
		if((pwn.can_move(3, 0)) == true) {
			valid=false;
		}
		
		playing_board[2][0].set_Empty(false);
		if((pwn.can_move(2, 0)) == true) {
			valid=false;
		}
		
		
	assertTrue("Checking Pwn",valid);
	
	}
	
	@Test
	public void test_diagonal_movement() {
		Chess_Board sample_game= new Chess_Board();
		sample_game.set_Up();
		Space[][] playing_board=sample_game.get_Board();
		boolean valid=true;
		
		Piece pwn=playing_board[6][1].get_Piece();
		playing_board[5][0].set_Empty(false);
		if((pwn.can_move(5, 0)) == false) {
			valid=false;
		}
	
		playing_board[5][2].set_Empty(false);
		if((pwn.can_move(5, 2)) == false) {
			valid=false;
		}
	
		
		assertTrue("Checking Pwn",valid);
	}	

}