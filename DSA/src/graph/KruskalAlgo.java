package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgo {

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
		int edges[][] = {{0,1,2},{0,2,1},{1,2,1},{2,3,2},{3,4,1},{4,2,2}};
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<ArrayList<Integer>>());
		}
		
		for(int i=0;i<6;i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];
			
			ArrayList<Integer> tmp1 = new ArrayList<>();
			ArrayList<Integer> tmp2 = new ArrayList<>();
			tmp1.add(v);
			tmp1.add(w);
			tmp2.add(u);
			tmp2.add(w);
			adj.get(u).add(tmp1);
			adj.get(v).add(tmp2);
		}
		
		int wt = spanningTree(V, adj);
		System.out.println("the minimum spanning tree weight is : "+wt);
	}
	//TC->O(N + E) + O(E log E) + O(E x 4 x alpha x 2)
	private static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		List<Edge> edges = new ArrayList<>();
		
		//O(N+E)
		for(int i=0;i<V;i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				int adjNode = adj.get(i).get(j).get(0);
				int wt = adj.get(i).get(j).get(1);
				int node = i;
				Edge temp = new Edge(i, adjNode, wt);
				edges.add(temp);
			}
		}
		
		DisjointSetSize ds = new DisjointSetSize(V);
		
		//O(M log M)
		Collections.sort(edges);
		int mstWt = 0;
		//M x 4 x alpha x 2
		for(int i=0;i<edges.size();i++) {
			int wt = edges.get(i).weight;
			int u = edges.get(i).src;
			int v = edges.get(i).dest;
			
			if(ds.findUPar(u) != ds.findUPar(v)) {
				mstWt += wt;
				ds.unionBySize(u,v);
			}
		}
		return mstWt;
		
	}
	static class Edge implements Comparable<Edge>{
		int src, dest, weight;
		Edge(int _src, int _dest, int _weight){
			this.src = _src;
			this.dest = _dest;
			this.weight = _weight;
		}
		//sort based on edge weight
		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	}
	
}
