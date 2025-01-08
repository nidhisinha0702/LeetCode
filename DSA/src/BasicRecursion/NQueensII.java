package BasicRecursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueensII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> ans = solveNQueens(4);
		System.out.println(ans);
	}
	  public static List<List<String>> solveNQueens(int n) {
	        List<List<String>> ans = new ArrayList<>();
	        char[][] board = new char[n][n];//creating an n*n matrix of char type to store Queens
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                board[i][j] = '.';//initially put . to each position
	            }
	        }
	        int leftRow[] = new int[n]; // this will give the hasharray for leftward row
	        int upperDiagonal[]=new int[2*n-1];//this will give the hasharray for upward diagonal
	        int lowerDiagonal[]=new int[2*n-1];//this will give the hasharray for downward diagonal
	        solve(0,board,ans,leftRow,upperDiagonal,lowerDiagonal);
	        return ans;
	    }

	    private static void solve(int col,char[][] board,List<List<String>> res ,int leftRow[],  int upperDiagonal[],int lowerDiagonal[]){
	        //base case
	        if(col == board.length){
	            res.add(construct(board));
	            return;
	        }

	        //we can put queens from row 0 to n-1
	        for(int row=0;row<board.length;row++){
	        	//check if queen is present in left row, upperdiagonal and lowerdiagonal
	            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[board.length-1+ col-row] == 0){
	                board[row][col]='Q';
	                leftRow[row]=1;
	                lowerDiagonal[row+col]=1;
	                upperDiagonal[board.length-1+col-row]=1;
	                solve(col+1,board,res,leftRow,upperDiagonal,lowerDiagonal);
	                board[row][col]='.';
	                leftRow[row]=0;
	                lowerDiagonal[row+col]=0;
	                upperDiagonal[board.length-1+col-row]=0;
	            }
	        }
	    }

	    private static List<String> construct(char[][] board){
	        List<String> res=new LinkedList<>();
	        for(int i=0;i<board.length;i++){
	            String s = new String(board[i]);
	            res.add(s);
	        }return res;
	    }

}
