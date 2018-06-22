package Main;


public class New_Piece2 extends Piece{

	public New_Piece2(Space[][] some_board,int player_num,int row, int col){
		super(some_board,player_num,row,col);
	}

	/**
     * move horizontally and vertically by pairs of 1 skips (diagonal by one space) or move left/right 
     * @param row row  destination number on board of piece
     * @param col col  destination number on board of piece
     */
	
	public boolean can_move(int row, int col){
		if(!(in_bound(row,col))){
			return false;
		}
		
		if(this.skip_movement(row,col, 1, 1)) {
			return true;
		};
		
		
		int current_row=this.get_Row_Num();
		int current_col=this.get_Col_Num();
		int diff_row=row-current_row;
		int diff_col=col-current_col;
		

		if(diff_row == 0 && diff_col !=0 && diff_col > 0 ){
			return (move_it_leftright_updown(current_row,current_col,diff_row,diff_col,0,1, diff_col));	
		}
		
		if(diff_row == 0 && diff_col !=0 && diff_col < 0 ){
			return (move_it_leftright_updown(current_row,current_col,diff_row,Math.abs(diff_col),0,(-1), Math.abs(diff_col)));	
		}
		
		return false;
	}
}