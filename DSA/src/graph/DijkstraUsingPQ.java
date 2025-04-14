package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraUsingPQ {
//TC-O(E log(V)) SC-O(|E|+|V|)
	public static void main(String[] args) {
		//given 3 nodes with 3 edges and the src node is 2
		int V_nodes = 3, E_edge=3,S_src=2;
		//below is the arraylist of {node, weight} {{{1,1},{2,6}} , {{2,3},{0,1}} ,{{1,3},{0,6}}};
		ArrayList<Integer> node1 = new ArrayList<Integer>() {
			{
				add(1);add(1);
			}};
		ArrayList<Integer> node2 = new ArrayList<Integer>() {
			{
				add(2);add(6);
			}};
		ArrayList<Integer> node3 = new ArrayList<Integer>() {
			{
				add(2);add(3);
			}};
		ArrayList<Integer> node4 = new ArrayList<Integer>() {
			{
				add(0);add(1);
			}};
		ArrayList<Integer> node5 = new ArrayList<Integer>() {
			{
				add(1);add(3);
			}};
		ArrayList<Integer> node6 = new ArrayList<Integer>() {
			{
				add(0);add(6);
			}};
		
		ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>() {
			{
			add(node1);
			add(node2);
			}
		};
		ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>() {
			{
			add(node3);
			add(node4);
			}
		};
		ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>() {
			{
			add(node5);
			add(node6);
			}
		};
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>() {
			{
			add(inter1);//for 1st node
			add(inter2);//for 2nd node
			add(inter3);//for 3rd node
			}
		};
		
		//add final values of adj here
		DijkstraUsingPQ obj = new DijkstraUsingPQ();
		int res[] = obj.dijkstra(V_nodes,adj,S_src);
		
		for(int i=0;i<V_nodes;i++) {
			System.out.println(res[i]+" ");
		}
		System.out.println();
	}
	static class Pair{
		int node;
		int distance;
		Pair(int distance, int node){
			this.node = node;
			this.distance = distance;
		}
	}
	
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
		//create a priority queue for storing the nodes as a pair {dis, node}
		//where dis is the distance from source to the node
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
		
		int dist[] = new int[V];
		//initialize dis to list with a large number to indicate the nodes are unvisited initially.
		//the list contains distance from source to the nodes
		for(int i=0;i<V;i++)
			dist[i] = (int)(1e9);
		
		//source initialized with dist =0
		dist[S]=0;
		pq.add(new Pair(0,S));//added to the queue
		
		//now pop the minimum distance node first from the min-heap
		//and traverse for all its adjacent nodes
		while(pq.size()!=0) {
			int dis = pq.peek().distance;
			int node = pq.peek().node;
			pq.remove();
			
			//check for all adjacent nodes of the popped out element whether the prev dist is larger than current or not
			for(int i=0;i<adj.get(node).size();i++) {
				int edgeWeight = adj.get(node).get(i).get(1);
				int adjNode = adj.get(node).get(i).get(0);
				
				//if current distance is smaller
				//push it into the queue
				if(dis + edgeWeight < dist[adjNode]) {
					dist[adjNode] = dis + edgeWeight;
					pq.add(new Pair(dist[adjNode], adjNode));
				}
			}
		}
		
		//return the list containing shortest distances from the source to all nodes
		return dist;
	}
}
