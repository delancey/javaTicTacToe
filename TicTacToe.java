public class TicTacToe
{
	// Instance Variables
	private char[][] board;
	private int turns;

	// Constructors
	public TicTacToe() //layout for accessing board
	{
		board = new char[3][3];
		turns = 0;

		for ( int r=0; r<3; r++ )
			for ( int c=0; c<3; c++ )
				board[r][c] = ' ';
	}

	// Accessor Methods

	public boolean isWinner( char p ) //define a game winner
	{
		if (p == board[0][0] && p == board[0][1] && p == board[0][2] ||
            p == board[1][0] && p == board[1][1] && p == board[1][2] ||
			p == board[2][0] && p == board[2][1] && p == board[2][2] ||
			//horizontal win
            p == board[0][0] && p == board[1][0] && p == board[2][0] ||           
            p == board[0][1] && p == board[1][1] && p == board[2][1] ||           
			p == board[0][2] && p == board[1][2] && p == board[2][2] || 
			//vertical wins           
            p == board[0][0] && p == board[1][1] && p == board[2][2] ||           
			p == board[0][2] && p == board[1][1] && p == board[2][0])
			//diagonal wins 
			{
				return true;
			} else {
				return false;
			}		
	}
		

		//if 3x's or 3 o's in a row game is won
		//case statement for all options
		//refactor with row and column variables to cut down number of lines
	

	public boolean isFull() //define if board is full
	{
		if (turns == 9){
			return true;       
		}
		return false;
		//if turns = 9 the board is full
	}

	public boolean isTie() //define if game is a tie
	{
		if (turns == 9 && !isWinner('X') && !isWinner('O')){
			return true;
		};
		return false;	
		//turns == 9 and winner is not X  && winner is not O
	}

	public boolean isValid( int r, int c ) //define valid moves
	{
		if ( 0 <= r && r <= 2 && 0 <= c && c <= 2 )
			return true;
		else
			return false;
	}

	public int numTurns() 
	{
		return turns;
		//if valid move made increase turn number
	}

	//count number of turns that have been played
	//used in isFull()

	public char playerAt( int r, int c ) //defines where player moved
	{
		if ( isValid(r,c) )
			return board[r][c];
		else
			return '@';
	}

	public void displayBoard() //displays board
	{
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("    --+-+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("    --+-+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("     0 1 2 ");
	}

	// Modifiers
	public void playMove( char p, int r, int c )
	{
		this.board[r][c] = p;
		this.turns++;

		//use board locations to place piece (on this.board)
		//increase turns when the move is made
	}
	//determine player move

	public int turns(){
		return this.turns;
	}
}