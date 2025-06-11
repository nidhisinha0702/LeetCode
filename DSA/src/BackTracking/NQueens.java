package BackTracking;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		boolean board[][] = new boolean[n][n];
		int cnt = queens(board, 0);
		System.out.println(cnt);
	}
	
	private static int queens(boolean board[][], int row) {
		//base case
		//placing queen row wise 
		if(row == board.length) {
			display(board);
			System.out.println();
			return 1;
		}
		
		int count = 0;
		//placing the queen and checking for every row and column
		for(int col = 0;col < board.length;col++) {
			//place the queen only if safe
			if(isSafe(board, row, col)) {
				board[row][col] = true;
				count += queens(board, row + 1);
				board[row][col] = false;//backtrack
			}
		}
		return count;
	}

	private static boolean isSafe(boolean[][] board, int row, int col) {
		//check vertical row
		for(int i=0;i<row;i++) {
			if(board[i][col] == true) {
				return false;
			}
		}
		
		//diagonal left
		int maxLeft = Math.min(row, col);
		for(int i=1;i<=maxLeft;i++) {
			if(board[row-i][col-i])
				return false;
		}
		
		//diagonal left
		int maxRight = Math.min(row, board.length - col - 1);
		for(int i=1;i<=maxRight;i++) {
			if(board[row-i][col+i])
				return false;
		}
		
		return true;
	}

	private static void display(boolean[][] board) {
		//iterate on the 2-d array
		for(boolean[] row:board) {
			for(boolean element : row) {
				if(element) {
					System.out.print("Q ");
				}else {
					System.out.print("X ");
				}
			}System.out.println();
		}
		
	}

}
