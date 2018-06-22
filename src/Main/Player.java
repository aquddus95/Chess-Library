package Main;

public class Player{
	
	private boolean turn;     
	private int player_num;
	private Space[][] playing_board;
	private boolean[][] my_pieces; //this keeps tracks of where players pieces are

	 /**
     * constructor for player and create initial configuration of my_pieces which tells the player where his/her pieces on the board are
     * @param player_turn which player turn
     * @param playernumber which player
     * @param some_board playing game board
     */


	public Player(boolean player_turn,int playernumber,Space[][] some_board){
		turn=player_turn;
		player_num=playernumber;
		playing_board=some_board;
		my_pieces= new boolean[8][8];
		for(int row=0; row<8; row++){
			for(int col=0; col<8; col++){
				my_pieces[row][col]=false;
			}
		}		
	}

	public boolean get_Turn(){
		return turn; 
	}

	public int get_Player_Num(){
		return player_num; 
	}

	public Space[][] get_Playing_Board(){
		return playing_board; 
	}

	public boolean[][] get_My_Pieces(){
		return my_pieces;
	} 

	public void set_Turn(boolean some_turn){
		turn= some_turn; 
	}

	public void set_Player_Num(int playernum){
		player_num=playernum; 
	}

	public void set_Playing_Board(Space[][] some_board){
		playing_board=some_board; 
	}

	// set the players pieces location
	public void set_My_Pieces(boolean[][] some_my_pieces){
		my_pieces=some_my_pieces;
	} 

	
	//set individual piece location
	 /**
     * sets the value of a players piece on the board to true or false depending on movement of the piece
     * @param row row number of board
     * @param col col number of board
     * @param val is the piece on or off the board
     */
	public void set_one_pieces(int row, int col, boolean val){
		my_pieces[row][col]=val;
	}


}