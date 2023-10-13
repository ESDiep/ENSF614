
import java.io.*;


/**
 * This class represents a game of tic-tac-toe.
 * It has two attributes:
 *  - a Board object that represents a tic-tac-toe board
 *  - a Referee object that represents a referee in a tic-tac-toe game.
 *  
 * This class also has a main method that runs/simulates a tic-tac-toe game.
 * 
 * @author EricDiep
 *
 */

public class Game implements Constants {

	private Board theBoard;
	private Referee theRef;
	
	/**
	 * Constructor: Constructing the Game object with a new board.
	 */
    public Game( ) {
        theBoard  = new Board();
	}
    
    /**
     * This method appoint a referee for a tic-tac-toe game. 
     * And run the game by calling the runTheGame() method in the Referee object.
     * @param r Referee
     * @throws IOException to catch bad user input
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
    /**
     * This main program is to run the tic-tac-toe game by setting up a Referee, 2 Players and a Board
     *  Then it simulates the game where the two players will taking turn to play.
     * @param args standard argument
     * @throws IOException to catch bad input from user
     */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: "); // ask for user input 
		String name= stdin.readLine(); //validate the input
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X); // create X-player and set the board accordingly
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O); // create O player and set the board accordingly
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee(); // create a referee and set the board, players accordingly
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}
