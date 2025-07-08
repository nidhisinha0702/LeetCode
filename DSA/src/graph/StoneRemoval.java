package graph;

import java.util.HashMap;
import java.util.Map;

public class StoneRemoval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stones[][] = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		System.out.println("Most stones removed with same row or column "+removeStones(stones));
	}
	public static int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int it[]:stones){
            maxRow = Math.max(maxRow, it[0]);
            maxCol = Math.max(maxCol, it[1]);
        }
        DisjointSetSize ds = new DisjointSetSize(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for(int it[]:stones){
            int nodeRow = it[0];
            int nodeCol = it[1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }
        int cnt = 0;
        for(Map.Entry<Integer,Integer> it: stoneNodes.entrySet()){
            if(ds.findUPar(it.getKey()) == it.getKey()){
                cnt++;
            }
        }
        return n - cnt;
    }
}
