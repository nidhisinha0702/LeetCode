package dynamicProgramming;

import java.util.Arrays;

public class PartitionsWithDifferencesII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,2,6,4};
		int n = arr.length;
		int d = 3;
		System.out.println("The number of susequences with given differences are: "+countPartitions(n,d,arr));


	}
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int totSum = 0;
		for(int a:arr){
			totSum += a;
		}
		if(totSum - d < 0 || ((totSum - d) % 2 == 1)) return 0;
		return findWays(arr,(totSum - d)/2);
		
	}
	public static int findWays(int num[], int tar) {
	        // Write your code here.
	        int n = num.length;
	        int dp[][]= new int[n][tar+1];
	        for(int[] rows:dp) Arrays.fill(rows,0);
	        
	        if(num[0] == 0) dp[0][0]=2;
			else dp[0][0]=1;
	        if(num[0] != 0 && num[0]<=tar) dp[0][num[0]] = 1;

	        for(int ind=1;ind<n;ind++){
	            for(int sum=0;sum<=tar;sum++){
	                int notpick = dp[ind-1][sum];
	                int pick = 0;
	                if(num[ind]<=sum) pick = dp[ind-1][sum-num[ind]];
	                dp[ind][sum] = (pick + notpick);
	            }
	        }
	        return dp[n-1][tar];
	    }
	//Space optimization
	public static int findWayss(int num[], int tar) {
        // Write your code here.
        int n = num.length;
        int prev[]= new int[tar+1];
        Arrays.fill(prev,0);
        
        if(num[0] == 0) prev[0]=2;
		else prev[0]=1;
        if(num[0] != 0 && num[0]<=tar) prev[num[0]] = 1;

        for(int ind=1;ind<n;ind++){
			int cur[]= new int[tar+1];
        Arrays.fill(cur,0);
            for(int sum=0;sum<=tar;sum++){
                int notpick = prev[sum];
                int pick = 0;
                if(num[ind]<=sum) pick = prev[sum-num[ind]];
                cur[sum] = (pick + notpick);
            }prev=cur;
        }
        return prev[tar];
    }
	 
}
