package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 3, E = 3;
		List<List<int[]>> adj = new ArrayList<>();
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		int arr[][] = {{0, 1, 5},{1, 2, 3},{0, 2, 1}};
		
		for(int num[] : arr) {
			int u = num[0];
			int v = num[1];
			int w = num[2];
			adj.get(u).add(new int[] {v,w});
			adj.get(v).add(new int[] {u,w});
		}
		
		System.out.println("The minimum sum is : "+spanningTree(V, E, adj));
	}
	static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.wt - b.wt);
        int vis[] = new int[V];
        
        //{wt,node}
        pq.add(new Pair(0, 0));
        int sum = 0;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int weight = p.wt;
            int node = p.node;
            
            //if already vis
            if(vis[node] == 1) continue;
            //while adding to mst
            vis[node] = 1;
            sum += weight;
            
            for(int[] list : adj.get(node)){
                int adjNode = list[0];
                int edW = list[1];
                if(vis[adjNode] == 0){
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }return sum;
    }
    static class Pair{
        int wt;
        int node;
        Pair(int wt, int node){
            this.wt = wt;
            this.node = node;
        }
    }
}
