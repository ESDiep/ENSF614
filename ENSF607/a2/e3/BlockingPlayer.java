
public class BlockingPlayer extends RandomPlayer {

	
	public BlockingPlayer(String name, char mark, Player opponent, Board board) {
		super(name, mark, opponent, board);
	}
	
	public BlockingPlayer(String name, char mark) {
		this(name, mark, null, null);
	}
	
	protected void makeMove() {
		
		RandomGenerator generate = new RandomGenerator();		
		
		int row, col;	
			
		//randomly play 3 mark on the board first
		
		if(board.getMarkCount() < 3 ) {// if 1
			do{
				row = generate.discrete(0, 2);
				col = generate.discrete(0, 2);
			}while(!board.spotEmpty(row, col));
			
			board.addMark(row, col, mark);
		
		
		}else { //end if 1, start else 1
			//then check to block the opponent
			int[] blockPos = testForWinning(opponent.getMark());
			
			// if blocking found place a mark on this spot to block the opponent from winning
			if(blockPos[0] == 1) 
				board.addMark(blockPos[1], blockPos[2], mark);
			//otherwise, just randomly play on the board	
			else { //else 2
				
				do{
					row = generate.discrete(0, 2);
					col = generate.discrete(0, 2);
				}while(!board.spotEmpty(row, col));
				
				board.addMark(row, col, this.mark);
			}//end else 2
			
			
		}//end else 1
			
		board.display();	
		
	}//end makeMove
	
	/**this function iterate through the entire board, then check EVERY EMPTY SPOT if this spot would make the 
	 * mark win in the next move. 
	 *It returns a 3-element array a[3] where a[0]= 1 if the winning position found, or = 0 if not found
	 *a[1] and a[2] is the coordinate of this winning location
	**/
	protected int[] testForWinning(char mark ){
		
		int[] blockPos = {0,-1,-1};		
		
		for(int row = 0; row < board.getBoard().length; row ++) { // for 1			
			for (int col = 0; col < board.getBoard()[0].length; col++) { // for 2
				// if empty spot found
				if(board.spotEmpty(row, col)) { // if 1
					//place a mark (X or O)
					board.addMark(row, col, mark);
					//check if it is winning
					if(board.checkWinner(mark)== 1){
						blockPos[0] = 1; // found Flag
						blockPos[1] = row;
						blockPos[2] = col;		
						board.clearMark(row, col);
						break;
					} 
					//then clear this mark
					board.clearMark(row, col);
				
				}//end if 1
			} //end for 2
			if(blockPos[0] == 1)
				break;
			
		}// end for 1
		
		return blockPos;
		
	}
}
