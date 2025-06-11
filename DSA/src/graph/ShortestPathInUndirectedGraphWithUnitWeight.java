package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraphWithUnitWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int n = 9;
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		
		int edges[][] = {{1, 3}, {0, 2}, {1, 6}, {0, 4}, {3, 5}, {4, 6}, {2, 5, 7, 8}, {6, 8}, {7, 6}};
		
		for(int i=0;i<edges.length;i++) {
			for(int j=0;j<edges[i].length;j++) {
				int u = i;
				int v = edges[i][j];
				adj.get(u).add(v);
			}
		}

		int src = 0;  
		int ans[] = shortestPath(adj, src);
		System.out.println(Arrays.toString(ans));
	}

	 private static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
	        // code here
	        int N = adj.size();
	        int dist[] = new int[N];
	        Arrays.fill(dist, -1);
	        dist[src] = 0;
	        Queue<Integer> q = new LinkedList<>();
	        q.add(src);
	        while(!q.isEmpty()){
	            int node = q.poll();
	            for(int it: adj.get(node)){
	                if(dist[node] + 1 < dist[it] || dist[it] == -1){
	                    dist[it] = 1 + dist[node];
	                    q.add(it);
	                }
	            }
	        }
	        return dist;
	    }
}
