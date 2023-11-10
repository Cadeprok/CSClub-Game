/*
 * This file represents a Super Tic Tac Toe board. That is a Tic Tac Toe board of Tic Tac Toe Boards.
 * We can consider this to be a 3x3 array of previously defined Tic Tac Toe boards.
 * Methods to interact with the board:
 * 	getGameState():
 * 		Looks for a three way line going through the board of either P1WINs or P2WINSs
 * 		Returns P1WIN for a line of P1WINSs
 * 		P2WIN for a line of P2WINSs
 * 		ONGOING if there is no line and free spaces
 * 		DRAW if there is no line and no free spaces
 *  getBoard()
 *  	Returns the board
 *  setBoard()
 *  	Sets the board
 *  getBoardMember()
 *  	Returns a small board
 *
 *  setBoardMember
 *  	Sets a given member of the board
 *  	Assumes the player is being prompted to add a coordinate by associating the tic tac toe board with reverse numpad key notation
 *		1 2 3
 *		4 5 6
 *		7 8 9
 *		And such we take advantage of the linear relationship
 *		row = (index-1)/3, column = (index-1)%3
 *		to map the players input to a board space.  	
 *	setBoardMemberMember
 *		See above but we also pass a value to the small board.
 */
public class big {
	public big() {
		for(int i = 0; i < 3; i++)
			for(int k = 0; k < 3; k++) {
				board[i][k] = new small();
			}
	}

	private small[][] board= new small[3][3];
	
	
	public State getGameState() {
		State gamestate = State.ONGOING;

		for(int row = 0; row < 3; row++){
			if(this.getBoardMember(row, 0).getGameState() == State.P1WIN 
			&& this.getBoardMember(row, 1).getGameState() == State.P1WIN
			&& this.getBoardMember(row, 2).getGameState() == State.P1WIN){
				gamestate = State.P1WIN;
			}
			if(this.getBoardMember(row, 0).getGameState() == State.P2WIN 
			&& this.getBoardMember(row, 1).getGameState() == State.P2WIN
			&& this.getBoardMember(row, 2).getGameState() == State.P2WIN){
				gamestate = State.P2WIN;
			}
		}
		for(int col = 0; col < 3; col++){
			if(this.getBoardMember(0, col).getGameState() == State.P1WIN 
			&& this.getBoardMember(1, col).getGameState() == State.P1WIN
			&& this.getBoardMember(2, col).getGameState() == State.P1WIN){
				gamestate = State.P1WIN;
			}
			if(this.getBoardMember(0, col).getGameState() == State.P2WIN 
			&& this.getBoardMember(1, col).getGameState() == State.P2WIN
			&& this.getBoardMember(2, col).getGameState() == State.P2WIN){
				gamestate = State.P2WIN;
			}
		}
		//checks the 2 diagonals
		if(this.getBoardMember(0, 0).getGameState() == State.P1WIN 
		&& this.getBoardMember(1, 1).getGameState() == State.P1WIN
		&& this.getBoardMember(2, 2).getGameState() == State.P1WIN){
			gamestate = State.P1WIN;
		}
		if(this.getBoardMember(0, 0).getGameState() == State.P2WIN 
		&& this.getBoardMember(1, 1).getGameState() == State.P2WIN
		&& this.getBoardMember(2, 2).getGameState() == State.P2WIN){
			gamestate = State.P2WIN;
		}
		if(this.getBoardMember(0, 2).getGameState() == State.P1WIN 
		&& this.getBoardMember(1, 1).getGameState() == State.P1WIN
		&& this.getBoardMember(2, 0).getGameState() == State.P1WIN){
			gamestate = State.P1WIN;
		}
		if(this.getBoardMember(0, 2).getGameState() == State.P2WIN 
		&& this.getBoardMember(1, 1).getGameState() == State.P2WIN
		&& this.getBoardMember(2, 0).getGameState() == State.P2WIN){
			gamestate = State.P2WIN;
		}
		return gamestate;
	}
	
	public small[][] getBoard() {
		return board;
	}

	public void setBoard(small[][] board) {
		this.board = board;
	}
	
	public small getBoardMember(int row, int column) {
		return board[row][column];
	}

	public void setBoardMember(int row, int column, small play) {
		this.board[row][column] = play;
	}
	
	public void setBoardMemberMember(int playerInputBig, int playerInputSmall, char player) {
		board[(playerInputBig-1)/3][(playerInputBig-1)%3].setBoardMember(playerInputSmall, player);
	}
}
