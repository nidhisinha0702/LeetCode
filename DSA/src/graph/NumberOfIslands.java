package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	public static void main(String[] args) {
		//WAP to find the number of island in a grid
		char[][] grid = {{'0', '1', '1', '0'},{'0', '1', '1', '0'},{'0', '0', '1', '0'},{'0', '0', '0', '0'},{'1', '1', '0', '1'}};
		System.out.println(" The number of islands are : "+countIsland(grid));
		

	}
	private static int countIsland(char grid[][]) {
		int n = grid.length;
		int m = grid[0].length;
		int vis[][] = new int[n][m];
		
		int cnt = 0;
		
		for(int row = 0; row<n;row++) {
			for(int col=0;col<m;col++) {
				if(vis[row][col] == 0 && grid[row][col] == '1') {
					//bfs(row, col, vis, grid);
					dfs(row, col, vis, grid, n, m);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	private static void bfs(int row, int col, int[][] vis, char [][]grid) {
		int n = grid.length;
		int m = grid[0].length;
		vis[row][col] = 1;
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(row, col));
		
		while(!q.isEmpty()) {
			int r = q.peek().first;
			int c = q.peek().second;
			q.remove();
			
			for(int delrow = -1; delrow <= 1; delrow++) {
				for(int delcol = -1; delcol <= 1; delcol++) {
					int nrow = r + delrow;
					int ncol = c + delcol;
					
					if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
						vis[nrow][ncol] = 1;
						q.add(new Pair(nrow, ncol));
					}
				}
			}
		}
	}
	static class Pair{
		int first;
		int second;
		Pair(int first, int second){
			this.first = first;
			this.second = second;
		}
	}

	private static void dfs(int row, int col, int vis[][], char grid[][], int n, int m) {
		vis[row][col] = 1;
		
		for(int delrow = -1; delrow <= 1; delrow++) {
			for(int delcol = -1; delcol <= 1; delcol++) {
				int nrow = row + delrow;
				int ncol = col + delcol;
				if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
					vis[nrow][ncol] = 1;
					dfs(nrow, ncol, vis, grid, n, m);
				}
			}
		}
				
	}
}


