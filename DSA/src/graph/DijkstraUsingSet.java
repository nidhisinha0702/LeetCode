package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class DijkstraUsingSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int src=2, V=3, edges[][]= {{0,1,1},{1,2,3},{0,2,6}};
		
		int ans[] = shortestPathSet(V, edges, src);
		for(int a:ans)
			System.out.print(a+" ");
	}
	
	private static ArrayList<ArrayList<ArrayList<Integer>>> constructAdj(int[][] edges,int V){
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int[] edge:edges) {
			int u = edge[0];
			int v = edge[1];
			int wt = edge[2];
			ArrayList<Integer> e1 = new ArrayList<>();
			e1.add(v);
			e1.add(wt);
			adj.get(u).add(e1);
			ArrayList<Integer> e2 = new ArrayList<>();
			e2.add(u);
			e2.add(wt);
			adj.get(v).add(e2);
		}
		return adj;
	}
	
	private static int[] shortestPathSet(int V, int[][] edges, int src) {
		//create the adjacency list
		ArrayList<ArrayList<ArrayList<Integer>>> adj = constructAdj(edges, V);
		
		//Treeset in java store unique elements in sorted order(BSt->red-blacktree), but pair dont have natural sorting
		//so we have written comparator to compare on the basis 1st dist if they are diff ,else node
		//It store the pair of distance,node
		TreeSet<Pair> set = new TreeSet<>((a,b)-> {
			if(a.distance != b.distance) return Integer.compare(a.distance,b.distance);
			return Integer.compare(a.node,b.node);
		});
		//dist array to keep track of min dist
		int dist[] = new int[V];
		//fill with max value
		Arrays.fill(dist, (int)1e9);
		
		//start will src
		set.add(new Pair(0,src));
		dist[src]=0;
		
		//loop over treeset
		while(!set.isEmpty()) {
			int dis = set.getFirst().distance;
			int node = set.getFirst().node;
			set.pollFirst();
			
			//check min dist for all adj
			for(int i=0;i<adj.get(node).size();i++) {
				int edgeW = adj.get(node).get(i).get(1);
				int adjN = adj.get(node).get(i).get(0);
				
				//check if the len is shorter
				if(dis + edgeW < dist[adjN]) {
					//check if the node is previously vis by other node and you got new min then remove the prev pair
					if(dist[adjN] != (int) 1e9) {
						set.remove(new Pair(dist[adjN],adjN));
					}
					//update the new dis
					dist[adjN] = dis + edgeW;
					set.add(new Pair(dist[adjN],adjN));
				}
			}
		}
		//return the dist array
		return dist;
	}
	static class Pair{
		int distance;
		int node;
		Pair(int dist,int n){
			distance=dist;
			node=n;
		}
	}
}
