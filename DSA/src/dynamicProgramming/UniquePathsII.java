package dynamicProgramming;

import java.util.Arrays;

public class UniquePathsII {

	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		//int ans = uniquePaths(m,n);
		int ans = sf(m,n);
		System.out.println("The number of possible unique paths that the robot can take to reach the bottom-right corner:"+ans);

	}
	//bottom-up approach TC-(m*n) SC-> O(pathlength->m-1 + n-1)
	private static int uniquePaths(int m,int n) {
		int [][]dp = new int[m][n];
		for(int[] rows:dp)
			Arrays.fill(rows,-1);
		dp[0][0] = 1;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i == 0 && j == 0) dp[i][j]=1;
				else {
					int up = 0;
					int left = 0;
					if(i>0) up = dp[i-1][j];
					if(j>0) left= dp[i][j-1];
					dp[i][j] = up + left;
				}
			}
		}return dp[m-1][n-1];
	}
		
	//space optimization
	private static int sf(int m,int n) {
		int prev[] = new int[n];
		Arrays.fill(prev, 0);
		for(int i=0;i<m;i++) {
			int curr[] = new int[n];
			for(int j=0;j<n;j++) {
				if(i == 0 && j == 0) curr[j]=1;
				else {
					int up = 0;
					int left = 0;
					if(i>0) up = prev[j];
					if(j>0) left = curr[j-1];
					curr[j] = up + left;
				}
			}prev = curr;
		}return prev[n-1];
	}
}
