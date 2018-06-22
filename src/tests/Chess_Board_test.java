// The following test checks to see if the constructor/destructor for setting up the Chess Board class is done correctly



package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class Chess_Board_test{



	@Test
	public void test_Chess_Constructor(){
		// check if the board is a 2d array of empty space objects
		// the space class is used to hold information on what piece is on the space and wheather or not the space is empty
		Chess_Board sample= new Chess_Board();
		Space[][] the_board=sample.get_Board();
		boolean valid=true;
		Space some_space;	
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				some_space=the_board[i][j];
				if(some_space.get_Empty() != true){
					valid=false;	
				}	
			}
		}	
		assertTrue("Default Constructor of Chess Board",valid);
	}

	@Test
	public void test_Chess_destructor() {
		// make sure that after having an initial setup where all the piece objects are put in the initial configuration of a chess board that the destructor clears these objects and that we are
		// left with empty spaces in the 2d array of the chess board
		Chess_Board sample_chess= new Chess_Board();
		Space[][] the_board=sample_chess.get_Board();
		Space sample=the_board[0][0];
		sample.set_Empty(false);
		sample_chess.reset_board();
		
		Space sample2=the_board[0][0];
		boolean isempty=sample2.get_Empty();
		assertTrue("Problem with teardown of board",isempty);	
	}
	
	@Test
	// check if we correctly place the right pawn pieces on the right spots on the chess board for the initial configuration of a chess game
	public void test_Chess_Board_setup() {
		Chess_Board sample_chess= new Chess_Board();
		Space[][] the_board=sample_chess.get_Board();
		Space spot;
		sample_chess.set_Up();
		boolean valid=true;
		for(int j=0;j<8;j++) {
			spot=the_board[1][j];
			Piece some_piece=spot.get_Piece();
			if(!(some_piece instanceof Pawn)) {
				valid=false;
			}
		}
		assertTrue("set_up probs",valid);
		
	}
	@Test
	// check if we correctly place the right rook, knight, bishop, queen, and king pieces on the right spots on the chess board (both white and black pieces) for the initial configuration of a chess game
	public void test_initial_piece_configuration() {
		boolean valid=true;
		Chess_Board sample_chess= new Chess_Board();
		Space[][] the_board=sample_chess.get_Board();
		sample_chess.set_Up();
		Piece holder;
		for(int j=0;j<8;j++) {
			if(j==0 || j==7) {
				holder=the_board[0][j].get_Piece();
				if(!(holder instanceof Rook)) {
					valid=false;
				}
			}
			
			if(j==1 || j==6) {
				holder=the_board[0][j].get_Piece();
				if(!(holder instanceof Knight)) {
					valid=false;
				}
			}
			
			if(j==2 || j==5) {
				holder=the_board[0][j].get_Piece();
				if(!(holder instanceof Bishop)) {
					valid=false;
				}
			}
			
			if(j==3) {
				holder=the_board[0][j].get_Piece();
				if(!(holder instanceof King)) {
					valid=false;
				}
			}
			
			if(j==4) {
				holder=the_board[0][j].get_Piece();
				if(!(holder instanceof Queen)) {
					valid=false;
				}
			}
		}

		assertTrue("set_up probs back row",valid);
	}
	
	
}