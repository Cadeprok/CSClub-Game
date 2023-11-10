/*
 * This class represents a menu for a tic tac toe game
 * It has no data members, merely methods for interfacing with the game
 * 		Feedback:
 * 			Validates Input, onlly allows the player to make a move on a 3x3 grid.
 *		
 */

import java.util.Scanner;

public class menu {
	
	public menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	boolean feedback(int boardPos)
	{
		switch (boardPos) {
		case 1: boardPos = 1;
			System.out.println("TopLeft!");
			return false;
		case 2: boardPos = 2;
			System.out.println("TopMid!");
			return false;
		case 3: boardPos = 3;
			System.out.println("TopRight!");
			return false;
		case 4: boardPos = 4;
			System.out.println("MidLeft!");
			return false;
		case 5: boardPos = 5;
			System.out.println("Center!");
			return false;
		case 6: boardPos = 6;
			System.out.println("MidRight!");
			return false;
		case 7: boardPos = 7;
			System.out.println("BottomLeft!");
			return false;
		case 8: boardPos = 8;
			System.out.println("BottomMid!");
			return false;
		case 9: boardPos = 9;
			System.out.println("BottomRight!");
			return false;
		default:
			System.out.println("Not Valid, Try again!");
			return true;
		}
	}

	int getP1CoordBig()
	{
		boolean control = true;
		int boardPos = 0;
		while(control) {
			Scanner Keyboard = new Scanner(System.in);
			control = false;
			System.out.println("What small board will P1 choose?");
			boardPos = Keyboard.nextInt();
			control = feedback(boardPos);
			}
		return boardPos;
	}

	int getP2CoordBig()
	{
		boolean control = true;
		int boardPos = 0;
		while(control) {
			Scanner Keyboard = new Scanner(System.in);
			control = false;
			System.out.println("What small board will P2 choose?");
			boardPos = Keyboard.nextInt();
			control = feedback(boardPos);
			}
		return boardPos;
	}
	
	int getP1CoordSmall()
	{
		boolean control = true;
		int boardPos = 0;
		while(control) {
			Scanner Keyboard = new Scanner(System.in);
			control = false;
			System.out.println("Where will P1 pick on the small board?");
			boardPos = Keyboard.nextInt();
			control = feedback(boardPos);
			}
		return boardPos;
	}

	int getP2CoordSmall()
	{
		boolean control = true;
		int boardPos = 0;
		while(control) {
			Scanner Keyboard = new Scanner(System.in);
			control = false;
			System.out.println("Where will P2 pick on the small board");
			boardPos = Keyboard.nextInt();
			control = feedback(boardPos);
			}
		return boardPos;
	}
}

