package dpOnLIS;

public class LongestBitonicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,1,1,5,6,2,3,1};
		int n = 8;
		System.out.println("Print the length of longest bitonic subsequence is : "+LongestBitonicSequence(n, nums));
	}
	 public static int LongestBitonicSequence(int n, int[] nums) {
	        // code here
	        //the idea is to find the LIS(from left) and LIS(from right)
	        //create a dp of size n
	        int dpl[] = new int[n];
	        int dpr[] = new int[n];
	        
	        //iterate and fill the dpl with the values for left
	        for(int i=0;i<n;i++){
	            dpl[i]=1;
	            for(int j=0;j<i;j++){
	                if(nums[i]>nums[j] && (1+dpl[j]>dpl[i])){
	                    dpl[i]=1+dpl[j];
	                }
	            }
	        }
	        
	        //iterate and fill the dpr with the values for right
	        for(int i=n-1;i>=0;i--){
	            dpr[i]=1;
	            for(int j=n-1;j>i;j--){
	                if(nums[i]>nums[j] && (1+dpr[j]>dpr[i])){
	                    dpr[i]=1+dpr[j];
	                }
	            }
	        }
	        
	        int maxi = 0;
	        //now compare the if they are strictly inc or dec
	        for(int i=0;i<n;i++){
	            if(dpl[i]>1 && dpr[i]>1){
	                maxi = Math.max(maxi, dpl[i]+dpr[i]-1);
	            }
	        }
	        return maxi;
	    }
}
