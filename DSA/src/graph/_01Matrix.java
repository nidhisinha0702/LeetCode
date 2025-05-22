package graph;

import java.util.LinkedList;
import java.util.Queue;

public class _01Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{0,0,0},{0,1,0},{1,1,1}};
		int ans[][] = updateMatrix(mat);
		for(int a[]:ans) {
			for(int a1:a) {
				System.out.print(a1+" ");
			}System.out.println();
		}

	}
	private static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();

        //iterate over the mat
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }else{
                    vis[i][j] = 0;
                }
            }
        }
        //to move in 4 dir
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};
        //iterate in the queue
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int step = q.peek().third;
            q.remove();
            dist[row][col] = step;

            //iterate in 4 dir
            for(int i=0;i<4;i++){
                int nrow = delrow[i] + row;
                int ncol = delcol[i] + col;

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0){
                    q.add(new Pair(nrow, ncol, step + 1));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        return dist;

    }
    private static class Pair{
        int first;
        int second;
        int third;

        Pair(int _first, int _second, int _third){
            first = _first;
            second = _second;
            third = _third;
        }
    }
}
