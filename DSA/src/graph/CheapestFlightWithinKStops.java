package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithinKStops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}, src = 0, dst = 3, k = 1, n = 4;
		System.out.println("The cheapest flight withing k stops is : "+findCheapestPrice(n, flights, src, dst, k));
	}
	//TC->O(E)
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //we will apply dijstra's algo here only we need to consider the maximum k stops to reach the destination
        //stops are always increasing in +1 so we can use queue ds
        //step1- create graph from edges
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int path[]:flights){
            int u = path[0];
            int v = path[1];
            int w = path[2];
            graph.get(u).add(new Pair(v,w));
        }

        //step2- construct the other parameters
        Queue<Tuple> q = new LinkedList<>();
        //pair{stops, node, dis}
        q.add(new Tuple(0,src,0));
        int dist[] = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        //perform bfs
        while(!q.isEmpty()){
            Tuple p = q.poll();
            int stops = p.first;
            int node = p.second;
            int cost = p.third;

            //if the stops is > continue
            if(stops > k) continue;
            for(Pair pair : graph.get(node)){
                //{0}->{{1,100}-{node,weight}}
                int adjNode = pair.first;
                int edgeW = pair.second;

                if(edgeW + cost < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edgeW;
                    q.add(new Tuple(stops + 1, adjNode, cost + edgeW));
                }

            }
        }
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }

    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static class Tuple{
        int first;
        int second;
        int third;
        Tuple(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
