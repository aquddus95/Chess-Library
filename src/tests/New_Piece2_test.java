package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class New_Piece2_test{
// check to see if custom piece 2 is setup correctly and movement method is correct as well
	@Test
	public void test_diagonalskip_and_horizontal() {
		Chess_Board sample_game= new Chess_Board();
		sample_game.set_Up();
		Space[][] playing_board=sample_game.get_Board();
		boolean valid=true;		
		
		Piece new_piece2= new New_Piece2(playing_board,1, 4,4);

		if(new_piece2.can_move(4, 0) != true) {
			valid=false;
		}
		
		if(new_piece2.can_move(4, 5) != true) {
			valid=false;
		}	
		
		if(new_piece2.can_move(10,15) == true) {
			valid=false;
		}
		
		if(new_piece2.can_move(3, 3) != true) {
			valid=false;
		}		
		
	assertTrue("Checking new_piece2",valid);
	
	}
	
	
}