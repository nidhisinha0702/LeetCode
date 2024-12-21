package dynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][]= {{1,3,1},{1,5,1},{4,2,1}};
		int ans = minPathSum(grid);
		System.out.println("The minimum path sum to reach from 0,0 to n,m is:"+ans);

	}
	public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int[] rows:dp)
        	Arrays.fill(rows,-1);
        return f(n-1,m-1,grid,dp);
    }
	//top-down with memoization
    private static int f(int i, int j, int [][]arr,int dp[][]){
        if(i == 0 && j == 0) return dp[i][j]=arr[i][j];
        if(i<0 || j<0) return (int)1e9;
        if(dp[i][j] != -1) return dp[i][j];
        int up = arr[i][j] + f(i-1,j,arr,dp);
        int left = arr[i][j] + f(i,j-1,arr,dp);
        return dp[i][j]=Math.min(up,left);
    }

}
