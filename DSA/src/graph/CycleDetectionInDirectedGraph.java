package graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInDirectedGraph {
	
	private static boolean isCyclic(int V, int[][] edges) {
        // code here
        int vis[] = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        //create adjacency list from edges
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        //for all connected components
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                if(dfsCheck(i, adj, vis)) return true;
            }
        }
        return false;
    }
    
    private static boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis){
    	//we are marking visited with two to indicate vis + pathvis
        vis[node] = 2;
        for(int adjNode : adj.get(node)){
            //unvisted
            if(vis[adjNode] == 0){
                if(dfsCheck(adjNode, adj, vis)) return true;
            }
            //if visited and in the same path
            if(vis[adjNode] == 2){
                return true;
            }
        }
        //while returning back we are again making vis to 1
        vis[node] = 1;
        return false;
    }
    //TC->O(V+E) SC-> O(V)
	public static void main(String[] args) {
		//WAP to detect a cycle in a directed graph
		int V = 4, edges[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}};
		System.out.println(isCyclic(V, edges));
	}

}
