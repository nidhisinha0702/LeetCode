package graph;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjacencyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
		//edge[source,destination]
		int edges[][] = {{0,1},{0,4},{4,1},{4,3},{1,3},{1,2},{3,2}};
		
		List<List<Integer>> ans = printGraph(V,edges);
		for(List<Integer> list: ans)
		System.out.print(list+" ");

	}
	private static List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        
        for(int[] edge:edges){
          //for edge[u,v],add v to the list at index u
        	adj.get(edge[0]).add(edge[1]);
        	//for edg[u,v], add u to the index v
        	adj.get(edge[1]).add(edge[0]);
        }return adj;
    }
}
