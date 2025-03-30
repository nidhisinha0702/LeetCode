package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RootenOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println("The maximum time to rot all the oranges is : "+orangesRotting(grid));

	}
	 private static int orangesRotting(int [][]grid) {
		 int n = grid.length;
		 int m = grid[0].length;
		 
		 Queue<Pair> q = new LinkedList<Pair>();
		 
		 int[][] vis = new int[n][m];
		 int cntFresh = 0;
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<m;j++) {
				 if(grid[i][j] == 2) {
					 q.add(new Pair(i,j,0));//add all the previously rotten oranges in the queue at time 0
					 vis[i][j] = 2; //mark them in vis as 2
				 }else {
					 vis[i][j] = 0;
				 }
				 if(grid[i][j] == 1) cntFresh++;//keep a cnt of fresh oranges
			 }
		 }
		 
		 int tm = 0;//maintain a maxi time to comapare the maximum
		 int delrow[] = {-1,0,+1,0};//adjacent oranges rotting row-wise
		 int delcol[] = {0,+1,0,-1};//adjacent oranges rotting col-wise
		 int cnt = 0;//cnt to track down if all fresh oranges are rotten
		 while(!q.isEmpty()) {
			 //first get the rotten oranges one-by-one from top
			 int r = q.peek().row;
			 int c = q.peek().col;
			 int t = q.peek().tm;
			 tm = Math.max(tm, t);//calculate max time
			 q.remove();//remove it from queue
			 for(int i=0;i<4;i++) {//rotten all 4 dir oranges using delrow and delcol
				 int nrow = r + delrow[i];
				 int ncol = c + delcol[i];
				 //condition for rotting adj oranges only fresh and new one
				 if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol] == 1) {
					 q.add(new Pair(nrow,ncol,t+1));//add new rotten ones in the q
					 vis[nrow][ncol] = 2;//marke them rotten
					 cnt++;//increase cnt
				 }
			 }
		 }
		 if(cnt != cntFresh) return -1; //if all the fresh are not rotten return -1;
		 return tm;
		 
	 }
	 
	static class Pair{
		 int row;
		 int col;
		 int tm;
		 Pair(int _row, int _col, int _tm){
			 this.row = _row;
			 this.col = _col;
			 this.tm = _tm;
		 }
	 }
}
