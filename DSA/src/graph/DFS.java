package graph;

import java.util.ArrayList;

public class DFS {
	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0;i<5;i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(2).add(4);
		adj.get(4).add(2);
		
		DFS dfs = new DFS();
		ArrayList<Integer> ans = dfs.dfsOfGraph(adj);
		System.out.println("The dfs order is : "+ans);
	}
	 public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
	        // Code here
	        //size of the adj list
	        int V = adj.size();
	        boolean vis[] = new boolean[V+1];
	        vis[0] = true;
	        ArrayList<Integer> ls = new ArrayList<>();
	        dfs(0,vis,adj,ls);
	        return ls;
	    }
	    
	    private static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
	        
	        //marking current node as visited
	        vis[node] = true;
	        ls.add(node);
	        
	        //getting neighbour nodes
	        for(Integer it: adj.get(node)){
	            if(vis[it] == false){
	                dfs(it,vis,adj,ls);
	            }
	        }
	    }
}
