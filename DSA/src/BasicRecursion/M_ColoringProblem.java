package BasicRecursion;

import java.util.ArrayList;
import java.util.List;

public class M_ColoringProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 4;
		List<int[]> edges = new ArrayList<>();
		edges.add(new int[]{0,1});
		edges.add(new int[]{1,2});
		edges.add(new int[]{2,3});
		edges.add(new int[]{3,0});
		edges.add(new int[]{0,2});
		int m = 3;
		boolean ans = graphColoring(v,edges,m);
		if(ans)
		System.out.println("The nodes can be colored");
		else	System.out.println("The nodes cannot be colored");

	}
	
	 private static boolean graphColoring(int v, List<int[]> edges, int m) {
	        // code here
	        //create an adjacency array of type List<Integer>
	        List<Integer>[] G=new ArrayList[v];
	        for(int i=0;i<v;i++){
	            G[i]= new ArrayList<>();
	        }
	        //Fill the adjacency list from the edges
	        for(int[] edge:edges){
	            G[edge[0]].add(edge[1]);
	            G[edge[1]].add(edge[0]);
	        }
	        
	        //color array
	        int color[] = new int[v];
	        //start solving
	        if(solve(0,G,color,m)) return true;
	        
	        return false;
	    }
	    
	    private static boolean solve(int node,List<Integer>[] G,int[] color,int m){
	        //base case
	        if(node == G.length) return true;
	        
	        //Try different colors for the current node
	        for(int i=1;i<=m;i++){
	            if(isSafe(node,G,color,i)){
	                color[node] = i;
	                //Recursively try to color the next node
	                if(solve(node+1,G,color,m))   return true;
	                //backtrack:reset the color if it doesn't lead to a solution
	                color[node]=0;
	            }
	        }return false;
	    }
	    
	    private static boolean isSafe(int node,List<Integer>[] G,int[] color,int colour){
	        //iterate over the G array
	        for(int it: G[node]){
	            //check if the node has been coloured with the same color or not
	            if(color[it] == colour) return false;
	        }return true;
	    }

}
