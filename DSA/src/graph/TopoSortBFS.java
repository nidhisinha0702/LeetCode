package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortBFS {

	private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		
		//step1 find the indegree(edges coming toward vertex) of each vertex
		int indegree[] = new int[V];
		//iterate over each vertex
		for(int i=0;i<V;i++) {
			//get its adjacent nodes one by one 
			for(int it: adj.get(i)) {
				//increment its indegree
				indegree[it]++;
			}
		}
		
		//step2 we will start with storing 0 indegree node in q
		Queue<Integer> q = new LinkedList<>();
		//iterate on the vertices
		for(int i=0;i<V;i++) {
			//add all the vertex with indegree 0 in the q
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		//step 3 pop elements from q one by one and process it
		int topo[] = new int[V];
		int i=0;
		while(!q.isEmpty()) {
			int node = q.poll();
			//keep adding each popped node to the sort array
			topo[i++] = node;
			//now as the node is in topo remove it from the indegree
			for(int it : adj.get(node)) {
				indegree[it]--;
				//once the indegree becomes 0 add it to the q again and again
				if(indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		
		return topo;
	}
	
	public static void main(String[] args) {
		// WAP to demo topological sort or kahn's algorithm using bfs
		
		int V = 6, edges[][] = {{2,3},{3,1},{4,0},{4,1},{5,0},{5,2}};
		//int edges[][] = {{1,0},{1,2},{0,1}};
		// create adj list from given edges
		
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
    	int[] ans = topoSort(V, adj);
		System.out.println(Arrays.toString(ans));
	}

}
