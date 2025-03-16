package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer arr[] = {13, 3, 10, 2, 8, 9, 10, 9, 4, 16,3, 2, 11, 1, 9,17, 10};
		System.out.println("The longest subarray with two distinct integers is : "+totalElements(arr));

	}
	 public static int totalElements(Integer[] arr) {
	        // code here
	        //apply sliding window and two pointer
	        int l = 0,r = 0, maxLen = 0;
	        Map<Integer,Integer> mpp = new HashMap<>();
	        while(r<arr.length){
	            //add element into the map
	        	mpp.put(arr[r], mpp.getOrDefault(arr[r], 0)+1);
	            
	            //check if the size is greater than 2
	            if(mpp.size() > 2){
	            	int value = mpp.get(arr[l])-1;
                	mpp.put(arr[l],value);
	                if(mpp.get(arr[l]) == 0) mpp.remove(arr[l]);
	                l++;
	            }
	            
	            //if the size if under the range
	            if(mpp.size()<=2){
	                maxLen = Math.max(maxLen,r-l+1);
	            }
	            //increase r
	            r++;
	        }return maxLen;
	    }
}
