package java_class;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class graph_implementation {
	
	private LinkedList<Integer> adjacency[];
	public graph_implementation(int v) {
		adjacency = new LinkedList[v];
		for(int i = 0; i<v; i++) {
			adjacency[i] = new LinkedList<Integer>();
		}
	}
		public void insertedge(int s, int d) {
			adjacency[s].add(d);
			adjacency[d].add(s);
			System.out.println(adjacency[d]);
			System.out.println(adjacency[s]);
		}
		
		public void bfs(int source) {
			boolean visited_nodes[]= new boolean[adjacency.length];
			int parent_nodes[]= new int[adjacency.length];
			Queue<Integer> q = new LinkedList<>();
			q.add(source);
			visited_nodes[source]=true;
			parent_nodes[source]=-1;
			while(!q.isEmpty()) {
				int  p = q.poll();
				System.out.print(p+" ");
				for(int i:adjacency[p]) {
					if(visited_nodes[i]!=true)
					{
					visited_nodes[i]=true;
					q.add(i);
					parent_nodes[i]=p;
					}
				}
			}
		}
		
		public void dfs(int source) {
			boolean visited_nodes[]= new boolean[adjacency.length];
			int parent_nodes[]= new int[adjacency.length];
			Stack<Integer> st = new Stack<>();
			st.add(source);
			visited_nodes[source]=true;
			parent_nodes[source]=-1;
			while(!st.isEmpty()) {
				int  p = st.pop();
				System.out.print(p+" ");
				for(int i:adjacency[p]) {
					if(visited_nodes[i]!=true)
					{
					visited_nodes[i]=true;
					st.add(i);
					parent_nodes[i]=p;
					}
				}
			}
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices and edges");
		int v= sc.nextInt();
		int e= sc.nextInt();
		graph_implementation g = new graph_implementation(v);
		System.out.println("Enter edges");
		for(int i=0;i<e;i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			g.insertedge(s,d);
		}
		System.out.println("enter source for traversal");
		int source = sc.nextInt();
		System.out.println("bfs traversal");
		g.bfs(source);
		System.out.println();
		System.out.println("dfs traversal");
		g.dfs(source);

	}

}
