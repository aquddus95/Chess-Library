package Main;


public class Knight extends Piece{

	public Knight(Space[][] some_board,int player_num,int row, int col){
		super(some_board,player_num,row,col);
	}
	/**
     * move function for Knight can leap to a spot that consists of a combination of two horizontal movements and 1 vertical movement or vice verse 
     * @param row row  destination number on board of piece
     * @param col col  destination number on board of piece
     */
	public boolean can_move(int row, int col){
		if(!(in_bound(row,col))){
			return false;
		}
		return (this.skip_movement(row,col, 2, 1));
	}


/*	public boolean knight_movement(int row, int col, int vertical_limiter, int horizontal_limiter){	
		int current_row=this.get_Row_Num();
		int current_col=this.get_Col_Num();
		
		int diff_row=Math.abs(row-current_row);
		int diff_col=Math.abs(col-current_col);

		//note this code was used from the following source: https://github.com/babburra/CS-242/blob/master/Assignment1.0/src/Main/Knight.java
        return ((diff_row == vertical_limiter && diff_col == horizontal_limiter) || (diff_row == horizontal_limiter && diff_col == vertical_limiter));

	}
	
	*/

}