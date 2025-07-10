package graph;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{1,0},{0,1}};
		System.out.println("largest island size is "+largestIsland(grid));

	}
	public static int largestIsland(int[][] grid) {
        //step 1 find and connect the components having 1
        int n = grid.length;
        DisjointSetSize ds = new DisjointSetSize(n*n);
        for(int row = 0; row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 0) continue;
                //go in all four direction and connect all 1s
                int dr[] = {-1,0,1,0};
                int dc[] = {0,-1,0,1};
                for(int ind =0;ind<4;ind++){
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if(isValid(newr, newc, n) && grid[newr][newc] == 1){
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        //step 2 converting every 0 to 1 and find the max size
        int mx = 0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 1) continue;
                int dr[] = {-1,0,1,0};
                int dc[] = {0,-1,0,1};
                Set<Integer> components = new HashSet<>();
                for(int ind =0;ind<4;ind++){
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if(isValid(newr, newc, n) && grid[newr][newc] == 1){
                        components.add(ds.findUPar(newr * n + newc));
                    }
                }
                int sizeTot = 0;
                for(Integer parents : components){
                    sizeTot += ds.size.get(parents);
                }
                mx = Math.max(mx, sizeTot + 1);
            }
        }

        //edge case if there is all 1's and no 0's
        for(int cellNo =0;cellNo<n*n;cellNo++){
            mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
        }
        return mx;
    }
    private static boolean isValid(int newr, int newc, int n){
        return (newr >= 0 && newr < n && newc >= 0 && newc < n);
    }
}
