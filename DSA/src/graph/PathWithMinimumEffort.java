package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int heights[][] = {{1,2,2},{3,8,2},{5,3,5}};
		System.out.println("minimum path effort is : "+minimumEffortPath(heights));

	}
	//E log V
    //n x m x 4 x log (n x m)
    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.diff - b.diff);
        pq.add(new Pair(0, 0, 0));
        int dist[][] = new int[n][m];
        for(int row[]:dist)
        Arrays.fill(row, (int)1e9);
        dist[0][0] = 0;

        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        while(!pq.isEmpty()){
            int difference = pq.peek().diff;
            int r = pq.peek().row;
            int c = pq.peek().col;
            pq.remove();
            //if you reach the dest
            if(r == n-1 && c == m-1) return difference;

            for(int i=0;i<4;i++){
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    //always take max effort of the current effort(current - new) and difference
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[nrow][ncol]), difference);
                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Pair(newEffort, nrow, ncol));
                    }
                }
            }
        }return 0;
    }

    static class Pair{
        int diff;
        int row;
        int col;
        Pair(int diff, int row, int col){
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }
}
