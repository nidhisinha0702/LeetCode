package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ComponentsInGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// read number of edges
		int E = sc.nextInt();
		List<List<Integer>> gb = new ArrayList<>();

		// reading the edges
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			gb.add(Arrays.asList(u, v));
		}

		// getting the result from the componentsIn graph method
		List<Integer> result = componentsInGraph(gb);

		System.out.println(result);

	}

	public static List<Integer> componentsInGraph(List<List<Integer>> gb) {

		int maxNode = 0;

		// find the max node to size vis[] and adj[]
		for (List<Integer> edge : gb) {
			maxNode = Math.max(maxNode, Math.max(edge.get(0), edge.get(1)));
		}

		int vis[] = new int[maxNode + 1];// 1-based index

		List<List<Integer>> adj = new ArrayList<>();
		// initialize adj list
		for (int i = 0; i <= maxNode; i++) {
			adj.add(new ArrayList<>());
		}

		// add the edges to adj list
		for (List<Integer> edge : gb) {
			int u = edge.get(0);
			int v = edge.get(1);
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		List<Integer> ans = new ArrayList<>();

		//Traverse each node and find connected components
		for (int i = 1; i <= maxNode; i++) {
			if (vis[i] == 0 && !adj.get(i).isEmpty()) {
				//create a cnt array of size 1 to keep the count of adjacent nodes
				int[] cnt = new int[1];
				dfs(i, adj, vis, cnt);
				if (cnt[0] > 1) {
					ans.add(cnt[0]);
				}
			}

		}
		
		//sort the array and find the min and max value and put it in an array
		Collections.sort(ans);
	    return new ArrayList(Arrays.asList(ans.get(0),ans.get(ans.size()-1)));
	}

	private static void dfs(int node, List<List<Integer>> adj, int[] vis, int[] cnt) {
		vis[node] = 1;
		cnt[0]++;
		for (int adjnode : adj.get(node)) {
			if (vis[adjnode] == 0) {
				dfs(adjnode, adj, vis, cnt);
			}
		}
	}
}
