package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleI {

	 private static boolean canFinish(int numCourses, int[][] prerequisites) {
	        List<List<Integer>> adj = new ArrayList<>();

	        for(int i=0;i<numCourses;i++){
	            adj.add(new ArrayList<>());
	        }

	        for(int edge[]: prerequisites){
	            int u = edge[0];
	            int v = edge[1];
	            //inorder to perform task 1 we need to perform task 0
	            //edge is from 0 to 1
	            adj.get(v).add(u);
	        }

	        int indegree[] = new int[numCourses];

	        for(int i=0;i<numCourses;i++){
	            for(int it: adj.get(i)) {
	                indegree[it]++;
	            }
	        }

	        Queue<Integer> q = new LinkedList<>();
	        for(int i=0;i<numCourses;i++){
	            if(indegree[i] == 0){
	                q.add(i);
	            }
	        }

	        int processedCourses = 0;
	        while(!q.isEmpty()){
	            int node = q.poll();
	            processedCourses++;

	            for(int it:adj.get(node)){
	                indegree[it]--;
	                if(indegree[it] == 0) q.add(it);
	            }
	        }

	        return (processedCourses == numCourses);
	    }
	 
		public static void main(String[] args) {
			// WAP to demonstrate prerequisites 
			//for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
			//which can be 0 -> 1 like this
			//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
			int numCourses = 2, prerequisites[][] = {{1,0}};
			
			System.out.println("can finish  : "+canFinish(numCourses, prerequisites));
			
		}

}
