package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithKDifferentIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,1,2,3};
		int k = 2;
		System.out.println("The number of subarrays formed with k distinct integers are : "+subarraysWithKDistinct(arr,k));
	}
	 private static int subarraysWithKDistinct(int[] nums, int k) {
	       return subarrayWithLessThanEqualKDistinct(nums,k) - subarrayWithLessThanEqualKDistinct(nums,k-1);
	    }
	 private static int subarrayWithLessThanEqualKDistinct(int nums[], int k){
	        if(k<0) return 0;
	         int l = 0, r= 0, cnt = 0;
	        Map<Integer,Integer> mpp = new HashMap<>();
	        while(r<nums.length){
	            mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
	            while(mpp.size()>k){
	                mpp.put(nums[l],mpp.get(nums[l])-1);
	                if(mpp.get(nums[l])==0) mpp.remove(nums[l]);
	                l++;
	            }
	            if(mpp.size()<=k){
	                cnt += r-l+1;
	            }r++;
	        }return cnt;
	    }
}
