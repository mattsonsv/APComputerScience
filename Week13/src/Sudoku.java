
public class Sudoku {
	
	public static int board[][] = { {5, 3, 4, 6, 7, 8, 9, 1, 2}, 
							 		 {6, 7, 2, 1, 9, 5, 3, 4, 8}, 
							 		 {1, 9, 8, 3, 4, 2, 5, 6, 7}, 
							 		 {8, 5, 9, 7, 6, 1, 4, 2, 3}, 
							 		 {4, 2, 6, 8, 5, 3, 7, 9, 1}, 
							 		 {7, 1, 3, 9, 2, 4, 8, 5, 6}, 
							 		 {9, 6, 1, 5, 3, 7, 2, 8, 4}, 
							 		 {2, 8, 7, 4, 1, 9, 6, 3, 5}, 
							 		 {3, 4, 5, 2, 8, 6, 1, 7, 9} };
	
	public static int board2[][] = { {7, 2, 4, 9, 5, 6, 3, 1, 8}, 
	 								 {1, 5, 6, 3, 4, 8, 7, 2, 9}, 
	 								 {3, 8, 9, 2, 1, 7, 5, 4, 6}, 
	 								 {4, 9, 1, 8, 7, 5, 6, 3, 2}, 
	 								 {6, 7, 2, 4, 9, 3, 1, 8, 5}, 
	 								 {5, 3, 8, 1, 6, 2, 4, 9, 7}, 
	 								 {8, 4, 5, 6, 3, 9, 2, 7, 1}, 
	 								 {9, 1, 7, 5, 2, 4, 8, 6, 3}, 
	 								 {2, 6, 3, 7, 8, 1, 9, 5, 4} };
	
	public static void main(String[] args) {
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (j == board[i].length - 1)
					System.out.println(board[i][j]);
				else
					System.out.print(board[i][j] + " ");
			}
		}
		checkSolution(board2);
		
	}
	
	public static void checkSolution(int board[][]) {
		if (checkRows(board) && checkColumns(board) && checkBoxes(board))
			System.out.println("Valid Solution");
		else
			System.out.println("Invalid Solution");
	}
	
	public static boolean checkRows(int board[][]) {
		for (int i = 0; i < 9; i++) {
			boolean check[] = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (check[board[i][j] - 1])
					return false;
				check[board[i][j] - 1] = true;
			}
		}
		
		return true;
	}
	
	public static boolean checkColumns(int board[][]) {
		for (int i = 0; i < 9; i++) {
			boolean check[] = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (check[board[j][i] - 1])
					return false;
				check[board[j][i] - 1] = true;
			}
		}
		
		return true;
	}
	
	public static boolean checkBoxes(int board[][]) {
		for (int spot = 0; spot < 9; spot++) {
			boolean check[] = new boolean[9];
			for (int i = spot / 3 * 3; i < spot / 3 * 3 + 3; i++) {
				for (int j = spot % 3 * 3; j < spot % 3 * 3 + 3; j++) {
					if (check[board[i][j] - 1])
						return false;
					check[board[i][j] - 1] = true;
				}
			}
		}
		
		return true;
	}

}
