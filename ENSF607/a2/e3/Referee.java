
import java.util.Scanner;

public class Referee {

	private Player xPlayer;
	private Player oPlayer;
	private Board board;
	
	//constructor
	public Referee(Player xPlayer, Player oPlayer, Board board) {
		this.xPlayer = xPlayer;
		this.oPlayer = oPlayer;
		this.board = board;
	}
	public Referee() {
		this(null, null, null);
		
	}
	public void runTheGame() {
		
		
		System.out.println("\nReferee started the game...");
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		
		while(!board.isFull() && !board.oWins() && !board.xWins()) {
			xPlayer.play();
			if(board.xWins() || board.isFull())
				break;
			oPlayer.play();
			
		}
		
		if(board.oWins())
			System.out.println("Game overs! " + oPlayer.getName() + " wins");
		else if(board.xWins())
			System.out.println("Game overs! " + xPlayer.getName() + " wins");
		else
			System.out.println("Game overs! Tie");
		
	}
	
	public void setBoard(Board board) {
		this.board = board;
		
	}
	
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
	
	public void setxPlayer(Player xPlayer) {
		
		this.xPlayer = xPlayer;
	}
	
	
}
