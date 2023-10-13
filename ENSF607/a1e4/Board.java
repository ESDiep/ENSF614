

/**
 *  
 * This class represents the board used in a tic-tac-toe game. 
 * It implement the Constants interface which specifies the symbol X, O and space use in the game.
 * 
 * It has two attributes:
 *  - a 3x3 char matrix name theBoard to holds the position of each tic-tac-toe move
 *  - an integer markCount (with values from 0 to 9) that keeps track of the number of moves placed on the board.
 *
 *@author Sieu Eric Diep
 */

public class Board implements Constants {
	private char theBoard[][];
	private int markCount;
	
	/**
	 * Constructor to initialize theBoard[][] to an empty 3x3 matrix that contains space
	 * 
	 * 
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}
	
	/**
	 * This method takes the location (x,y coordinate) of a cell on the tic-tac-toe board 
	 * and return the mark (X, O or space) placed on this cell.
	 * @param row int
	 * @param col int
	 * @return char
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * This method is to check if the board is full
	 * 
	 * @return true if the board is full, false if there is still room on the board.
	 */
	public boolean isFull() {
		return markCount == 9;
	}
	
	/**
	 * This method checks if player with the X-mark win or not
	 * 
	 * @return true if X wins, or false if X does not win
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}
	
	/**
	 * This method checks if player with the O-mark win or not
	 * @return true if O wins, or false if O does not win
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}
	
	/**
	 * This method displays a visual representation of the tic-tac-toe board with the corresponding mark on it
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * This methods adds a char value mark to theBoard[][] attribute, and increase markCount accordingly.
	 * @param row int
	 * @param col int 
	 * @param mark char
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}
	
	/**
	 * This method to reset and clear the whole tic-tac-toe board. All value is replaced with space.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * This method check if there is a winner in the tic-tac-toe game
	 * @param mark
	 * @return 1 if a winner found, 0 if winner not found
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * This method displays the header of each column of the tic-tac-toe board. i.e. columns 0,1,2
	 * 
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}
	
	/**
	 * This method displays the +_____ on the screen to create a visual representation of the board.
	 * 
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}
	
	/**
	 * This method displays empty space on the screen to create a visual representation of the board.
	 * 
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
	
	/**
	 * This method is the getter of theBoard[][] attribute
	 * @return a 3x3 matrix
	 */
	public char[][] getBoard(){
		return theBoard;
	}
	
	/**
	 * This method takes 2 integers which are the location of cell on the tic-tac-toe board and check if the spot is empty. 
	 * @param row int
	 * @param col int
	 * @return true if the spot is empty, else return false
	 */
	public boolean spotEmpty(int row, int col) {
		
		return (theBoard[row][col] == SPACE_CHAR ) ? true : false;
	}
}
