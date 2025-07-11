package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionInNetwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		List<List<Integer>> connections = new ArrayList<>();
		List<Integer> node1 = new ArrayList<>() { {add(0);add(1);}};
		List<Integer> node2 = new ArrayList<>() { {add(1);add(2);}};
		List<Integer> node3 = new ArrayList<>() { {add(2);add(0);}};
		List<Integer> node4 = new ArrayList<>() { {add(1);add(3);}};
		connections.add(node1);connections.add(node2);connections.add(node3);connections.add(node4);
		System.out.println("Bridges are : "+criticalConnections(n, connections));
	}
	 private static int timer = 1;
	 //TC->O(V+2E), SC->O(V+2E) + O(3N)
	 public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
	        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	        for(int i=0;i<n;i++){
	            adj.add(new ArrayList<>());
	        }
	        for(List<Integer> it:connections){
	            int u = it.get(0); int v = it.get(1);
	            adj.get(u).add(v);
	            adj.get(v).add(u);
	        }
	        int vis[] = new int[n];
	        int tin[] = new int[n];
	        int low[] = new int[n];
	        List<List<Integer>> bridges = new ArrayList<>();
	        dfs(0, -1, vis, adj, tin, low, bridges);
	        return bridges;
	    }
	    private static void dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj, int tin[], int low[], List<List<Integer>> bridges){
	        vis[node] = 1;
	        tin[node] = low[node] = timer;
	        timer++;
	        for(Integer it: adj.get(node)){
	            if(it == parent) continue;
	            if(vis[it] == 0){
	                dfs(it, node, vis, adj, tin, low, bridges);
	                low[node] = Math.min(low[node], low[it]);
	                //node ----- it
	                if(low[it] > tin[node]){
	                    bridges.add(Arrays.asList(it, node));
	                }
	            }else{
	                low[node] = Math.min(low[node], low[it]);
	            }
	        }
	    }
}
