package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeStates {

	private static List<Integer> safeNodes(int [][]graph){
		//The idea is the terminal nodes have outdegree 0 but we can apply kahn algorithm only to indegree
		//so we will reverse the edges now the terminal nodes will become those which has indegree 0
		//the path which has cyclic dependency is not the safe node
		int V = graph.length;
		
		//create adjcency reverse list from given graph
		List<List<Integer>> adjRev = new ArrayList<>();
		for(int i=0;i<V;i++) {
			adjRev.add(new ArrayList<>());
		}
		
		//REVERSE THE EDGES AND FIND INDEGREE
		int indegree[] = new int[V];
		
		//iterate on each vertex
		for(int i=0;i<V;i++) {
			//pick one-one element from that vertex i
			for(int it:graph[i]) {
				//for reverse edge
				adjRev.get(it).add(i);
				indegree[i]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<V;i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		List<Integer> safeNode = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int node = q.poll();
			safeNode.add(node);
			
			for(int it:adjRev.get(node)) {
				indegree[it]--;
				if(indegree[it] == 0) q.add(it);
			}
		}
		Collections.sort(safeNode);
		return safeNode;
	}
	public static void main(String[] args) {
		//WAP to find the eventual safe state
		//A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
//Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
		int [][]graph = {{1,2},{2,3},{5},{0},{5},{},{}};
		System.out.println("safe nodes are : "+safeNodes(graph));
	}

}
