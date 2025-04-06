package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class detectCycleDFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 2;
		int edges[][] = {{1},{0,1}};
		System.out.println("Is cycle present is : "+isCycle(V,edges));

	}
	 private static boolean isCycle(int V, int[][] edges) {
	        // Code here
		 //convert adj matrix to list
		 List<List<Integer>> adj = new ArrayList<>();
		 
		 //initialize it
		 for(int i=0;i<V;i++) {
			 adj.add(new ArrayList<>());
		 }
		 //fill the values
		 for(int i=0;i<V;i++) {
			 for(int j=0;j<edges[0].length;j++) {
				 adj.get(i).add(edges[i][j]);
			 }
		 }
	        //to track visited nodes
	        int vis[] = new int[V];
	        //fill with 0 initially
	        Arrays.fill(vis,0);
	        //iterate over the nodes for not connected components
	        for(int i=0;i<V;i++){
	            if(vis[i]==0){//if its not visited
	                if(dfs(i,-1,vis,adj)==true) return true;
	            }
	        }return false;
	        
	        
	    }
	    private static boolean dfs(int node, int parent, int[] vis, List<List<Integer>> adj){
	        //mark it visited
	        vis[node] = 1;
	        //call for all the adjacent nodes
	        for(int adjNode:adj.get(node)){
	            if(vis[adjNode]==0){//if adjacent node is not not visited
	            //if it returns true
	               if(dfs(adjNode,node,vis,adj)==true) return true;
	            }else if(parent != adjNode){
	                //if adj node is not parent but marked as visited then its a cycle
	                return true;
	            }
	        }return false;//else returns false
	    }
}
