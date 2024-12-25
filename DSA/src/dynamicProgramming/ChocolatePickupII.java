package dynamicProgramming;

import java.util.Arrays;

public class ChocolatePickupII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]grid = {{2,3,1,2},{3,4,2,2},{5,6,3,5}};
		int row = 3;
		int col = 4;
		System.out.println("The maximum chocolates ninja can collect with the help of his friends ::"+so(row, col, grid));
	}
	//Tc-> O(n*m*m)*9 Sc-> O(n*m*m)
	public static int maximumChocolates(int n, int m, int[][] grid) {
		// Write your code here.
		int dp[][][] = new int[n][m][m];
		for(int[][] cols:dp){
			for(int[] rows:cols){
				Arrays.fill(rows,0);
			}
		}

		//base case
		for(int j1=0;j1<m;j1++){
			for(int j2=0;j2<m;j2++){
				if(j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
				else dp[n-1][j1][j2] = grid[n-1][j1]+grid[n-1][j2];
			}
		}

		
		for(int i=n-2;i>=0;i--){
			for(int j1=0;j1<m;j1++){
				for(int j2=0;j2<m;j2++){

					int maxi = (int)-1e8;
					for(int dj1 = -1;dj1<=1;dj1++){
						for(int dj2=-1;dj2<=1;dj2++){

							int value = 0;
							if(j1==j2) value = grid[i][j1];
							else value = grid[i][j1] + grid[i][j2];
							if(j1+dj1>=0 && j2+dj2>=0 && j1+dj1<m && j2+dj2<m)
								value += dp[i+1][j1+dj1][j2+dj2];
							else 
								value += (int)-1e8;
							maxi = Math.max(maxi,value);
							}
						}dp[i][j1][j2] = maxi;
					}
				}
			}return dp[0][0][m-1];
	}   
	
	//space optimization SC->O(m*m)
	private static int so(int n, int m, int[][] grid) {
		int front[][] = new int[m][m];
		for(int[] rows:front){
			Arrays.fill(rows,0);
		}

	//base case
	for(int j1=0;j1<m;j1++){
		for(int j2=0;j2<m;j2++){
			if(j1 == j2) front[j1][j2] = grid[n-1][j1];
			else front[j1][j2] = grid[n-1][j1]+grid[n-1][j2];
		}
	}

	
	for(int i=n-2;i>=0;i--){
		int cur[][] = new int[m][m];
		for(int j1=0;j1<m;j1++){
			for(int j2=0;j2<m;j2++){
				
				int maxi = (int)-1e8;
				for(int dj1 = -1;dj1<=1;dj1++){
					for(int dj2=-1;dj2<=1;dj2++){

						int value = 0;
						if(j1==j2) value = grid[i][j1];
						else value = grid[i][j1] + grid[i][j2];
						if(j1+dj1>=0 && j2+dj2>=0 && j1+dj1<m && j2+dj2<m)
							value += front[j1+dj1][j2+dj2];
						else 
							value += (int)-1e8;
						maxi = Math.max(maxi,value);
						}
					}cur[j1][j2] = maxi;
				}
			}front = cur;
		}return front[0][m-1];
	}                                                  

}
