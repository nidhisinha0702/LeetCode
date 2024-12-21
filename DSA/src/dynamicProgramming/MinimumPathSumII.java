package dynamicProgramming;

import java.util.Arrays;

public class MinimumPathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][]= {{1,3,1},{1,5,1},{4,2,1}};
		//int ans = minPathSum(grid);
		int ans = fs(grid);
		System.out.println("The minimum path sum to reach from 0,0 to n,m is:"+ans);
	}
	 public static int minPathSum(int[][] grid) {
	        int n = grid.length;
	        int m = grid[0].length;
	        int dp[][] = new int[n][m];
	        for(int row[]:dp)
	        Arrays.fill(row,0);
	        return f(n,m,grid,dp);
	    }
	 //bottom-up tabulation
	    private static int f(int n, int m, int [][]arr,int [][]dp){
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(i == 0 && j == 0) dp[i][j]=arr[i][j];
	                else{
	                    int up = arr[i][j];
	                    if(i>0) up += dp[i-1][j];
	                    else    up += (int)1e9;
	                    int left = arr[i][j];
	                    if(j>0) left += dp[i][j-1];
	                    else    left += (int)1e9;
	                    dp[i][j] = Math.min(up,left);
	                }
	            }
	        }return dp[n-1][m-1];
	       
	    }
	    //space optimization
	    private static int fs(int [][]grid) {
	    	int n = grid.length;
	    	int m = grid[0].length;
	    	int prev[] = new int[m];
	    	Arrays.fill(prev, 0);
	    	for(int i=0;i<n;i++) {
	    		int curr[] = new int[m];
	    		for(int j=0;j<m;j++) {
	    			 if(i == 0 && j == 0) curr[j]=grid[i][j];
	    			 else {
	    				 int up = grid[i][j];
	    				 if(i>0) up += prev[j];
	    				 else	up+= (int)1e9;
	    				 int left = grid[i][j];
	    				 if(j>0) left += curr[j-1];
	    				 else	left += (int)1e9;
	    				 curr[j]=Math.min(up, left);
	    			 }
	    		}prev = curr;
	    	}return prev[m-1];
	    }
}
