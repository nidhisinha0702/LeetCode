package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GiftingGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> related = Arrays.asList("110","110","001");
		System.out.println("groups are : "+countGroups(related));

	}
	//Time complexity of this approach is o(n*n) as we are traversing n node and for each node n other node
	//space complexity o(n) (vis) + call stack o(n)
	private static int countGroups(List<String> related) {
		int n = related.size();
		int vis[] = new int[n];
		int groups = 0;
		List<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		//to improve on time and space we will convert matrix to list, now the time & space is o(e+n)
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i!=j && related.get(i).charAt(j) == '1')
				adj.get(i).add(j);
			}
		}
		
		//connected components
		for(int i=0;i<n;i++) {
			if(vis[i]==0) {
				dfs(i,adj,vis);
				groups++;
			}
		}
		return groups;
	}
	
	private static void dfs(int person, List<ArrayList<Integer>> adj, int[] vis) {
		vis[person]=1;
		for(int adjnode:adj.get(person)) {
			if(vis[adjnode]==0) {
				dfs(adjnode,adj,vis);
			}
		}
	}
}
