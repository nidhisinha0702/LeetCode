package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIsland {

	public static void main(String[] args) {
		int n = 4, m = 5, operators[][] = {{1,1},{0,1},{3,3},{3,4}};
		System.out.println("number of islands are : "+numOfIslands(n, m, operators));

	}
	
	private static List<Integer> numOfIslands(int n, int m, int[][] operators){
		DisjointSetSize ds = new DisjointSetSize(n*m);
		int vis[][] = new int[n][m];
		int cnt = 0;
		List<Integer> ans = new ArrayList<>();
		for(int[] it:operators) {
			int row = it[0];
			int col = it[1];
			//already visited
			if(vis[row][col] == 1) {
				ans.add(cnt);
				continue;
			}
			vis[row][col] = 1;
			cnt++;
			int dr[] = {-1,0,1,0};
			int dc[] = {0,1,0,-1};
			for(int ind = 0;ind<4;ind++) {
				int adjr = row + dr[ind];
				int adjc = col + dc[ind];
				if(isValid(adjr,adjc,n,m)) {
					//is this an island
					if(vis[adjr][adjc] == 1) {
						int nodeNo = row * m + col;
						int adjNodeNo = adjr * m + adjc;
						if(ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
							cnt--;
							ds.unionBySize(nodeNo, adjNodeNo);
						}
					}
				}
			}
			ans.add(cnt);
		}return ans;
	}

	private static boolean isValid(int adjr, int adjc, int n, int m) {
		return (adjr >= 0 && adjr < n && adjc >= 0 && adjc < m);
	}

}
