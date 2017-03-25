
public class Sudoku2 {
	
	public static int board[][] = { {5, 3, 4, 6, 7, 8, 9, 1, 2}, 
									{6, 7, 2, 1, 9, 5, 3, 4, 8}, 
									{1, 9, 8, 3, 4, 2, 5, 6, 7}, 
									{8, 5, 9, 7, 6, 1, 4, 2, 3}, 
									{4, 2, 6, 8, 5, 3, 7, 9, 1}, 
									{7, 1, 3, 9, 2, 4, 8, 5, 6}, 
									{9, 6, 1, 5, 3, 7, 2, 8, 4}, 
									{2, 8, 7, 4, 1, 9, 6, 3, 5}, 
									{3, 4, 5, 2, 8, 6, 1, 7, 9} };
	
	public static void main(String[] args) {
		
		System.out.println(isValid(board) ? "Valid Solution" : "Invalid Solution");
		
	}
	
	public static boolean isValid(int[][] board) {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (board[i][j] < 1 || board[i][j] > 9 || !isValid(i, j, board))
					return false;
		
		return true;
	}
	
	public static boolean isValid(int i, int j, int[][] board) {
		for (int col = 0; col < 9; col++)
			if (col != j && board[i][j] == board[i][col])
				return false;
		
		for (int row = 0; row < 9; row++)
			if (row != i && board[i][j] == board[row][j])
				return false;
		
		for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
			for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
				if (row != i && col != j && board[i][j] == board[row][col])
					return false;
		
		return true;
	}

}
