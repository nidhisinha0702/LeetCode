package graph;

import java.util.ArrayList;

public class ArticulationPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5, edges[][] = {{0, 1}, {1, 4}, {4, 3}, {4, 2}, {2, 3}};
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        System.out.println("Articulation points are : "+articulationPoints(V, adj));

	}
	 private static int timer = 1;
	 public static ArrayList<Integer> articulationPoints(int V,
	                                                 ArrayList<ArrayList<Integer>> adj) {
	        // Code here
	        int n = V;
	        int vis[] = new int[n];
	        int tin[] = new int[n];
	        int low[] = new int[n];
	        int mark[] = new int[n];
	        
	        //go on all the components
	        for(int i=0;i<n;i++){
	            //if not vis
	            if(vis[i] == 0){
	                dfs(i, -1, vis, tin, low, mark, adj);
	            }
	        }
	        
	        ArrayList<Integer> ans = new ArrayList<>();
	        for(int i=0;i<n;i++){
	            if(mark[i] == 1){
	                ans.add(i);
	            }
	        }
	        
	        if(ans.size() == 0){
	            ans.add(-1);
	        }
	        return ans;
	    }
	    private static void dfs(int node, int parent, int[] vis, int[] tin, int low[], int mark[], ArrayList<ArrayList<Integer>> adj){
	        vis[node] = 1;
	        tin[node] = low[node] = timer;
	        timer++;
	        int child = 0;
	        
	        for(Integer it:adj.get(node)){
	            if(it == parent) continue;
	            if(vis[it] == 0){
	                dfs(it, node, vis, tin, low, mark, adj);
	                low[node] = Math.min(low[node], low[it]);
	                
	                if(low[it] >= tin[node] && parent != -1){
	                    mark[node] = 1;
	                }
	                child++;
	            }else{
	                low[node] = Math.min(low[node], tin[it]);
	            }
	        }
	        if(child > 1 && parent == -1){
	            mark[node] = 1;
	        }
	    }
}
