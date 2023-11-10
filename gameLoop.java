/*
 * This class represents the gameloop of an ongoing TicTacToe game
 * It has two data members
 * that being a class representing a super tic tac toe board
 * and a class that represents a menu for interfacing with the board.
 */
public class gameLoop {
	private big superBoard;
	private menu gameMenu;
	
	public gameLoop() {
		super();
		superBoard = new big();
		gameMenu = new menu();
	}
	

	public void Loop()
	{
		while(superBoard.getGameState() == State.ONGOING)
		{

			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					superBoard.getBoardMember(i,j).printSmall();
				}
				System.out.println();
			}

			superBoard.setBoardMemberMember(gameMenu.getP1CoordBig(), gameMenu.getP1CoordSmall(), 'X');
			superBoard.setBoardMemberMember(gameMenu.getP2CoordBig(), gameMenu.getP2CoordSmall(), 'O');

			
		}		
	}
}
