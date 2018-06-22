package static_gui;
import javax.swing.*;
import java.awt.*;

// Used Swing Gui tool kit to build a static gui for the chessboard

public class Gui extends JFrame{
	
	public JButton [][] spaces= new JButton[8][8];
	public ImageIcon []  images= new ImageIcon[10];
	public Container whole_board;
	

	//get images for pawns
	public ImageIcon blk_pawn= new ImageIcon("C:/Users/admin/eclipse-cs242/project1/src/static_gui/blkpwn.png");
	public ImageIcon wht_pawn= new ImageIcon("C:/Users/admin/eclipse-cs242/project1/src/static_gui/white_pawn.png");
	
	
	
	public static final int ROW= 8; 
	public static final int COL= 8;
	
	
	
	public Gui() {
		super("CHESS STATIC BOARD");
		whole_board= getContentPane();
		whole_board.setLayout(new GridLayout(ROW,COL));
	
		
		//initial board setup ( size, color, etc..)
		this.setLocationRelativeTo(null);
		this.setSize(560,560);
		this.setup_board_paint();
		// put pawn pieces on the board
		this.setup_pawns();
		
		store_images();
		// put all other pieces for both black and white pieces
		this.setup_backrow(0,7,true);
		this.setup_backrow(1,5,true);
		this.setup_backrow(2,3,true);
		this.setup_backrow(3,0,false);
		this.setup_backrow(4,0,false);
		
		
		this.setVisible(true);
				
	}

	
	// get images
	public void store_images() {
		
		images[0] = new ImageIcon("C:/Users/admin/chessboard/src/static_gui/blkrook.png");
		images[1] = new ImageIcon("C:/Users/admin/chessboard/src/static_gui/blkknight.png");
		images[2] = new ImageIcon("C:/Users/admin/chessboard/src/static_gui/blkbishop.png");
		images[3] = new ImageIcon("C:/Users/admin/chessboard/src/static_gui/blkking.png");
		images[4] = new ImageIcon("C:/Users/admin/chessboard/src/static_gui/blkqueen.png");
		
		images[5] = new ImageIcon("C:/Users/admin/chessboard/src/static_gui/white_rook.png");
		images[6] = new ImageIcon("C:/Users/admin/chessboard/src/static_gui/white_knight.png");
		images[7] = new ImageIcon("C:/Users/admin/chessboard/src/static_gui/white_bishop.png");
		images[8] = new ImageIcon("C:/Users/admin/chessboard/src/static_gui/white_king.png");
		images[9] = new ImageIcon("C:/Users/admin/chessboard/src/static_gui/white_queen.png");
		
		
		
	}
	
	// set up board's black and white spots
	public void setup_board_paint() {
		
		for(int row=0; row <ROW; row++) {
			for(int col=0; col<COL; col++) {
				spaces[row][col]= new JButton();
			
				if((row+col)%2 == 0) {
					spaces[row][col].setBackground(Color.gray);
					}
				
				else {
					spaces[row][col].setBackground(Color.black);
				}
				whole_board.add(spaces[row][col]);
			}
		
		}		
	}
	
	
	
	// put pawns in the right position on the board
	public void setup_pawns() {
		for(int col=0;col<COL; col++) {
			spaces[1][col].setIcon(blk_pawn);
			spaces[6][col].setIcon(wht_pawn);
		}
	}
	
	// put rook,knight,bishop, queen and king on the right spots of the board
	public void setup_backrow(int col, int diff, boolean twopiece) {
		
		if(twopiece == true) {
			
			spaces[0][col].setIcon(images[col]);
			spaces[0][col+diff].setIcon(images[col]);
			
			
			spaces[7][col].setIcon(images[col+5]);
			spaces[7][col+diff].setIcon(images[col+5]);
			return;			
		}
		
		else {
			spaces[0][col].setIcon(images[col]);
			spaces[7][col].setIcon(images[col+5]);
			return;
		}
		
	}
	
	
	
	public static void main(String[] args)
	{
	  Gui sample_gui = new Gui();
	  sample_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}