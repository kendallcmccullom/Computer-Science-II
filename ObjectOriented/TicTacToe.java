package ObjectOriented;
//TicTacToe.java
//Kendall McCullom

import java.util.Scanner;

public class TicTacToe
{
	public static void main (String [] args)
	{
		Board b = new Board();
		Scanner input = new Scanner(System.in);
		int turn = 1; //counts which turn it is, increase with each loop
		int k = 0;
		char player;
		System.out.println(b); //prints out empty board
		while (true) //continues looping until broken
		{
			//determines whose move it is
			if (turn % 2 == 0) 
			{
				player = 'O';
			}
			else
			{
				player = 'X';
			}
			
			if (turn>k) //only prints the board if the move was valid, because otherwise it is the same players move
			{
				System.out.println("\nIt's player " + player + "'s turn");
			}
			
			System.out.print("Enter a row (1 to 3): ");
			int row = input.nextInt();	
			System.out.print("Enter a column (1 to 3): ");
			int column = input.nextInt();
			
			if (!b.isValidMove(row, column))
			{
				System.out.println("Invalid move");
				k=turn; //makes it so player remains the same
				continue; //starts loop over without changing player with prompts so player will input a valid move
			}
			
			b.makeMove(player, row, column);
			System.out.println(b); //prints board
			k=turn; 
			turn++; //so board will be printed and the new player will be prompted

			if (!b.gameWon() && turn >9)//if the game is not won and there are no more moves
			{
				System.out.println("Tie game!");
				break;
			}
			else if (b.gameWon()) //if the game is won
			{
				System.out.println("Player " + player + " won!");
				break;
			}
		}
		input.close();
	}
}
