package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUnDirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		adj.add(new ArrayList<>(Arrays.asList(1)));
		adj.add(new ArrayList<>(Arrays.asList(0,2,4)));
		adj.add(new ArrayList<>(Arrays.asList(1,3)));
		adj.add(new ArrayList<>(Arrays.asList(2,4)));
		adj.add(new ArrayList<>(Arrays.asList(1,3)));
		
		System.out.println("Is cycle present in the graph : "+isCycle(adj));
	}
	
	private static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
		int V = adj.size();
		//vis array
		int[] vis = new int[V];
		Arrays.fill(vis, 0);
		//for connected component
		for(int i=0;i<V;i++) {//as the node are numbered from 0-V
			if(vis[i]!=1) {
				if(detect(i,adj,vis)) return true;
			}
		}return false;
	}

	private static boolean detect(int src, ArrayList<ArrayList<Integer>> adj, int[] vis) {
		 //push the src node and mark it vis
		vis[src] = 1;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(src,-1));//push src with parent node as -1
		while(!q.isEmpty()) {
			int node = q.peek().first;//get the node and its parent
			int parentNode = q.peek().second;
			q.remove();//pop it from queue
			for(int adjNode:adj.get(node)) {//check all its adjacent node
				if(vis[adjNode]!=1) {//if not visited
					vis[adjNode]=1;//visit it and push in the queue
					q.add(new Pair(adjNode,node));
				}else if(parentNode != adjNode) {//if it is visited and not the parent node means its touched by other node so cycle
					return true;
				}
			}
		}return false;
	}
	static class Pair{
		int first;
		int second;
		Pair(int f, int s){
			first = f;
			second = s;
		}
	}
}
