package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionInDGBFS {

	private static boolean isCycle(int V, List<List<Integer>> adj) {
		
		int indegree[] = new int[V];
		for(int i=0;i<V;i++) {
			indegree[i]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<V;i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int node = q.poll();
			cnt++;
			
			for(int it:adj.get(node)) {
				indegree[node]--;
				if(indegree[it] == 0) q.add(it);
			}
		}
		//if all the nodes are visited cnt will be equal to V else there is a cycle
		return cnt == V;
		
	}
	
	public static void main(String[] args) {
		//WAP to detect cycle in a directed graph using BFS(toposort)
		int edges[][] = {{1,2},{2,3},{3,5},{3,4},{4,2}};
		int V = 5;
		
		List<List<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int edge[]:edges) {
			int u = edge[0];
			int v = edge[1];
			adj.get(u).add(v);
		}
		
		System.out.println("The graph contains a cycle : "+isCycle(V, adj));
	}

}
