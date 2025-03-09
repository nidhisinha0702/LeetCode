package dynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = {1,1};
		int wt[] = {2,1};
		int capacity = 3;
		System.out.println("The maximum profit to fill that knapsack in such a way is : "+knapSack(val,wt,capacity));

	}
	 static int knapSack(int val[], int wt[], int capacity) {
	        // code here
		 	int n = wt.length;
	        return ff(capacity,val,wt);
	    }
	    static int f(int ind, int W, int[] val, int[] wt){
	    	int n = wt.length;
	        int dp[][] = new int[n][W+1];
	        for(int[] rows:dp) Arrays.fill(rows,-1);
	        if(ind == 0){
	            return ((int)(W/wt[0]))* val[0];
	        }
	        if(dp[ind][W] != -1) return dp[ind][W];
	        int nottake = 0 + f(ind-1,W,val,wt);
	        int take = 0;
	        if(wt[ind]<=W){
	            take = val[ind] + f(ind,W-wt[ind],val,wt);
	        }return dp[ind][W]=Math.max(take,nottake);
	    }
	    static int ff(int W, int[] val,int[] wt){
	        int n = wt.length;
	        int dp[][] = new int[n][W+1];
	        for(int[] rows:dp) Arrays.fill(rows,0);
	        
	        for(int w=0;w<=W;w++){
	            dp[0][w]=((int)(w/wt[0]))*val[0];
	        }
	        
	        for(int ind=1;ind<n;ind++){
	            for(int w=0;w<=W;w++){
	                int nottake = 0 + dp[ind-1][w];
	                int take = 0;
	                if(wt[ind]<=w){
	                    take = val[ind] + dp[ind][w-wt[ind]];
	                }dp[ind][w]=Math.max(take,nottake);
	            }
	        }return dp[n-1][W];
	    }
	    static int fff(int W, int[] val,int[] wt){
	        int n = wt.length;
	        int prev[] = new int[W+1];
	        int cur[] = new int[W+1];
	        //for(int[] rows:dp) Arrays.fill(rows,0);
	        
	        for(int w=0;w<=W;w++){
	            prev[w]=((int)(w/wt[0]))*val[0];
	        }
	        
	        for(int ind=1;ind<n;ind++){
	            for(int w=0;w<=W;w++){
	                int nottake = 0 + prev[w];
	                int take = 0;
	                if(wt[ind]<=w){
	                    take = val[ind] + cur[w-wt[ind]];
	                }cur[w]=Math.max(take,nottake);
	            }prev = cur;
	        }return prev[W];
	    }
	    static int ffff(int W, int[] val,int[] wt){
	        int n = wt.length;
	        int prev[] = new int[W+1];
	        //int cur[] = new int[W+1];
	        //for(int[] rows:dp) Arrays.fill(rows,0);
	        
	        for(int w=0;w<=W;w++){
	            prev[w]=((int)(w/wt[0]))*val[0];
	        }
	        
	        for(int ind=1;ind<n;ind++){
	            for(int w=0;w<=W;w++){
	                int nottake = 0 + prev[w];
	                int take = 0;
	                if(wt[ind]<=w){
	                    take = val[ind] + prev[w-wt[ind]];
	                }prev[w]=Math.max(take,nottake);
	            }
	        }return prev[W];
	    }
}
