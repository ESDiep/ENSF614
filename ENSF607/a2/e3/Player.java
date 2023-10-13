import java.util.Scanner;
//import java.util.NumberFormatException;

abstract public class Player {

	protected String name;
	protected Board board;
	protected Player opponent;
	protected char mark;
	
	public Player(String name, char mark, Player opponent, Board board) {
		this.name = name;
		this.mark = mark;
		this.opponent = opponent;
		this.board = board;
	}
	
	public Player(String name, char mark) {
		this(name, mark, null, null);
	}
	
	
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	public void setBoard(Board theBoard) {
		this.board = theBoard;		
	}
	
	public String getName() {
		return name;
	}
	
	public char getMark() {
		return mark;
	}
	
	public void play() {			
		makeMove();	
		
	} 
	
	abstract protected void makeMove();
	
}
