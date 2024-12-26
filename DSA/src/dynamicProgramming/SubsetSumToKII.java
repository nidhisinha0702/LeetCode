package dynamicProgramming;

public class SubsetSumToKII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;
        System.out.println("The subset sum is equal to k::"+subsetSumToKK(n,k,arr));
	}
	public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean dp[][] = new boolean[n][k+1];
       
        for(int i=0;i<n;i++) dp[i][0] = true;
        if(arr[0]<=k)
        dp[0][arr[0]] = true;

        for(int ind=1;ind<n;ind++){
            for(int target=1;target<=k;target++){
                boolean nottake = dp[ind-1][target];
                boolean take =false;
                if(arr[ind]<=target) take = dp[ind -1][target-arr[ind]];
                dp[ind][target] = take || nottake;
            }
        }
        return dp[n-1][k];
    }
	//space ->O(k)
	 public static boolean subsetSumToKK(int n, int k, int arr[]){
	        // Write your code here.
	        boolean prev[] = new boolean[k+1];
	        prev[0] = true;
	        
	        if(arr[0]<=k)
	        prev[arr[0]] = true;

	        for(int ind=1;ind<n;ind++){
	            boolean cur[] = new boolean[k+1];
	            cur[0] = true;
	            for(int target=1;target<=k;target++){
	                boolean nottake = prev[target];
	                boolean take =false;
	                if(arr[ind]<=target) take = prev[target-arr[ind]];
	                cur[target] = take || nottake;
	            }prev = cur;
	        }
	        return prev[k];
	    }

}
