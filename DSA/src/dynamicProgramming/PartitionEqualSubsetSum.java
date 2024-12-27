package dynamicProgramming;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {1,5,11,5};
		System.out.println("The array can be parted in two equal halves::"+canPartition(nums));

	}
	 public static boolean canPartition(int[] nums) {
	        int totSum = 0;
	        for(int i=0;i<nums.length;i++){
	            totSum += nums[i];
	        }
	        if(totSum % 2 == 1) return false; // if odd then can not be parted into two halves
	        int target = totSum/2;
	        return subsetSumToKK(nums.length,target,nums);
	        
	    }
	 public static boolean subsetSumToKK(int n, int k, int arr[]){
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
