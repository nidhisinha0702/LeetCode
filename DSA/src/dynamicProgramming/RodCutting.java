package dynamicProgramming;

import java.util.Arrays;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price= {1,5,8,9,10,17,17,20};
		System.out.println("The maximum profit that can be obtained by cuting the rod is : "+cutRod(price));

	}
	 private static int cutRod(int[] price) {
	        // code here
		 int n = price.length;
	        
	        int dp[][] = new int[n][n+1];
	        for(int a[]:dp)Arrays.fill(a,0);
	        return ffff(n,price);
	    }
	    private static int f(int ind,int N,int[] arr,int dp[][]){
	        
	        if(ind == 0){
	            return N * arr[0];
	        }
	        if(dp[ind][N] != -1) return dp[ind][N];
	        int nottake = 0 + f(ind-1,N,arr,dp);
	        int take = Integer.MIN_VALUE;
	        int rodLength=ind+1;
	        if(rodLength <= N) take = arr[ind] + f(ind, N-rodLength,arr,dp);
	        return dp[ind][N] = Math.max(take,nottake);
	    }
	    private static int ff(int n,int price[],int dp[][]){
	        for(int N=0;N<=n;N++){
	            dp[0][N]=N*price[0];
	        }
	        
	        for(int ind=1;ind<n;ind++){
	            for(int N=0;N<=n;N++){
	                int nottake = 0 + dp[ind-1][N];
	                int take = Integer.MIN_VALUE;
	                int rodLength=ind+1;
	                if(rodLength <= N) take = price[ind] + dp[ind][N-rodLength];
	                dp[ind][N] = Math.max(take,nottake);
	            }
	        }
	        return dp[n-1][n];
	    }
	    
	    private static int fff(int n,int price[]){
	        int prev[] = new int[n+1];
	        Arrays.fill(prev,0);
	        int cur[] = new int[n+1];
	        Arrays.fill(cur,0);
	        
	        for(int N=0;N<=n;N++){
	            prev[N]=N*price[0];
	        }
	        
	        for(int ind=1;ind<n;ind++){
	            for(int N=0;N<=n;N++){
	                int nottake = 0 + prev[N];
	                int take = Integer.MIN_VALUE;
	                int rodLength=ind+1;
	                if(rodLength <= N) take = price[ind] + cur[N-rodLength];
	                cur[N] = Math.max(take,nottake);
	            }prev=cur;
	        }
	        return prev[n];
	    }
	    
	    private static int ffff(int n,int price[]){
	        int prev[] = new int[n+1];
	        Arrays.fill(prev,0);
	        
	        for(int N=0;N<=n;N++){
	            prev[N]=N*price[0];
	        }
	        
	        for(int ind=1;ind<n;ind++){
	            for(int N=0;N<=n;N++){
	                int nottake = 0 + prev[N];
	                int take = Integer.MIN_VALUE;
	                int rodLength=ind+1;
	                if(rodLength <= N) take = price[ind] + prev[N-rodLength];
	                prev[N] = Math.max(take,nottake);
	            }
	        }
	        return prev[n];
	    }
}
