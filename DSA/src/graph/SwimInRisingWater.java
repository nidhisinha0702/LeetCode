package graph;

import java.util.PriorityQueue;

public class SwimInRisingWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16}
		,{11,17,18,19,20},{10,9,8,7,6}};
		System.out.println("The least time to reach bottom right sqaure is " +swimInWater(grid) );

	}
	 public static int swimInWater(int[][] grid) {
	        int n = grid.length;
	        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
	        pq.add(new Tuple(grid[0][0], 0, 0));
	        int vis[][] = new int[n][n];
	        vis[0][0] = 1;
	        int time = 0;
	        int dr[] = {-1,0,1,0};
	        int dc[] = {0,1,0,-1};
	        while(!pq.isEmpty()){
	            Tuple tup = pq.poll();
	            int curVal = tup.val;
	            int curRow = tup.row;
	            int curCol = tup.col;
	            //the max time till now will be the ans
	            time = Math.max(time, curVal);

	            if(curRow == n-1 && curCol == n-1) break;

	            for(int ind=0;ind<4;ind++){
	                int newr = curRow + dr[ind];
	                int newc = curCol + dc[ind];
	                if(isValid(newr, newc, n) && vis[newr][newc] == 0){
	                    vis[newr][newc] = 1;
	                    pq.add(new Tuple(grid[newr][newc], newr, newc));
	                }
	            }
	            
	        }return time;

	    }
	    private static boolean isValid(int newr, int newc, int n){
	        return (newr >= 0 && newr < n && newc >= 0 && newc < n);
	    }
	    static class Tuple{
	        int val, row, col;
	        Tuple(int val, int row, int col){
	            this.val = val;
	            this.row = row;
	            this.col = col;
	        }
	    }
}
