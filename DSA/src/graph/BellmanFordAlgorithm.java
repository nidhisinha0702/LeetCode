package graph;

import java.util.Arrays;

public class BellmanFordAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5, edges[][] = {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}}, src = 0;
		int ans[] = bellmanFord(V, edges, src);
		System.out.println("The distance to reach all the nodes are :"+Arrays.toString(ans));

	}
	 public static int[] bellmanFord(int V, int[][] edges, int src) {
	        // code here
	        int dist[] = new int[V];
	        Arrays.fill(dist, (int)1e8);
	        dist[src] = 0;
	        
	        for(int i=0;i<V-1;i++){
	            for(int edge[] : edges){
	                int u = edge[0];
	                int v = edge[1];
	                int w = edge[2];
	                if(dist[u] != 1e8 && dist[u] + w < dist[v]){
	                    dist[v] = dist[u] + w;
	                }
	            }
	        }
	        
	        //Nth relaxation to check negative cycle
	        for(int edge[]:edges){
	            int u = edge[0];
	            int v = edge[1];
	            int w = edge[2];
	            if(dist[u] != 1e8 && dist[u] + w < dist[v]){
	                return new int[]{-1};
	            }
	        }
	        
	        return dist;
	    }
}
