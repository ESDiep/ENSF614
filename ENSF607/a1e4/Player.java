
import java.util.Scanner;

/**
 * This class represents a Player in a tic-tac-toe game.
 * A Player would have:
 *  - a name in string
 *  - a board object that simulates a tic-tac-toe board
 *  - a tic-tac-toe mark i.e. either X or O
 *  - and an opponent which is also a Player object
 * 
 * @author Sieu Eric Diep
 */

public class Player {

	private String name;
	private Board board;
	private Player opponent;
	private char mark;
	
	/**
	 * Constructor to create a player with 4 parameters
	 * @param name: String
	 * @param mark: char
	 * @param opponent: Player
	 * @param board: Board
	 */
	public Player(String name, char mark, Player opponent, Board board) {
		this.name = name;
		this.mark = mark;
		this.opponent = opponent;
		this.board = board;
	}
	
	/**
	 * Constructor with 2 parameters.
	 * @param name: String
	 * @param mark: char
	 */
	public Player(String name, char mark) {
		this(name, mark, null, null);
	}
	
	/**
	 * This method lets the player to play the tic-tac-toe game
	 * by making a move (i.e. calling the makeMove method below).
	 * It takes a Scanner object as an argument to read user input.
	 * @param reader: Scanner
	 */
	public void play(Scanner reader) {			
		makeMove(reader);	
		
	}
	
	/**
	 * This method takes user-input about the location of a cell on a tic-tac-toe board 
	 * and places a mark on the board. 
	 * It takes a Scanner object as an argument to read user input.
	 * @param reader: Scanner
	 */
	public void makeMove(Scanner reader){		
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
				
				break; //exit the infinite loop when input is good
			}
			catch (NumberFormatException e){
				System.out.println("  Invalid entry, please enter a number between 0 and " + board.getBoard().length + "\n");
			}
		}
		//add mark on the board then display the board
		board.addMark(row, col, mark);
		board.display();		
	
	}
	
	/**
	 * This method sets the opponent of the player
	 * @param opponent: Player
	 */
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	/**
	 * This method sets the board for the player.
	 * @param theBoard: Board
	 */
	public void setBoard(Board theBoard) {
		this.board = theBoard;		
	}
	
	/**
	 * Getter: return the name of the player
	 * @return name: String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter: return the mark of the player
	 * @return mark: char
	 */
	public char getMark() {
		return mark;
	}
	
	
}
