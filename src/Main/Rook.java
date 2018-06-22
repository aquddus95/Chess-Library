package Main;

public class Rook extends Piece{

	public Rook(Space[][] some_board,int player_num,int row, int col){
		super(some_board,player_num,row,col);
	}

	public boolean can_move(int row, int col){
		boolean valid;
		if(!(this.in_bound(row,col))){
			return false;
		}
		valid=(can_move12(row,col));
		return valid;
	}

	/**
     * move function for rook can go horizontally or vertically for movements only 
     * @param row row  destination number on board of piece
     * @param col col  destination number on board of piece
     */
	public boolean can_move12(int row, int col){	
		int current_row=this.get_Row_Num();
		int current_col=this.get_Col_Num();
		int diff_row=row-current_row;
		int diff_col=col-current_col;


		// move down
		if(diff_row != 0 && diff_col==0 && diff_row > 0 ){
			return (move_it_leftright_updown(current_row,current_col,diff_row,diff_col, 1, 0, diff_row));	
		}
		// move up
		if(diff_row != 0 && diff_col==0 && diff_row < 0 ){
			return (move_it_leftright_updown(current_row,current_col,Math.abs(diff_row),diff_col, (-1), 0, Math.abs(diff_row)));	
		}
		
		// move right
		if(diff_row == 0 && diff_col !=0 && diff_col > 0 ){
			return (move_it_leftright_updown(current_row,current_col,diff_row,diff_col,0,1, diff_col));	
		}
		// move left
		if(diff_row == 0 && diff_col !=0 && diff_col < 0 ){
			return (move_it_leftright_updown(current_row,current_col,diff_row,Math.abs(diff_col),0,(-1), Math.abs(diff_col)));	
		}

		return false;
	}

	
	

	
	
	
	

 	/*public boolean up_down(int current_row,int current_col, int diff_row, int diff_col){
 		boolean piece_in_path=false;

		if (diff_row > 0){
			for(int i= 1; i<diff_row; i++){
				if(space_is_empty((current_row+i),current_col)==false){
					piece_in_path=true;
				}
			}
		}
			
		else{
			diff_row= (-1)* diff_row;
			for(int i= 1; i<diff_row; i++){
				if(space_is_empty((current_row-i),current_col)==false){
					piece_in_path=true;
				}
			}
		}	

		if(piece_in_path){
			return false;
		}

		return true;
 	}


*/
 /*	public boolean left_right(int current_row,int current_col, int diff_row, int diff_col){
 		boolean piece_in_path=false;

		if (diff_col > 0){
			for(int i= 1; i<diff_col; i++){
				if(space_is_empty(current_row,(current_col+i))==false){
					piece_in_path=true;
				}
			}
		}
			
		else{
			diff_col= Math.abs(diff_col);
			for(int i= 1; i<diff_col; i++){
				if(space_is_empty(current_row,(current_col-i))==false){
					piece_in_path=true;
				}
			}
		}	

		if(piece_in_path){
			return false;
		}

		return true;
 	}


*/
/*
	public boolean in_bound(int row, int col){
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