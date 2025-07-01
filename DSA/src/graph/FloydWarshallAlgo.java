package graph;

import java.util.Arrays;

public class FloydWarshallAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dist[][] = {{0, 4, 108, 5, 108}, {108, 0, 1, 108, 6}, 
				{2, 108, 0, 3, 108}, {108, 108, 1, 0, 2}, {1, 108, 108, 4, 0}};
		floydWarshall(dist);
		System.out.println(Arrays.deepToString(dist));

	}
	//TC->O(n^3),SC->O(N^2)
	public static void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        
        //algorithm to update the dist matrix
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(dist[i][k] != (int)1e8 && dist[k][j] != (int)1e8)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            
            }
        }

    }
}
