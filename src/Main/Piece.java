package Main;

public class Piece{
	
	private int owner;     
	private Space[][] current_board;
	private int row_num;
	private int col_num;
	/**
     * constructor for piece
     * @param some_board is a game board
     * @param player_num number of the player
     * @param row row number on board of piece
     * @param col col number on board of piece
     */
	public Piece(Space[][] some_board,int player_num,int row, int col){
		row_num=row;
		col_num=col;
		owner= player_num;
		current_board=some_board;
	}

	public int get_Owner(){
		return owner; 
	}

	public Space[][] get_Board(){
		return current_board;
	}

	public int get_Row_Num(){
		return row_num; 
	}

	public int get_Col_Num(){
		return col_num; 
	}

	public void set_Owner(int some_owner){
		owner=some_owner;
	} 

	public void set_Board(Space[][] some_board){
		current_board=some_board;
	}

	public void set_Row_Num(int row){
		row_num= row;
	} 

	public void set_Col_Num(int col){
		col_num= col;
	}


	public boolean can_move(int row, int col){
		// dummy method do not want to do anything here
		return false;
	}
	/**
     * check if pair of coordinates are outside the board
     * @param row row number on board 
     * @param col col number on board 
     */
	public boolean in_bound(int row, int col){
		if( row< 0 || row>7 || col <0 || col> 7){
			return false;
		}
		else{
		return true;	
		}
	}

	/**
     * check if the space on the board has a piece on it or not 
     * @param row row number on board 
     * @param col col number on board 
     */
	
	public boolean space_is_empty(int row, int col){
		Space[][] current_board=this.get_Board();
		Space holder=current_board[row][col];
		boolean empty=holder.get_Empty();
		return empty;
	}

	/**
     * move piece vertically, horizontally or diagonal
     * @param current_row  row number on board where piece is 
     * @param current_col col number on board where piece is
     * @param diff_row difference between destination row and current row 
     * @param diff_col difference between destination col and current col 
     * @param up_down movie piece up (positive one) or down (negative one) while staying in the same column 
     * @param left_right movie piece right (positive one) or left (negative one) while staying in the same row
     * @param limiter number of space between current spot and destination spot (vertically, horizontally, diagonal) used to check if spaces in between have pieces 
     */
	
	
	public boolean move_it_leftright_updown(int current_row,int current_col, int diff_row, int diff_col, int up_down,int left_right, int limiter ){
 		boolean piece_in_path=false;

 		
		for(int i= 1; i<limiter; i++){
			if(space_is_empty((current_row+(up_down * i)),(current_col+(left_right * i)))==false){
				piece_in_path=true;
			}
		}
		
		if(piece_in_path){
			return false;
		}

		return true;
 	}
	
	/**
     * move piece some number of skips vertically by vertical limiter and horizontally by horizontal limiter, these values can be interchanged as well
     * @param row number on board where piece is to go 
     * @param col number on board where piece is to go 
     * @param vertical_limiter vertical leaps that can be taken
     * @param horizontal_limiter horizontal leaps that can be taken
     */
	
	public boolean skip_movement(int row, int col, int vertical_limiter, int horizontal_limiter){	
		int current_row=this.get_Row_Num();
		int current_col=this.get_Col_Num();
		
		int diff_row=Math.abs(row-current_row);
		int diff_col=Math.abs(col-current_col);

		//note this code was used from the following source: https://github.com/babburra/CS-242/blob/master/Assignment1.0/src/Main/Knight.java
        return ((diff_row == vertical_limiter && diff_col == horizontal_limiter) || (diff_row == horizontal_limiter && diff_col == vertical_limiter));

	}
	
	
}