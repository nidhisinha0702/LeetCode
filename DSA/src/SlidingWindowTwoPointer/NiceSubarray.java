package SlidingWindowTwoPointer;

public class NiceSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,1,2,1,1};
		int k = 3;
		System.out.println(" The count of nice subarray if there are k odd numbers on it is : "+numberOfSubarrays(nums, k));
	}
	 private static int numberOfSubarrays(int[] nums, int k) {
	        return numberOfSubarraysEvenOdd(nums,k) - numberOfSubarraysEvenOdd(nums,k-1);
	    }
	    private static int numberOfSubarraysEvenOdd(int nums[], int goal){
	        if(goal < 0) return 0;
	        int l = 0, r = 0, sum = 0, cnt = 0;
	        //iterate over the array
	        while(r<nums.length){
	            //increase sum every time r moves and check its even/odd
	            sum += nums[r] % 2;
	            //if sum croses goal
	            while(sum>goal){
	                sum -= nums[l] % 2;
	                l++;
	            }
	            //find the cnt of subarray i.e., length of the subarray
	            cnt += r-l+1;
	            r++;

	        }return cnt;
	    }
}
