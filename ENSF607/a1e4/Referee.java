
import java.util.Scanner;
/**
 * This class represents a referee in a tic-tac-toe game.
 * This class would manage 2 Player object (x and o), and a tic-tac-toe Board object.
 * - 
 */
public class Referee {

	private Player xPlayer;
	private Player oPlayer;
	private Board board;
	
	/**
	 * constructor to create a referee object with the 3 parameters.
	 * @param xPlayer: Player
	 * @param oPlayer: Player
	 * @param board: Board
	 */
	public Referee(Player xPlayer, Player oPlayer, Board board) {
		this.xPlayer = xPlayer;
		this.oPlayer = oPlayer;
		this.board = board;
	}
	/**
	 * Constructor to create a referee object with no parameter.
	 */
	public Referee() {
		this(null, null, null);
		
	}
	/**
	 * This method runs the game for the referee. 
	 * It starts by announcing the game, setting the player and display the board. Then, it lets each player makes a move on the board,
	 * and check whether the board is full, or if there is a winner.
	 * 
	 * Once the board is full or there is a winner, it will stop the game and announce the result.
	 */
	public void runTheGame() {
		
		//setting up the game
		Scanner reader = new Scanner(System.in);
		System.out.println("\nReferee started the game...");
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		
		//stop the game if the board is full or there is one winner
		while(!board.isFull() && !board.oWins() && !board.xWins()) {
			xPlayer.play(reader);
			if(board.xWins() || board.isFull())
				break;
			oPlayer.play(reader);			
		}
		reader.close();//closing the scanner
		//Announcing the result of the games
		if(board.oWins())
			System.out.println("Game overs! " + oPlayer.getName() + " wins");
		else if(board.xWins())
			System.out.println("Game overs! " + xPlayer.getName() + " wins");
		else
			System.out.println("Game overs! Tie");
		
	}
	
	/**
	 * This method sets up the Board object
	 * @param board: Board
	 */
	public void setBoard(Board board) {
		this.board = board;
		
	}
	
	/**
	 * This method set up the Player with mark O
	 * @param oPlayer: Player
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
	
	/**
	 * This method set up the Player with mark X
	 * @param xPlayer Player with mark X
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}
	
	
}
