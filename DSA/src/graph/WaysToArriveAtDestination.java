package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class WaysToArriveAtDestination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7, roads[][] = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		System.out.println("the number of ways you can arrive at your destination in the shortest amount of time is : "+countPaths(n, roads));
	}
	//TC->O(ElogV)
	 public static int countPaths(int n, int[][] roads) {
	        //create the graph
	        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	        for(int i=0;i<n;i++){
	            adj.add(new ArrayList<>());
	        }

	        for(int road[] : roads){
	            adj.get(road[0]).add(new Pair(road[1], road[2]));
	            adj.get(road[1]).add(new Pair(road[0], road[2]));
	        }

	        //min-heap ({dist,node})
	        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> Long.compare(a.first,b.first));
	        pq.add(new Pair(0, 0));

	        long dist[] = new long[n];
	        Arrays.fill(dist, (long)1e9);
	        long ways[] = new long[n];
	        dist[0] = 0;
	        ways[0] = 1; //to reach src there is one way
	        final long mod = (long)(1e9 + 7);

	        while(!pq.isEmpty()){
	            long dis = pq.peek().first;
	            long node = pq.peek().second;
	            pq.remove();

	            for(Pair p : adj.get((int)node)){
	                long adjNode = p.first;
	                long edW = p.second;

	                //this is the first time we are coming with the short distance
	                if(dis + edW < dist[(int)adjNode]){
	                    dist[(int)adjNode] = dis + edW;
	                    pq.add(new Pair(dis + edW, adjNode));
	                    ways[(int)adjNode] = ways[(int)node];
	                }
	                //we again encounter a node with same short distance as before
	                else if(dis + edW == dist[(int)adjNode]){
	                    ways[(int)adjNode] = (ways[(int)adjNode] + ways[(int)node]) % mod;
	                }
	            }
	        }
	        return (int)(ways[n-1] % mod);
	    }
	    static class Pair{
	        long first;
	        long second;
	        Pair(long first, long second){
	            this.first = first;
	            this.second = second;
	        }
	    }
}
