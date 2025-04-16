package PartitionDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MinimumCostToCutStick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cuts[] = {1,3,4,5};
		int n = 7;
		System.out.println("Minimum cost to cut a stick is : "+minCostTab(n, cuts));
	}
	private static int minCost(int n, int[] cuts) {
		ArrayList<Integer> cut = (ArrayList<Integer>) Arrays.stream(cuts).boxed().collect(Collectors.toList());
		int c = cut.size();
		cut.add(0);
        cut.add(n);
        Collections.sort(cut);
        //changing parameter is i&j and its size is c
        int dp[][] = new int[c+1][c+1];
        for(int row[]:dp)
        Arrays.fill(row,-1);
        return f(1,c, cut,dp);
    }
    private static int f(int i, int j, ArrayList<Integer> cut, int[][] dp){
        if(i>j) return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i;ind<=j;ind++){
            int cost = cut.get(j+1) - cut.get(i-1)+f(i,ind-1,cut,dp)+f(ind+1,j,cut,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
    private static int minCostTab(int n, int[] cuts) {
        ArrayList<Integer> cut = (ArrayList<Integer>) Arrays.stream(cuts).boxed().collect(Collectors.toList());
        int c = cut.size();
        cut.add(0);
        cut.add(n);
        Collections.sort(cut);
        int dp[][] = new int[c+2][c+2];
        for(int row[]:dp)
        Arrays.fill(row,0);

        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                 int mini = Integer.MAX_VALUE;
                    for(int ind=i;ind<=j;ind++){
                        int cost = cut.get(j+1) - cut.get(i-1) + dp[i][ind-1] + dp[ind+1][j];
                        mini=Math.min(mini,cost);
                    }
                    dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }
}
