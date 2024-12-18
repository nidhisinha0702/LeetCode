package dynamicProgramming;
//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
//
//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

import java.util.Arrays;

public class UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3;
		int n = 7;
		int ans = uniquePaths(m,n);
		System.out.println("The number of possible unique paths that the robot can take to reach the bottom-right corner:"+ans);

	}
	//top-down approach TC-(2^m*n) SC-> O(pathlength->m-1 +n-1)
	private static int uniquePaths(int m,int n) {
		int [][]dp = new int[m][n];
		for(int[] rows:dp)
			Arrays.fill(rows,-1);
		return f(m-1,n-1,dp);
	}
	
	private static int f(int i,int j, int[][] dp) {
		if(i == 0 && j == 0) return 1;
		if(i<0 || j<0) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		int up = f(i-1,j,dp);
		int left = f(i,j-1,dp);
		return dp[i][j] = up + left;
	}
	

}
