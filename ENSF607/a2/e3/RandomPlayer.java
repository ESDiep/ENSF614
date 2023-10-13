
public class RandomPlayer extends Player {

	public RandomPlayer(String name, char mark, Player opponent, Board board) {
		super(name, mark, opponent, board);
	}
	
	public RandomPlayer(String name, char mark) {
		this(name, mark, null, null);
	}	
	
	
	protected void makeMove() {
		
		RandomGenerator generate = new RandomGenerator();
		int row = generate.discrete(0, 2);
		int col = generate.discrete(0, 2);
		
		while(!board.spotEmpty(row, col)) {
			row = generate.discrete(0, 2);
			col = generate.discrete(0, 2);
		}
		
		board.addMark(row, col, this.mark);
		board.display();
		
	}
}
