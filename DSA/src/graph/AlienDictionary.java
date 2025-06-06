package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {

	public static void main(String[] args) {
		//WAP to find the sorted string in an alien dictionary
		String words[] = {"baa","abcd","abca","cab","cad"};
		System.out.println("word order should be : "+findOrder(words));

	}
	//TC->O(n*m), SC->O(1)
	private static String findOrder(String words[]) {
		//build graph
		int n = words.length;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		//we dont know how many characters will be there so 26
		boolean[] exists = new boolean[26];
		int[] indegree = new int[26];
		for(int i=0;i<26;i++) {
			adj.add(new ArrayList<>());
		}
		
		//mark character that exists in the input
		for(String w: words) {
			for(char ch:w.toCharArray())
				exists[ch - 'a'] = true;
		}
		
		//iterate on the strings array and build the graph
		for(int i=0;i<n - 1;i++) {
			String w1 = words[i];
			String w2 = words[i+1];
			int len = Math.min(w1.length(), w2.length());
			int j=0;
			//if the char match
			while(j < len && w1.charAt(j) == w2.charAt(j))
				j++;
			if(j < len) {
				int u = w1.charAt(j) - 'a';
				int v = w2.charAt(j) - 'a';
				adj.get(u).add(v);
				indegree[v]++;
			}else if(w1.length() > w2.length()) {
				//everything matched and w1 is greater
				return "";//invalid input//dictionary not possible
			}
		}
		
		ArrayList<Integer> topo = topoSort(exists,indegree,adj);
		
		StringBuilder sb = new StringBuilder();
		for(int it:topo) {
			sb.append((char)(it + 'a'));
		}
		return sb.toString();
	}
	
	private static ArrayList<Integer> topoSort(boolean[] exists, int indegree[],ArrayList<ArrayList<Integer>> adj){
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<26;i++) {
			if(exists[i] && indegree[i] == 0)
				q.add(i);
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		while(!q.isEmpty()) {
			int node = q.poll();
			ans.add(node);
			for(int it: adj.get(node)) {
				indegree[it]--;
				if(indegree[it] == 0)
					q.add(it);
			}
		}
		//check cycle
		for(int i=0;i<26;i++) {
			if(exists[i] && indegree[i] != 0)
				return new ArrayList<>();
		}
		
		return ans;
	}

}
