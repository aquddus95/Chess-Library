package Main;

public class Space{
	
	private Piece chess_piece;     
	private boolean empty; //tells you if there is a piece on the space of the board

	public Space(){
		chess_piece=null;
		empty=true;
	}

	public Space(Piece some_piece, boolean some_empty){
		set_Piece(some_piece);
		set_Empty(some_empty);
	}

	public Piece get_Piece(){
		return chess_piece; 
	}


	public boolean get_Empty(){
		return empty; 
	}

	public void set_Piece(Piece some_piece){
		chess_piece= some_piece;
	} 


	public void set_Empty(boolean some_val){
		empty= some_val;
	} 



}