package BasicRecursion;

public class SudokuSolver {

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
		 solveSudoku(board);
	}
	private static void solveSudoku(char[][] board) {
        //call sudoku is solved print board
        solve(board);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j] +" ");
            }System.out.println();
        }
    }
    private static boolean solve(char[][] board){
        //iterate over the board
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    //iterate from 1 to 9 to fill on the dot locations
                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;
                            //calling the function recursively to solve other dots
                            if(solve(board))    return true;
                            //backtracking:could not solve with current input so removing it back to .
                            else    board[i][j] = '.';
                        }
                    }return false;//if it is not possible the recursion will return false
                }
            }
        }return true;//if all the places are filled base case return true
    }

    private static boolean isValid(char[][] board,int row,int col,char c){
        //iterate from 0 to 8
        for(int i=0;i<9;i++){
            //check in the row where column changes
            if(board[row][i] == c)  return false;
            //check in the col where row will change
            if(board[i][col] == c)  return false;
            //check in the 3*3 matrix in which you are present curently
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == c)    return false;
        }return true;
    }

}
