package BasicRecursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> ans = solveNQueens(4);
		System.out.println(ans);

	}
	 private static List<List<String>> solveNQueens(int n) {
	        List<List<String>> ans = new ArrayList<>();
	        char[][] board = new char[n][n];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                board[i][j] = '.';
	            }
	        }
	        solve(0,board,ans);
	        return ans;
	    }

	    private static void solve(int col,char[][] board,List<List<String>> res ){
	        //base case
	        if(col == board.length){
	            res.add(construct(board));
	            return;
	        }

	        //we can put queens from row 0 to n-1
	        for(int row=0;row<board.length;row++){
	            if(validate(board,row,col)){
	                board[row][col]='Q';
	                solve(col+1,board,res);
	                board[row][col]='.';
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

	    private static boolean validate(char[][] board,int row, int col){
	        int duprow = row;
	        int dupcol = col;

	        //left upward diagonal check
	        while(row>=0 && col>=0){
	            if(board[row][col] == 'Q') return false;
	            row--;
	            col--;
	        }

	        row = duprow;
	        col = dupcol;

	        //left row check
	        while(col>=0){
	            if(board[row][col] == 'Q') return false;
	            col--;
	        }

	        //left downward diagonal check
	        row=duprow;
	        col=dupcol;
	        while(row < board.length && col >=0){
	            if(board[row][col] == 'Q') return false;
	            row++;
	            col--;
	        }
	        return true;
	    }
}
