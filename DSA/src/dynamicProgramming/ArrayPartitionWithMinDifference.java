package dynamicProgramming;

public class ArrayPartitionWithMinDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,3,4};
		int n = 4;
		System.out.println("The abolute minimum difference of subset sums are ::"+minSubsetSumDifference(nums, n));

	}
	
	 public static int minSubsetSumDifference(int []nums, int n) {
	        int totSum = 0;
	        for(int i=0;i<n;i++){
	            totSum += nums[i];
	        }
	        boolean dp[][] = new boolean[n][totSum+1];
	       
	        for(int i=0;i<n;i++) dp[i][0] = true;
	        if(nums[0]<=totSum)
	        dp[0][nums[0]] = true;

	        for(int ind=1;ind<n;ind++){
	            for(int target=1;target<=totSum;target++){
	                boolean nottake = dp[ind-1][target];
	                boolean take =false;
	                if(nums[ind]<=target) take = dp[ind -1][target-nums[ind]];
	                dp[ind][target] = take || nottake;
	            }
	        }
	        //dp[n-1][col->0...totSum]
	        int mini = (int)1e9;
	        for(int i=0;i<=totSum/2;i++){
	            if(dp[n-1][i] == true){
	                int s1=i;
	                int s2=totSum-i;
	                mini = Math.min(mini,Math.abs(s1-s2));
	            }
	        }return mini;
	    }
}
