package dynamicProgramming;

import java.util.Arrays;

public class ChocolatePickup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]grid = {{2,3,1,2},{3,4,2,2},{5,6,3,5}};
		int row = 3;
		int col = 4;
		System.out.println("The maximum chocolates ninja can collect with the help of his friends ::"+maximumChocolates(row, col, grid));

	}
	private static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int dp[][][] = new int[r][c][c];
		for(int[][] cols:dp){
			for(int[] rows:cols){
				Arrays.fill(rows,-1);
			}
		}
		return f(0,0,c-1,r,c,grid,dp);
	}
//TC -> O(n*m*m)*9 Sc-> O(n)+O(n*m*m)
	private static int f(int i,int j1,int j2,int r,int c,int[][] grid, int dp[][][]){
		if(j1<0 || j2<0 || j1>=c || j2>=c ) return (int)-1e8;

		if(i == r-1){
			if(j1 == j2) return grid[i][j1];//alice and bob at same position
			else return grid[i][j1] + grid[i][j2];//different position
		}
		if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
		//explore all the paths of alice and bob simultaneously
		int maxi = (int)-1e8;
		for(int dj1 = -1;dj1<=1;dj1++){
			for(int dj2=-1;dj2<=1;dj2++){
				int value = 0;
				if(j1==j2) value = grid[i][j1];
				else value = grid[i][j1] + grid[i][j2];
				value += f(i+1,j1+dj1,j2+dj2,r,c,grid,dp);
				maxi = Math.max(maxi,value);

			}
		}return dp[i][j1][j2]=maxi;
	}
}
