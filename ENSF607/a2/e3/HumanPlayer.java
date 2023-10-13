import java.util.Scanner;

public class HumanPlayer extends Player {

	public HumanPlayer(String name, char mark, Player opponent, Board board) {
		super(name, mark, opponent, board);
	}
	
	public HumanPlayer(String name, char mark) {
		this(name, mark, null, null);
	}
	
	
	
	public void makeMove(){
	
	Scanner reader = new Scanner(System.in);
		
	int row = -1;
	int col = -1;
	
	while(true){
		try {
			// prompt user to input 2 integers for the cell location. 
			// Throw an exception if the number input is outside the range of the board
				do {
					System.out.print(name + ", what row should your next '" + mark +  "' be placed in?" );
					row = Integer.parseInt(reader.next());
					if(row <0 || row > board.getBoard().length) // throw an exception if the input is <0 and >3
						throw new NumberFormatException();
				
					System.out.print(name + ", what column should your next'" + mark +  "' be placed in?" );
					col = Integer.parseInt(reader.next());
					if(col <0 || col > board.getBoard().length)
						throw new NumberFormatException();
					//check if the spot chosen is full. Prompt the player to choose another spot if it is full
					if(!board.spotEmpty(row, col))
						System.out.println("The spot you choose is full. Please choose another spot \n");
				}while(!board.spotEmpty(row,col));
				
				break;
		}
		catch (NumberFormatException e){
			System.out.println("  Invalid entry, please enter a number between 0 and " + board.getBoard().length + "\n");
		}
	}
	
	board.addMark(row, col, mark);
	board.display();
	

}
}
