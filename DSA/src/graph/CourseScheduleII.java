package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

	 public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
	        // code here
	        List<List<Integer>> adj = new ArrayList<>();

	        for(int i=0;i<n;i++){
	            adj.add(new ArrayList<>());
	        }

	        for(int edge[]: prerequisites){
	            int u = edge[0];
	            int v = edge[1];
	            //inorder to perform task 1 we need to perform task 0
	            //edge is from 0 to 1
	            adj.get(v).add(u);
	        }

	        int indegree[] = new int[n];

	        for(int i=0;i<n;i++){
	            for(int it: adj.get(i)) {
	                indegree[it]++;
	            }
	        }

	        Queue<Integer> q = new LinkedList<>();
	        for(int i=0;i<n;i++){
	            if(indegree[i] == 0){
	                q.add(i);
	            }
	        }

	        ArrayList<Integer> topo = new ArrayList<>();
	        
	        while(!q.isEmpty()){
	            int node = q.poll();
	            topo.add(node);

	            for(int it:adj.get(node)){
	                indegree[it]--;
	                if(indegree[it] == 0) q.add(it);
	            }
	        }

	        return topo;
	    }
	 
	public static void main(String[] args) {
		// WAP to demonstrate prerequisites 
		//for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
		//which can be 0 -> 1 like this
		//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
		int numCourses = 2, prerequisites[][] = {{1,0}};
		ArrayList<Integer> ans = findOrder(numCourses, prerequisites);
		System.out.println("order is  : "+ans);
		
	}

}
