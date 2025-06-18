package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{0,0,0},{1,1,0},{1,1,0}};
		System.out.println("path length is : "+shortestPathBinaryMatrix(grid));
	}
	private static int shortestPathBinaryMatrix(int[][] grid) {
	       
	        int n = grid.length;
	        //edge case
	        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
	        if(n == 1 && grid[0][0] == 0) return 1;
	        //queue as distance is constant
	        Queue<Pair> q = new LinkedList<>();
	        int dist[][] = new int[n][n];
	        for(int row[]:dist)
	        Arrays.fill(row, (int)1e9);
	        //initialize soruce with 1
	        dist[0][0] = 1;
	        q.add(new Pair(1, 0, 0));

	        //moves in 8 directions
	        int delrow[] = {-1,-1, -1, 0, 1, 1, 1, 0};
	        int delcol[] = {-1, 0, 1, 1, 1, 0, -1, -1};

	        while(!q.isEmpty()){
	            int d = q.peek().distance;
	            int r = q.peek().row;
	            int c = q.peek().col;
	            q.remove();

	            for(int i=0;i<8;i++){
	                int nrow = r + delrow[i];
	                int ncol = c + delcol[i];

	                if(isSafe(nrow, ncol, n, d, grid, dist)){
	                    if(nrow == n-1 && ncol == n-1) return 1 + d;
	                    dist[nrow][ncol] = 1 + d;
	                    q.add(new Pair(1 + d, nrow, ncol));
	                }
	            }
	        }return -1;
	    }

	    private static boolean isSafe(int nrow, int ncol, int n, int d, int[][] grid, int[][] dist){
	        return (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0 && 1 + d < dist[nrow][ncol]);
	    }

	    static class Pair{
	        int distance;
	        int row;
	        int col;
	        Pair(int distance, int row, int col){
	            this.distance = distance;
	            this.row = row;
	            this.col = col;
	        }
	    }
}
