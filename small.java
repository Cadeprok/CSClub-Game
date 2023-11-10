/*
 * This file represents a tic tac toe board
 * We can consider a tic tac toe board to be a 3x3 array of characters
 * Methods to interact with the board:
 * 	getGameState()
 * 		Looks for a three way line going through the board of either x's or o's
 * 		Returns P1WIN for a line of X's
 * 		P2WIN for a line of O's
 * 		ONGOING if there is no line and free spaces
 * 		DRAW if there is no line and no free spaces
 *  getBoard()
 *  	Returns the board
 *  	useful for debugging and graphical implementation
 *  setBoard()
 *  	Sets the board
 *  	Debugging and starting the game loop
 *  getBoardMember
 *  	Gets a given member of the Board
 *  setBoardMember
 *  	Sets a given member of the board
 *  	Assumes the player is being prompted to add a coordinate by associating the tic tac toe board with reverse numpad key notation
 *		1 2 3
 *		4 5 6
 *		7 8 9
 *		And such we take advantage of the linear relationship
 *		row = (index-1)/3, column = (index-1)%3
 *		to map the players input to a board space.  	
 */

public class small {
	private char[][] board = new char[3][3];
	
	public small() {
		for(int i = 0; i < 3; i++)
			for(int k = 0; k < 3; k++) {
				board[i][k] = 'e';
			}
	}
	
	public State getGameState() {
		State gamestate = State.ONGOING;

		for(int row = 0; row < 3; row++){
			if(this.getBoardMember(row, 0) == 'X' 
			&& this.getBoardMember(row, 1) == 'X'
			&& this.getBoardMember(row, 2) == 'X'){
				gamestate = State.P1WIN;
			}
			if(this.getBoardMember(row, 0) == 'O'
			&& this.getBoardMember(row, 1) == 'O'
			&& this.getBoardMember(row, 2) == 'O'){
				gamestate = State.P2WIN;
			}
		}
		for(int col = 0; col < 3; col++){
			if(this.getBoardMember(0, col) == 'X' 
			&& this.getBoardMember(1, col) == 'X'
			&& this.getBoardMember(2, col) == 'X'){
				gamestate = State.P1WIN;
			}
			if(this.getBoardMember(0, col) == 'O' 
			&& this.getBoardMember(1, col) == 'O'
			&& this.getBoardMember(2, col) == 'O'){
				gamestate = State.P2WIN;
			}
		}
		//checks the 2 diagonals
		if(this.getBoardMember(0, 0) == 'X' 
		&& this.getBoardMember(1, 1) == 'X'
		&& this.getBoardMember(2, 2) == 'X'){
			gamestate = State.P1WIN;
		}
		if(this.getBoardMember(0, 0) == 'O' 
		&& this.getBoardMember(1, 1) == 'O'
		&& this.getBoardMember(2, 2) == 'O'){
			gamestate = State.P2WIN;
		}
		if(this.getBoardMember(0, 2) == 'X' 
		&& this.getBoardMember(1, 1) == 'X'
		&& this.getBoardMember(2, 0) == 'X'){
			gamestate = State.P1WIN;
		}
		if(this.getBoardMember(0, 2) == 'O' 
		&& this.getBoardMember(1, 1) == 'O'
		&& this.getBoardMember(2, 0) == 'O'){
			gamestate = State.P2WIN;
		}
		return gamestate;
	}
	
	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}
	
	public char getBoardMember(int row, int column) {
		return board[row][column];
	}

	public void setBoardMember(int playerInput, char player) {
		if(this.getBoardMember((playerInput-1)/3, (playerInput-1)%3) == 'e'){
			board[(playerInput-1)/3][(playerInput-1)%3] = player;
		} else {
			System.out.println("Taken!");

		}
	}

	public void printSmall(){
		for(int i = 0; i < 3; i++){
			System.out.println();
			for(int j = 0; j < 3; j++){
				System.out.print(" " + this.getBoardMember(i, j));
			}
		}
	}
}

