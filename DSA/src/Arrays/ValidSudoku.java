package Arrays;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
                };
		
		System.out.println("The sudoku is valid : "+isValidOpti(board));
	}
	//Brute Force
	private static boolean isValid(char [][]grid) {
		//validate rows
		for(int row=0;row<9;row++) {
			HashSet<Character> set = new HashSet<>();
			for(int col=0;col<9;col++) {
				if(grid[row][col]=='.') continue;
				if(set.contains(grid[row][col])) return false;
				set.add(grid[row][col]);
			}
		}
		//validate col
		for(int col=0;col<9;col++) {
			HashSet<Character> set = new HashSet<>();
			for(int row=0;row<9;row++) {
				if(grid[row][col]=='.') continue;
				if(set.contains(grid[row][col])) return false;
				set.add(grid[row][col]);
			}
		}
		
		//validate 3*3 boxes
		for(int sr=0;sr<9;sr+=3) {
			int er = sr+2;
			for(int sc=0;sc<9;sc+=3) {
				int ec=sc+2;
				HashSet<Character> set = new HashSet<>();
				for(int i=sr;i<=er;i++) {
					for(int j=sc;j<=ec;j++) {
						if(grid[i][j]=='.') continue;
						if(set.contains(grid[i][j])) return false;
						set.add(grid[i][j]);
					}
				}
			}
		}return true;
	}
	
	//optimized
	private static boolean isValidOpti(char [][]grid) {
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(grid[i][j]=='.') continue;
				String row = grid[i][j] + "_ROW_" + i;
				String col = grid[i][j] + "_COL_" + j;
				String box = grid[i][j] + "_BOX_" + (i/3) + "_" + (j/3);
				
				if(set.contains(row) || set.contains(col) || set.contains(box))
					return false;
				set.add(row);
				set.add(col);
				set.add(box);
			}
		}return true;
	}
}
