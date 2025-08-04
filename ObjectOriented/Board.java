package ObjectOriented;
//Class for a board object
//Kendall McCullom

public class Board
{
	public static final int SIZE = 3;

	private char [][] board;

	//initializes board by placing a dot in each cell
	public Board()
	{
		board = new char[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++)
		{
			for (int c = 0; c < SIZE; c++)
			{
				this.board [r][c] = '.';
			}
		}
	}

	//places player's symbol on specified row and column
	public void makeMove(char p, int r, int c)
	{
		if (isEmpty(r-1,c-1)) //r-1 and c-1 because the input will be 1-3, while the index is 0-2
		{
			board [r-1][c-1] = p;
		}
	}
	
	//returns true if row and column are within board 
	public boolean isValidMove(int r, int c)
	{
		if ((r == 1 || r==2 || r==3) && (c == 1 || c==2 || c==3 ) && isEmpty(r-1,c-1))
		{
			return true;
		}
		return false;
	}

	//returns true if space is unfilled
	public boolean isEmpty(int r, int c)
	{
		if (board [r][c] == '.') //if the space is occupied by a ., that means the space is empty
		{
			return true;
		}
		return false; 
	}

	//returns true if any row, column, or diagonal is filled with
	//one player's symbol
	public boolean gameWon()
	{
		int score = 0; 
		
		//checks for winner horizontally
		for (int r = 0; r<SIZE; r++)
		{
			for (int c = 0; c<SIZE; c++)
			{
				if (isEmpty(r,c))
				{
					score = 0; //score reset if there is an empty space, because no winner in that column
					break;//move to next column
				}
				if (board [r][c]== board [r][0])
				{
					score +=10;
				}
				else //if they are not equal, then don't have a winner in that column, move to next column
				{
					score = 0;
					break;
				}
			}
			if (score == 30) //if score is 30, you have a winner
			{
				return true;
			}
		}
		
		
		//checks for winner vertically
		for (int c = 0; c<SIZE; c++)
		{
			for (int r = 0; r<SIZE; r++)
			{
				if (isEmpty(r,c))
				{
					score = 0; //score reset if there is an empty space, because no winner in that column
					break;//move to next column
				}
				if (board [r][c]== board [0][c])
				{
					score +=10;
				}
				else //if they are not equal, then don't have a winner in that column, move to next column
				{
					score = 0;
					break;
				}
			}
			if (score == 30) //if score is 30, you have three in a row, so there is a winner
			{
				return true;
			}
		}
		
		//checks for winner diagonally
		for (int r = 0; r<SIZE;r++)
		{
				if (board[r][r] != board [0][0])
				{
					break;
				}
				if (isEmpty(r,r)) //if one of the three spots empty, no winner on the diagonal
				{
					break;
				}
				else if (r==SIZE-1) ////if you make it to the third rotation of the loop and haven't broken out, you know you have a winner
				{
					return true;
				}
		}
		
		//checks for winner on the anti diagonal
		for (int r = 0; r<SIZE; r++)
		{
				if (board [r][SIZE-1-r] != board [0][SIZE-1])
				{
					break;
				}
				if(isEmpty(r, SIZE-r-1)) //if one of the spots is empty, no winner anti diagonally
				{
					break;
				}
				else if (r == SIZE-1) //if you make it to the third rotation of the loop and haven't broken out, you know you have a winner
				{
					return true;
				}
		}
		return false;
	}
	
	//returns string representation of board
	//| X O X |
	//| . O . |
	//| . . . |
	
	public String toString()
	{
		String printableBoard = "";
		for (int r = 0; r < SIZE; r++)
		{
			printableBoard += "| ";
			for (int c = 0; c < SIZE; c++)
			{
				printableBoard += board[r][c] + " ";
			}
			printableBoard += "|\n";
		}
		return printableBoard;
	}
}
