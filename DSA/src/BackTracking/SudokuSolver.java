package BackTracking;

public class SudokuSolver {

	//TC->O(9^n^2)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = new int[][] {
                {9, 5, 7, 0, 1, 3, 0, 8, 4},
                {4, 8, 3, 0, 5, 7, 1, 0, 6},
                {0, 1, 2, 0, 4, 9, 5, 3, 7},
                {1, 7, 0, 3, 0, 4, 9, 0, 2},
                {5, 0, 4, 9, 7, 0, 3, 6, 0},
                {3, 0, 9, 5, 0, 8, 7, 0, 1},
                {8, 4, 5, 7, 9, 0, 6, 1, 3},
                {0, 9, 1, 0, 3, 6, 0, 7, 5},
                {7, 0, 6, 1, 8, 5, 4, 0, 9}
                };
                
                if(solve(board)) {
                	display(board);
                }else {
                	System.out.println("cannot solve");
                }
	}
	
	private static boolean solve(int[][] board) {
		int n = board.length;
		int row = -1;
		int col = -1;
		
		//this is how we are replacing r and c from argument
		boolean emptyLeft = true;
		for(int i=0;i<n;i++) {//row
			for(int j=0;j<n;j++) {//col
				if(board[i][j] == 0) {
					row = i;
					col = j;
					emptyLeft = false;
					break;
				}
			}//after traversing a row
			//if you found some empty element in row, then break;
			//we will fill that box by calling solve and repeat for others
			if(emptyLeft == false)
				break;
		}
		
		if(emptyLeft == true)
			return true; //sudoku solved
		
		
		for(int number = 1; number <= 9 ; number++) {
			if(isSafe(board, row, col, number)) {
				board[row][col] = number;
				if(solve(board)) {
					return true;
				}else {
					//backtrack
					board[row][col] = 0;
				}
			}
		}return false;//sudoku can not be solved
	}
	
	private static void display(int[][] board) {
		for(int row[]:board) {
			for(int num: row) {
				System.out.print(num+" ");
			}System.out.println();
		}
	}

	private static boolean isSafe(int[][] board, int row, int col, int num) {
		//check the row if safe to place the num
		for(int i=0;i<board.length;i++) {
			if(board[row][i] == num)
				return false;
		}
		
		//check the col if safe to place the num
		for(int i=0;i<board.length;i++) {
			if(board[i][col] == num)
				return false;
		}
		
		//check the box if safe to place the num 9 X 9 sqrt is 3
		//set of 3 boxes (row and col)
		int sqrt = (int)(Math.sqrt(board.length));
		int rowStart = row - row % sqrt;
		int colStart = col - col % sqrt;
		
		for(int r = rowStart; r < rowStart + sqrt; r++) {
			for(int c = colStart; c < colStart + sqrt; c++) {
				if(board[r][c] == num)
					return false;
			}
		}
		
		return true;
		
	}

}
