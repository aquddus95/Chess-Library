package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class New_Piece1_test{
// check to see if custom piece 1 is setup correctly and movement method is correct as well
	@Test
	public void test_skips_horizontal_vertical() {
		Chess_Board sample_game= new Chess_Board();
		sample_game.set_Up();
		Space[][] playing_board=sample_game.get_Board();
		boolean valid=true;		
		
		Piece new_piece1= new New_Piece1(playing_board,1, 2,2);

		if(new_piece1.can_move(5, 5) != true) {
			valid=false;
		}
		
		if(new_piece1.can_move(3, 2) != true) {
			valid=false;
		}	
		
		if(new_piece1.can_move(10,15) == true) {
			valid=false;
		}
		
	assertTrue("Checking new_piece1",valid);
	
	}
	
	
}