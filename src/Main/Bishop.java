 
package Main;

public class Bishop extends Piece{

	public Bishop(Space[][] some_board,int player_num,int row, int col){
		super(some_board,player_num,row,col);
	}

	public boolean can_move(int row, int col){
		boolean valid;
		if(!(in_bound(row,col))){
			return false;
		}
		
		valid=can_move12(row, col);
		return valid;
	}

	/**
     * move function for bishop that can move diagonally only 
     * @param row row  destination number on board of piece
     * @param col col  destination number on board of piece
     */

	public boolean can_move12(int row, int col){	
		int current_row=this.get_Row_Num();
		int current_col=this.get_Col_Num();
		int diff_row=row-current_row;
		int diff_col=col-current_col;

		//left_up
		if(diff_row < 0 && diff_col== diff_row ){
			return (move_it_leftright_updown(current_row,current_col,Math.abs(diff_row),diff_col,-1,-1,Math.abs(diff_row)));	
		}

		//right_down
		if(diff_row > 0 && diff_col== diff_row ){
			return (move_it_leftright_updown(current_row,current_col,diff_row,diff_col,1,1,diff_row));	
		}
		//left_down
		if(diff_row > 0 && (((-1)*diff_col)== diff_row) ){
			return (move_it_leftright_updown(current_row,current_col,diff_row,diff_col,1,-1,diff_row));
		}
		//right_up
		if(diff_row < 0 && (((-1)*diff_row)== diff_col) ){
			return (move_it_leftright_updown(current_row,current_col,diff_row,diff_col,-1,1,diff_col));
		}				

		return false;
	}


	/*public boolean right_down(int current_row,int current_col, int diff_row, int diff_col){
 		boolean piece_in_path=false;

		for(int i= 1; i<diff_row; i++){
			if(space_is_empty((current_row+i),(current_col+i))==false){
				piece_in_path=true;
			}
		}
				
		if(piece_in_path){
			return false;
		}

		return true;
 	}

 	public boolean right_up(int current_row,int current_col, int diff_row, int diff_col){
 		boolean piece_in_path=false;

		for(int i= 1; i<diff_col; i++){
			if(space_is_empty((current_row-i),(current_col+i))==false){
				piece_in_path=true;
			}
		}
				
		if(piece_in_path){
			return false;
		}

		return true;
 	}


 	public boolean left_down(int current_row,int current_col, int diff_row, int diff_col){
 		boolean piece_in_path=false;

		for(int i= 1; i<diff_row; i++){
			if(space_is_empty((current_row+i),(current_col-i))==false){
				piece_in_path=true;
			}
		}
				
		if(piece_in_path){
			return false;
		}

		return true;
 	}

 	public boolean left_up(int current_row,int current_col, int diff_row, int diff_col){
 		boolean piece_in_path=false;
 		diff_row=diff_row*(-1);
		for(int i= 1; i<diff_row; i++){
			if(space_is_empty((current_row-i),(current_col-i))==false){
				piece_in_path=true;
			}
		}
				
		if(piece_in_path){
			return false;
		}

		return true;
 	}

*/

	/*public boolean in_bound(int row, int col){
		if( row< 0 || row>7 || col <0 || col> 7){
			return false;
		}
		else{
		return true;	
		}
	}

	public boolean space_is_empty(int row, int col){
		Space[][] current_board=this.get_Board();
		Space holder=current_board[row][col];
		boolean empty=holder.get_Empty();
		return empty;
	}

	 */

}