package Main;

public class Chess_Board{
	
	protected Space [][] playing_board;  
	private Player player1; // black
	private Player player2; // white 
	private int turn;
	public static final int ROW= 8; 
	public static final int COL= 8; 

// Initialize the chess_board to empty spaces
	 /**
     * constructor for Chess_Board initialize an empty board with empty space objects
     */
	public Chess_Board(){

		playing_board = new Space[ROW][COL];
		for(int row=0; row<ROW; row++){
			for(int col=0; col<COL; col++){
				playing_board[row][col]=new Space();				
			}
		}
		player1= new Player(false,1, playing_board);
		player2= new Player(true,2, playing_board);
		turn=2; 
	}
// copy_constructor for the board // not a shallow copy
	 /**
     * copy constructor for chess_board
     * @param some_board is a game board that needs to be coppied
     * @param someplayer1 first player on the board
     * @param someplayer2 second player on the board
     * @param someturn whose turn is it
     */
	public Chess_Board(Space[][] some_board,Player someplayer1, Player someplayer2, int someturn){
		playing_board= new Space[ROW][COL];
		
		set_Player1(someplayer1);
		set_Player2(someplayer2);			
		set_Turn(someturn);
		Space holder;
		// copy the space object here not passing off any pointers
		if(some_board != null){
			for(int row=0; row<ROW; row++){
				for(int col=0; col< COL; col++){
					//fix this just passing pointers
					holder=some_board[row][col];
					playing_board[row][col]=new Space((holder.get_Piece()),(holder.get_Empty()));
				}
			}	
		}		

	}
// tear down of the board where
/**
     * explicit destructor for Chess_Board initialize an empty board with empty space objects/ clean slate
     */ 
	public void reset_board(){
		if(playing_board != null){
			for(int row=0; row<ROW; row++){
				for(int col=0; col< COL; col++){
					playing_board[row][col]= new Space();
					player1.set_one_pieces(row,col,false);
					player2.set_one_pieces(row,col,false);
				}
			}	
		}	
	}

	public Space[][] get_Board(){
		return playing_board;
	}

	public Space get_Space(int row, int col){
		return playing_board[row][col];
	}

	public Player get_Player(int num){
		if(num == 1){
		return player1;	
		}

		else{
		return player2;
		}

	}

	public int get_Turn(){
		return  turn;
	}

	
	/**
     * places a piece on a given space of the board or can remove the piece as well
     * @param some_piece is the piece to be moved or removed
     * @param row row number
     * @param col col_number
     * @param setpiece if true move given piece to the location if false then remove piece from the location
     */
		
	public void set_rmv_Chess_Piece(Piece some_piece,int row, int col, boolean setpiece) {
		
		Space some_space=playing_board[row][col];
		some_space.set_Piece(some_piece);
		int which_player= some_piece.get_Owner();

		if( which_player == 1){
		player1.set_one_pieces(row,col, setpiece);
		}

		else{
		player2.set_one_pieces(row,col, setpiece);	
		}
		

		if( setpiece == false ) {
			some_space.set_Piece(null);
			some_space.set_Empty(true);
		}
		else { 
			some_space.set_Empty(false);
			some_space.set_Piece(some_piece);
		}
		
		
		
	}
	

	public void set_Player1(Player some_player){
		player1=some_player;
	}

	public void set_Player2(Player some_player){
		player2=some_player;
	}


	public void set_Turn(int some_turn){
		turn=some_turn;
	}

// setup routine when starting a game
	/**
     * initialize the board to game-play beginning postions
     */

	public void set_Up(){
		setup_Piece(0, COL,1,0);
		setup_Piece(0,8,7,1);
		setup_Piece( 1,7,5,2);
		setup_Piece(2,6,3,3);
		setup_Royalty();
	}

	/**
     * places pieces on the game board according to the starting game rules of chess
     * @param initial_col  value for which column the piece will be placed
     * @param limit how many iterations of the loop before exiting out
     * @param increment value to increase the column value by
     * @param piece_type 0= place pawn , 1= place rook , 2= place Knight, 3= place Bishop
     */


	
	public void setup_Piece(int initial_col, int limit, int increment,int piece_type) {
		Piece new_piece1=null;
		Piece new_piece2=null;
		Space space1;
		Space space2;
		int player_num1=1;
		int player_num2=2;
		for(int col=initial_col; col < limit; col+=increment) {
			if(piece_type== 0){
				new_piece1= new Pawn(playing_board,player_num1,1,col);
	 			new_piece2= new Pawn(playing_board,player_num2,6,col);	
			}
			if(piece_type==1) {
				new_piece1= new Rook(playing_board,player_num1,0,col);
	 			new_piece2= new Rook(playing_board,player_num2,7,col);			
			}
			if(piece_type==2) {
				new_piece1= new Knight(playing_board,player_num1,0,col);
	 			new_piece2= new Knight(playing_board,player_num2,7,col);
			}
			if(piece_type == 3) {
				new_piece1= new Bishop(playing_board,1,0,col);
	 			new_piece2= new Bishop(playing_board,2,7,col);			 	
			}
			if(piece_type== 0) {
				player1.set_one_pieces(1,col, true);
				player2.set_one_pieces(6,col,true);
				space1= playing_board[1][col];
	 			space2= playing_board[6][col];
			}
			else {
				player1.set_one_pieces(0,col, true);
				player2.set_one_pieces(7,col, true);
				space1= playing_board[0][col];
	 			space2= playing_board[7][col];
			}
 			space1.set_Piece(new_piece1);
 			space1.set_Empty(false);
 			space2.set_Piece(new_piece2);
 			space2.set_Empty(false);		
		}	
	}
	
	
	
 	/*public void setup_Pawns(){
 		Piece new_pawn1;
		Piece new_pawn2;
		Space space1;
		Space space2;
		int player_num1=1;
		int player_num2=2;


 		for(int col=0; col<COL; col++){
 			new_pawn1= new Pawn(playing_board,player_num1,1,col);
 			player1.set_one_pieces(1,col, true);

 			new_pawn2= new Pawn(playing_board,player_num2,6,col);
		 	player2.set_one_pieces(6,col,true);

 			space1= playing_board[1][col];
 			space2= playing_board[6][col];
 			space1.set_Piece(new_pawn1);
 			space1.set_Empty(false);
 			space2.set_Piece(new_pawn2);
 			space2.set_Empty(false);
 		}

 	}

 	public void setup_Rook(){
 		Piece new_rook1;
		Piece new_rook2;
		Space space1;
		Space space2;
		int player_num1=1;
		int player_num2=2;

		for(int col=0; col<8; col+=7){
 			new_rook1= new Rook(playing_board,player_num1,0,col);
 			player1.set_one_pieces(0,col, true);
 			new_rook2= new Rook(playing_board,player_num2,7,col);
 			player2.set_one_pieces(7,col, true);
		 		
 			space1= playing_board[0][col];
 			space2= playing_board[7][col];

 			space1.set_Piece(new_rook1);
 			space1.set_Empty(false);
 			space2.set_Piece(new_rook2);
 			space2.set_Empty(false);
 		}
 	}

 	public void setup_Knight(){
 		Piece new_knight1;
		Piece new_knight2;
		Space space1;
		Space space2;
		int player_num1=1;
		int player_num2=2;

		for(int col=1; col<7; col+=5){
 			new_knight1= new Knight(playing_board,player_num1,0,col);
 			player1.set_one_pieces(0,col, true);
 			new_knight2= new Knight(playing_board,player_num2,7,col);
		 	player2.set_one_pieces(7,col, true);	

 			space1= playing_board[0][col];
 			space2= playing_board[7][col];

 			space1.set_Piece(new_knight1);
 			space1.set_Empty(false);
 			space2.set_Piece(new_knight2);
 			space2.set_Empty(false);
 		}
 	}
 
 	public void setup_Bishop(){
 		Piece new_bishop1;
		Piece new_bishop2;
		Space space1;
		Space space2;

		for(int col=2; col<6; col+=3){
 			new_bishop1= new Bishop(playing_board,1,0,col);
 			player1.set_one_pieces(0,col,true);
 			new_bishop2= new Bishop(playing_board,2,7,col);
		 	player2.set_one_pieces(7,col,true);

 			space1= playing_board[0][col];
 			space2= playing_board[7][col];

 			space1.set_Piece(new_bishop1);
 			space1.set_Empty(false);
 			space2.set_Piece(new_bishop2);
 			space2.set_Empty(false);
 		}
 	}



*/
	 /**
     * set up king and queen for both players on the board
     */
	
	
 	public void setup_Royalty(){
 		Piece new_king1;
		Piece new_king2;
		Piece new_queen1;
		Piece new_queen2;
		Space space1;
		Space space2;
		for(int col=3; col<5; col+=1){
			space1= playing_board[0][col];
 			space2= playing_board[7][col];
			if(col == 3){ 			
 				new_king1= new King(playing_board,1,0,col,player2);
 				player1.set_one_pieces(0,col,true);
 				new_king2= new King(playing_board,2,7,col,player1);
 				player2.set_one_pieces(7,col,true);
 				space1.set_Piece(new_king1);
 				space2.set_Piece(new_king2);
 			}
 			else{
 				new_queen1= new Queen(playing_board,1,0,col);
 				player1.set_one_pieces(0,col,true);
 				new_queen2= new Queen(playing_board,2,7,col);
 				player2.set_one_pieces(7,col,true);
 				space1.set_Piece(new_queen1);
 				space2.set_Piece(new_queen2);
 			}
 			space1.set_Empty(false);
 			space2.set_Empty(false);
 		}
 	}


}