package graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {

	public static void main(String[] args) {
		//adj[][] = [[2, 3], [0], [1], [4], []]
		int edges[][] = {{2,3},{0},{1},{4},{}};
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int n = edges.length;
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<edges[i].length;j++) {
				adj.get(i).add(edges[i][j]);
			}
		}
		
		System.out.println("Number of strongly connected components are : "+kosaraju(adj));	

	}
	 public static int kosaraju(ArrayList<ArrayList<Integer>> adj) {
	        //step1 perform dfs on each component
	        int n = adj.size();
	        int vis[] = new int[n];
	        Stack<Integer> st = new Stack<>();
	        //O(V+E)
	        for(int i=0;i<n;i++){
	            if(vis[i] == 0){
	                dfs(i, vis, adj, st);
	            }
	        }
	        
	        //step2 reverse the graph and store it
	        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
	        for(int i=0;i<n;i++){
	            adjT.add(new ArrayList<>());
	        }
	        //O(V+E)
	        for(int i=0;i<n;i++){
	            vis[i] = 0;
	            for(Integer it: adj.get(i)){
	                //i -> it (reverse the graph)
	                //it -> i
	                adjT.get(it).add(i);
	            }
	        }
	        
	        int scc = 0;
	        //O(V+E)
	        //step3 iterate on the stack and count scc
	        while(!st.isEmpty()){
	            int node = st.peek();
	            st.pop();
	            if(vis[node] == 0){
	                scc++;
	                //call dfs again
	                dfs3(node, vis, adjT);
	            }
	        }
	        return scc;
	    }
	    private static void dfs3(int node, int vis[],  ArrayList<ArrayList<Integer>> adjT){
	         vis[node] = 1;
	        for(int it:adjT.get(node)){
	            if(vis[it] == 0){
	                dfs3(it, vis, adjT);
	            }
	        }
	    }
	    private static void dfs(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
	        vis[node] = 1;
	        for(int it:adj.get(node)){
	            if(vis[it] == 0){
	                dfs(it, vis, adj, st);
	            }
	        }
	        st.push(node);
	    }

}
