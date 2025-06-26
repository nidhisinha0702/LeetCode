package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NetworkDelayTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int times[][] = {{2,1,1},{2,3,1},{3,4,1}}, n = 4, k = 2;
		System.out.println("Minimum time it takes for all the nodes to receive the signal : "+networkDelayTime(times, n, k));
	}
	//TC->O(E)
	public static int networkDelayTime(int[][] times, int n, int k) {
        //dijsktra algo with queue as time increases +1
        //step 1-create graph
       ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int path[]:times){
            int u = path[0];
            int v = path[1];
            int w = path[2];
            graph.get(u).add(new Pair(v,w));
        }

        //step2- construct the other parameters
        Queue<Pair> q = new LinkedList<>();
        //pair{time, src}
        q.add(new Pair(0,k));
        int time[] = new int[n+1];//1 based index
        Arrays.fill(time, (int)1e9);
        time[0] = 0;//consider 0 index as 0
        time[k] = 0;//src in 0 time

        //perform bfs
        while(!q.isEmpty()){
            Pair p = q.poll();
            int t = p.first;//time
            int node = p.second;//node

            //for all the adj nodes
            for(Pair pair : graph.get(node)){
                int adjNode = pair.first;
                int edgeW = pair.second;

                if(edgeW + t < time[adjNode]){
                    time[adjNode] = t + edgeW;
                    q.add(new Pair(t + edgeW, adjNode));
                }

            }
        }
        int minTime = 0;
        //edge case
        for(int i=0;i<=n;i++){
            if(time[i] == (int)1e9) return -1;
            if(minTime < time[i])
            minTime = time[i];
        }
        return minTime;
    }
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
