
public class SmartPlayer extends BlockingPlayer {

	
	public SmartPlayer(String name, char mark, Player opponent, Board board) {
		super(name, mark, opponent, board);
	}
	
	public SmartPlayer(String name, char mark) {
		this(name, mark, null, null);
	}
	
	protected void makeMove() {
		
		RandomGenerator generate = new RandomGenerator();		
		
		int row, col;	
			
		//Randomly play 3 mark on the board first
		
		if(board.getMarkCount() < 3) {
			do{
				row = generate.discrete(0, 2);
				col = generate.discrete(0, 2);
			}while(!board.spotEmpty(row, col));
			
			board.addMark(row, col, mark);
			
		}else { // start else #1
			
			int[] winPos = testForWinning(mark);
			
			if(winPos[0] == 1) 
				board.addMark(winPos[1], winPos[2], mark);
			else {//else 2
				winPos = testForWinning(opponent.mark);
				
				if(winPos[0] == 1) 
					board.addMark(winPos[1], winPos[2], mark);
				else { //else 3
					
					do{
						row = generate.discrete(0, 2);
						col = generate.discrete(0, 2);
					}while(!board.spotEmpty(row, col));
					
					board.addMark(row, col, this.mark);
				}//end else 3
				
			}//end else 2		
					
		}//end else 1
			
		board.display();	
		
	}//end makeMove
		
	
	
	
}
