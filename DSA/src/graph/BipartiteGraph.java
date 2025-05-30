package graph;

import java.util.Arrays;

public class BipartiteGraph {

	public static void main(String[] args) {
		// WAp to find a bipartite graph
		//a graph is called bipartite if all the adjacent nodes can be colored in two different color
		//we have considered 0/1
		int graph[][] = {{1,2,3},{0,2},{0,1,3},{0,2}};
		System.out.println("The gievn graph is bipartite : "+isBipartite(graph));

	}
	 private static boolean isBipartite(int[][] graph) {
	        //we are given adj mat
	       int V = graph.length;//vertex
	       int color[] = new int[V];//vis/colored array
	       Arrays.fill(color, -1);//fill with -1
	       for(int i=0;i<V;i++){//disconnected components
	         if(color[i] == -1){//if not colored
	            if(dfs(i, 0, color, graph) == false) return false;
	         }
	       }return true;
	    }

	    private static boolean dfs(int node, int col, int color[], int[][] graph){
	        color[node] = col;

	        for(int adjNode: graph[node]){
	            if(color[adjNode] == -1){
	                if(dfs(adjNode, 1 - col, color, graph) == false) return false;
	            }else if(color[adjNode] == col){
	                return false;
	            }
	        }return true;
	    }
}
