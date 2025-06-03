package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	private static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // create adj list from given edges
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        //visted to keep track of visited nodes
        int vis[] = new int[V];
        //stack to keep track of linear ordering in toposort
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0;i<V;i++){
            if(vis[i] == 0){
                dfs(i, vis, st, adj);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        //pop everything from stack
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        
        return ans;
    }
    
    private static void dfs(int node, int vis[], Stack<Integer> st, List<List<Integer>> adj){
        vis[node] = 1;
        for(int adjNode : adj.get(node)){
            if(vis[adjNode] == 0){
                dfs(adjNode, vis, st, adj);
            }
        }
        st.push(node);
    }
	public static void main(String[] args) {
		// WAP to demonstrate topological sorting for DAG (directed acyclic graph) is a linear ordering of vertices such that
		//for every directed edge u-v, vertex u comes before v in the ordering
		int V= 6, edges[][] = {{2,3},{3,1},{4,0},{4,1},{5,0},{5,2}};
		ArrayList<Integer> ans = topoSort(V, edges);
		System.out.println(ans);

	}

}
