package dynamicProgramming;

import java.util.Arrays;

public class GetMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int matrix[][] = {{10, 10, 2 ,-13, 20, 4},
				 {1 ,-9 ,-81 ,30 ,2 ,5},
				 {0, 10, 4, -79, 2, -10},
				 {1 ,-5 ,2 ,20 ,-11 ,4}};
		 int ans = getMaxPathSum(matrix);
		 System.out.println("The max path sum is::"+ans);

	}
	//TC->O(n*m) Sc->O(n)+O(n*m)
	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
		int n = matrix.length;
		int m = matrix[0].length;
		int maxi = Integer.MIN_VALUE;
		int dp[][] = new int[n][m];
		for(int[] rows:dp) Arrays.fill(rows,-1);
		for(int j=0;j<m;j++){
			int ans = f(n-1,j,matrix,dp);
			maxi = Math.max(maxi,ans);
		}return maxi;

	}
	private static int f(int i,int j,int[][] mat,int[][] dp){
		if(j<0 || j>=mat[0].length) return (int)-1e9;
		if(i == 0) return dp[i][j]=mat[i][j];

		int up = mat[i][j] + f(i-1,j,mat,dp);
		int ld = mat[i][j] + f(i-1,j-1,mat,dp);
		int rd = mat[i][j] + f(i-1,j+1,mat,dp);
		return dp[i][j]=Math.max(up,Math.max(ld,rd));

	}
}