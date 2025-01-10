package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V=5;
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		adjacencyList.add(new ArrayList<>(Arrays.asList(2,3,1)));
		adjacencyList.add(new ArrayList<>(Arrays.asList(0)));
		adjacencyList.add(new ArrayList<>(Arrays.asList(0,4)));
		adjacencyList.add(new ArrayList<>(Arrays.asList(0)));
		adjacencyList.add(new ArrayList<>(Arrays.asList(2)));
		
		ArrayList<Integer> ans = bfsOfGraph(V,adjacencyList);
		System.out.println("The bfs traversal for above graph is::"+ans);

	}
	private static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[]=new boolean[V];//as the graph starts from 0 base indexing
        Queue<Integer> q = new LinkedList<>();//to perform fifo operation on the nodes
        
        //add the 1st node
        q.add(0);
        //mark it visited
        vis[0]=true;
        
        while(!q.isEmpty()){
            Integer node=q.poll();//poll will return the node and remove it from the queue
            bfs.add(node);//add the node to bfs
            //check all the adjacent nodes for node
            //we will use given adjacency list
            List<Integer> list = adj.get(node);
            for(Integer it:list){
                if(vis[it] == false){//if the adjacent node is marked false means not visited
                    vis[it]=true;//mark it true as visited
                    q.add(it);//add it to q
                }
            }
        }return bfs;
	}
}
