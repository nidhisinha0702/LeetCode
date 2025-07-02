package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CityWithSmallestNumberOfNeighbourII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4, m = 4,
				edges[][] = {{0, 1, 3},
				         {1, 2, 1}, 
				         {1, 3, 4},  
				         {2, 3, 1}},
				distanceThreshold = 4;
		System.out.println("city number is : "+findCity(n, m, edges, distanceThreshold));
	}
	//TC->V*(E*logV)
	static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            //bidirectional
            adjList.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adjList.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.d - b.d);
        int dist[][] = new int[n][n];
        for(int d[]:dist)
        Arrays.fill(d, Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            //find shortest distance from every node
            //make every node as src
            pq.add(new Pair(i, 0));
            dist[i][i] = 0;
            
            while(!pq.isEmpty()){
                Pair currPair = pq.poll();
                int currNode = currPair.node;
                int currDist = currPair.d;
                for(Pair adjP:adjList.get(currNode)){
                    int adjNode = adjP.node;
                    int adjD = adjP.d;
                    if(adjD + currDist < dist[i][adjNode]){
                        pq.add(new Pair(adjNode, adjD + currDist));
                        dist[i][adjNode] = adjD + currDist;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
                dist[i][i] = 0;
        }
        int ans = n;
        int city = -1;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(dist[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= ans){
                ans = cnt;
                city = i;
            }
        }
        return city;
    }
    static class Pair{
        int node;
        int d;
        Pair(int node, int d){
            this.node = node;
            this.d = d;
        }
    }
}
