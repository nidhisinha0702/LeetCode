package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPeakElementII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList(Arrays.asList(1, 8, 1, 5, 3));
		int ans = findPeakElement(arr);
		System.out.println("The peak element is: "+ans);

	}
	 public static int findPeakElement(ArrayList<Integer> nums) {
	        // Write your code here.
	        int n = nums.size();
	        if(n == 1) return 0;
	        if(nums.get(0)>nums.get(1)) return 0;
	        if(nums.get(n-1)>nums.get(n-2)) return n-1;
	        //keep low and high from 1 to n-2
	        int low = 1;
	        int high = n-2;

	        while(low<=high){
	            int mid = (low + high)/2;
	            //if the mid is greater than mid - 1 and mid + 1
	            if(nums.get(mid) > nums.get(mid - 1) && nums.get(mid) > nums.get(mid + 1))
	                return mid;
	            //increasing slope peak is on right
	            else if(nums.get(mid) > nums.get(mid - 1))
	                low = mid + 1;
	            else
	            //decreasing slope peak is on the left
	                high = mid - 1;

	        }return -1;
	    }

}
