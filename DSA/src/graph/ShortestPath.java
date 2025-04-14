package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int m = 6;
		int edges[][] = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};
		
		int[] ans = shortestPath(n, m, edges);
		
		for(int a:ans)
		System.out.print(" "+a+" ");

	}
	 private static int[] shortestPath(int n, int m, int edges[][]) {
	        //  Convert edges to adj
	        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
	        //initialize the adj for 1 based ind
	        for(int i=0;i<edges.length;i++){
	            adj.add(new ArrayList<>());
	        }
	        //fill the adj list from edges
	        for(int edge[]:edges){
	            int u = edge[0];
	            int v = edge[1];
	            int w = edge[2];
	            
	            //add edge from u to V
	            ArrayList<Integer> e1 = new ArrayList<>();
	            e1.add(v);
	            e1.add(w);
	            adj.get(u).add(e1);
	            
	            //for undirected graph add v to u
	            ArrayList<Integer> e2 = new ArrayList<>();
	            e2.add(u);
	            e2.add(w);
	            adj.get(v).add(e2);
	        }
	        
	        //min-heap is dist,node
	        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.dist - y.dist);
	        int []dist = new int[n+1];
	        Arrays.fill(dist,(int)1e9);
	        
	        //src node is 1
	        dist[1]=0;
	        //add {node,dist pair} in PQ
	        pq.add(new Pair(1,0));
	        
	        while(pq.size() != 0){
	        	//System.out.println("Inside while---");
	            int dis = pq.peek().dist;
	            int node = pq.peek().node;
	           // System.out.println("the value of distance and node are : "+dis+" "+node);
	            pq.remove();
	            
	            for(int i=0;i<adj.get(node).size();i++){
	                int edgeWeight = adj.get(node).get(i).get(1);
	                int adjNode = adj.get(node).get(i).get(0);
	              //  System.out.println("adj node weight and value:::"+edgeWeight+" ---"+adjNode);
	                if((dis + edgeWeight < dist[adjNode])){
	                    dist[adjNode] = dis + edgeWeight;
	                   // System.out.println("new dist value : "+dist[adjNode]);
	                    pq.add(new Pair(adjNode,dist[adjNode]));
	                }
	            }
	        }
	        //ArrayList<Integer> ans = new ArrayList<>();
	        //ans.add(dist[n]);
	        return dist;
	    }
	    
	    static class Pair{
	        int node;
	        int dist;
	        Pair(int node, int dist){
	            this.node = node;
	            this.dist = dist;
	        }
	    }
}
