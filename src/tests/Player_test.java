package tests;
import Main.*;
import static org.junit.Assert.*;
import org.junit.Test;;

public class Player_test{
// test to check player class and its methods 
	@Test
	public void test_player_object_setter_getter() {
		Player sample= new Player(true,1,null);
		boolean valid= true;
		
		if(sample.get_Turn() != true ) {
			valid=false;
		}
	
		if(sample.get_Player_Num() != 1 ) {
			valid=false;
		}
	
		if(sample.get_Playing_Board() != null ) {
			valid=false;
		}
		
		for(int row=0; row<8; row++){
			for(int col=0; col<8; col++){
				if(((sample.get_My_Pieces())[row][col])== true) {
					valid=false;
				}
			}
		}		

	assertTrue("Checking Player",valid);
	
	}


}