package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortedPathDAGTopoSortDFS {

	public static void main(String[] args) {
		int V = 6, E = 7, edges[][] = {{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};
		int ans[] = shortestPath(V, E, edges);
		System.out.println(Arrays.toString(ans));
	}
	
	private static int[] shortestPath(int V, int E, int[][] edges) {
        //build graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
        }
        
        //perform toposort
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                topoSort(i, adj, vis, st);
            }
        }
        //calculate dist
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            
            for(int i=0;i<adj.get(node).size();i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                if(dist[v] > wt + dist[node]){
                    dist[v] = wt + dist[node];
                }
            }
        }
        
        for(int i=0;i<dist.length;i++){
            if(dist[i] == Integer.MAX_VALUE)
            dist[i] = -1;
        }
        
        return dist;
    }
    
    private static void topoSort(int node,  ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st){
        vis[node] = 1;
        
        for(int i=0;i<adj.get(node).size();i++){
            int adjNode = adj.get(node).get(i).first;
            if(vis[adjNode] == 0){
                topoSort(adjNode, adj, vis, st);
            }
        }
        
        st.push(node);
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
