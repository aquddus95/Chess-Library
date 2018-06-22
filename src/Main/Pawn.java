package Main;

public class Pawn extends Piece{

	private boolean initial_move;
	public Pawn(Space[][] some_board,int player_num,int row, int col){
		super(some_board,player_num,row,col);
		initial_move=true;
	}

	public boolean can_move(int row, int col){
		boolean valid_move;
		if(false==this.in_bound(row,col)){
			return false;
		}
		
		int which_player= this.get_Owner();
		
		
		if(which_player == 1){
			valid_move= can_move1(1,row,col);
		}
		else{
			valid_move=can_move1(-1, row,col);
		}
		return valid_move;
	}

	/**
     * move function for pawn that can move forward and diagonally 
     * @param up_down set which direction is up_down if -1 moving forward from player2 perspective if 1 moving forward from player1 perspective
     * @param row row  destination number on board of piece
     * @param col col  destination number on board of piece
     */
	
	public boolean can_move1(int up_down,int row, int col){	
		int current_row=this.get_Row_Num();
		int current_col=this.get_Col_Num();
		int diff_row=row-current_row;
		int diff_col=col-current_col;
//initial move
		if(diff_row == (2*up_down) && diff_col==0 ){
			if(initial_move == true && space_is_empty(current_row+(up_down),current_col) == true && space_is_empty(row,col) == true){
				//move function in board class must check set this piece to have moved from its initial spot	
				return true;	
			}
		}	
//forward
		if(diff_row ==(up_down) && diff_col == 0 && space_is_empty(current_row+(up_down),col) == true){
			return true;
		}
//diagonal		
		if(diff_row == (up_down) && diff_col ==1 && space_is_empty(current_row+(up_down),current_col+1) == false){
			return true;
		}
//diagonal
		if(diff_row == (up_down) && diff_col == -1 &&space_is_empty(current_row+(up_down),current_col-1) == false ){
			return true;
		}	


		return false;
	}
	
	
	

	
/*
	public boolean can_move1(int row, int col){	
		int current_row=this.get_ Row_Num();
		int current_col=this.get_Col_Num();
		int diff_row=row-current_row;
		int diff_col=col-current_col;
//initial move
		if(diff_row == 2 && diff_col==0 ){
			if(initial_move == true && space_is_empty(current_row+1,current_col) == true && space_is_empty(row,col) == true){
				//move function in board class must check set this piece to have moved from its initial spot	
				return true;	
			}
		}	
//forward
		if(diff_row ==1 && diff_col == 0 && space_is_empty(current_row+1,col) == true){
			return true;
		}
//diagonal		
		if(diff_row == 1 && diff_col ==1 && space_is_empty(current_row+1,current_col+1) == false){
			return true;
		}
//diagonal
		if(diff_row == 1 && diff_col == -1 &&space_is_empty(current_row+1,current_col-1) == false ){
			return true;
		}	


		return false;
	}



	public boolean can_move2(int row, int col){
		int current_row=this.get_Row_Num();
		int current_col=this.get_Col_Num();
		int diff_row=row-current_row;
		int diff_col=col-current_col;

		if(diff_row == (-2) && diff_col==0 ){
			if(initial_move == true && space_is_empty(current_row-1,current_col) == true && space_is_empty(row,col) == true){
				//move function in board class must check set this piece to have moved from its initial spot	
				return true;	
			}
		}	

		if(diff_row == (-1) && diff_col == 0 && space_is_empty(current_row-1,col) == true){
			return true;
		}
		
		if(diff_row == (-1) && diff_col ==1 && space_is_empty(current_row-1,current_col+1) == false){
			return true;
		}

		if(diff_row == (-1) && diff_col == (-1) && space_is_empty(current_row-1,current_col-1) == false ){
			return true;
		}	

		return false;	
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