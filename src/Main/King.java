package Main;

public class King extends Piece{

	boolean check;
	Player opposing_player;

	public King(Space[][] some_board,int player_num,int row, int col, Player opposing_player1){
		super(some_board,player_num,row,col);
		opposing_player=opposing_player1;
		check=false;
	}

	public boolean can_move(int row, int col){
		boolean valid;
		if(!(in_bound(row,col))){
			return false;
		}
		valid=(can_move12(row,col));
		return valid;
	}

	/**
     * move function for king can go diagonally left or right but by only one space movement 
     * @param row row  destination number on board of piece
     * @param col col  destination number on board of piece
     */
	
	public boolean can_move12(int row, int col){	
		int current_row=this.get_Row_Num();
		int current_col=this.get_Col_Num();
		
		int diff_row=Math.abs(row-current_row);
		int diff_col=Math.abs(col-current_col);

		//note this code was used from the following source: https://github.com/babburra/CS-242/blob/master/Assignment1.0/src/Main/Knight.java
        return (((diff_row == 1 && diff_col == 1) || (diff_row == 1 && diff_col == 0)||(diff_row == 0 && diff_col == 1))&& in_check(row,col)==false);

	}

	public boolean checkmate(){
		int row=this.get_Row_Num();
		int col=this.get_Col_Num();			
		boolean valid= (this.can_move(row+1,col-1) || this.can_move(row-1,col+1) || this.can_move(row+1,col+1)|| this.can_move(row-1,col-1)||this.can_move(row+1,col)||this.can_move(row-1,col)||this.can_move(row,col-1)||this.can_move(row,col+1));
		return ((valid== false) && (check == true));
	}

	
	/**
     * check if this new spot will cause the king to become in check
     * @param row row  destination number on board of piece
     * @param col col  destination number on board of piece
     */
	
	public boolean in_check(int row, int col){
		boolean[][] opp_piece=opposing_player.get_My_Pieces();
		Space[][] game_board=this.get_Board();
		Space holder;

		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){

				if( opp_piece[i][j]== true){

				holder=game_board[i][j];
				Piece some_piece=holder.get_Piece();	
					if(some_piece.can_move(row,col)){
						return true;
					}
				}	


			}
		}

		return false;
	}


}