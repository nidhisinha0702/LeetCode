package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfProvinces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int isConnected[][] = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println("The total number of province are : "+findCircleNum(isConnected));

	}
	private static int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        //adjacency matrix to list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //create v nodes list inside adj list
        for(int i=0;i<V;i++) {
        	adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){//no self node
                adj.get(i).add(j);//add index instead of value
                }
            }
        }
        //
        int vis[] = new int[V];
        Arrays.fill(vis,0);
        int cnt = 0;
        //iterate for all the nodes
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i,adj,vis);
            }
        }return cnt;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[node] = 1;
        for(Integer it:adj.get(node)){
            if(vis[it] == 0){
                dfs(it,adj,vis);
            }
        }
    }
}
