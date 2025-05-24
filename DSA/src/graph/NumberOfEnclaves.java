package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
		
		System.out.println("the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves is : "+numEnclaves(grid));

	}
	static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int numEnclaves(int[][] grid) {
        //count the land from where you can not walk off the boundary
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[n][m];

        //mark all the boundary 1's in the vis array as 1 and push it in the q for connected 1s
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i == n-1 || j == 0 || j == m-1){
                    if(grid[i][j] == 1){
                        q.add(new Pair(i,j));
                        vis[i][j] = 1;
                    }
                }
            }
        } 

        //traverse the q nodes in 4 direction
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }

        //now count the 1s
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }
}
