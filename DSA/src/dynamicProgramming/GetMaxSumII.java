package dynamicProgramming;

import java.util.Arrays;

public class GetMaxSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int matrix[][] = {{1, 2 ,10, 4},
			 {100 ,3 ,2 ,1},
			 {1, 1, 20, 2},
			 {1 ,2 ,2 ,1}};
		 //int ans = getMaxPathSum(matrix);
		 int ans = sc(matrix);
		 System.out.println("The max path sum is::"+ans);
	}
	//TC -> O(m) + O(n*m) SC->O(n*m)
	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
		int n = matrix.length;
		int m = matrix[0].length;
		
		int dp[][] = new int[n][m];
		for(int[] rows:dp) Arrays.fill(rows,0);
		//first row base condition
		for(int j=0;j<m;j++) {
			dp[0][j]=matrix[0][j];
		}
		for(int i =1;i<n;i++){
			for(int j=0;j<m;j++){
				int up = matrix[i][j] + dp[i-1][j];
				int ld = matrix[i][j];
				if(j-1 >= 0) ld += dp[i-1][j-1];
				else	ld += (int)-1e9;
				int rd = matrix[i][j];
				if(j+1<m) rd += dp[i-1][j+1];
				else	rd += (int)-1e9;
			  dp[i][j]=Math.max(up,Math.max(ld,rd));
			}
		}
		int maxi = Integer.MIN_VALUE;
		for(int j=0;j<m;j++){
			maxi = Math.max(maxi,dp[n-1][j]);
		}return maxi;
	}
	//TC -> O(m) + O(n*m) SC->O(n)+O(n)
	private static int sc(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		
		int prev[] = new int[m];
		Arrays.fill(prev,0);
		
		//first row base condition
		for(int j=0;j<m;j++) {
			prev[j]=matrix[0][j];
		}
		for(int i=1;i<n;i++){
			int cur[] = new int[m];
			Arrays.fill(cur, 0);
			for(int j=0;j<m;j++){
				int up = matrix[i][j] + prev[j];
				int ld = matrix[i][j];
				if(j-1>=0) ld += prev[j-1];
				else	ld += (int)Math.pow(-10,9);
				int rd = matrix[i][j];
				if(j+1<m) rd += prev[j+1];
				else	rd += (int)Math.pow(-10,9);
				cur[j]=Math.max(up,Math.max(ld,rd));
			}prev=cur;
		}
		int maxi = Integer.MIN_VALUE;
		for(int j=0;j<m;j++){
			maxi = Math.max(maxi,prev[j]);
		}return maxi;
	}
}
