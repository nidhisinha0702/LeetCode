package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathInWeightedUndirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5, m= 6, edges[][] = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
		List<Integer> path = shortestPath(n, m, edges);
		System.out.println(path);

	}
	 private static List<Integer> shortestPath(int n, int m, int edges[][]) {
	        //dijkstra algorithm
	        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	        for(int i=0;i<=n;i++){
	            adj.add(new ArrayList<>());
	        }
	        
	        //build the graph
	        for(int edge[]:edges){
	            int u = edge[0];
	            int v = edge[1];
	            int w = edge[2];
	            adj.get(u).add(new Pair(v,w));
	            adj.get(v).add(new Pair(u,w));
	        }
	        
	        //min-heap
	        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> Integer.compare(a.second,b.second));
	        pq.add(new Pair(1,0));
	        int dist[] = new int[n+1];
	        Arrays.fill(dist, (int)1e9);
	        dist[1] = 0;
	        int parent[] = new int[n+1];
	        for(int i=0;i<=n;i++){
	            parent[i] = i;
	        }
	        
	        while(!pq.isEmpty()){
	            int node = pq.peek().first;
	            int dis = pq.peek().second;
	            pq.remove();
	            
	            for(int i=0;i<adj.get(node).size();i++){
	                int childNode = adj.get(node).get(i).first;
	                int wt = adj.get(node).get(i).second;
	                if(dist[childNode] > wt + dis){
	                    dist[childNode] = wt + dis;
	                    pq.add(new Pair(childNode, wt + dis));
	                    parent[childNode] = node;
	                }
	            }
	        }
	        
	        ArrayList<Integer> path = new ArrayList<>();
	        if(dist[n] == 1e9){
	            path.add(-1);
	            return path;
	        }
	        //O(n)
	        int node = n;
	        while(parent[node] != node){
	            path.add(node);
	            node = parent[node];
	        }
	        path.add(1);
	        path.add(dist[n]);
	        Collections.reverse(path);
	        return path;
	    }
	    
	    static class Pair{
	        int first;
	        int second;
	        Pair(int first, int second){
	            this.first = first;
	            this.second = second;
	        }
	    }
}
