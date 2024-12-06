package BinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//search in a rotated array with no duplicates
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
		int n = 9,k = 1;
		int ans = search(arr,n,k);
		if(ans == -1)
			System.out.println("Target is not present");
		else
			System.out.println("Target is present");

	}
	private static int search(ArrayList<Integer> nums,int n, int k) {
		 int low = 0;
	        int high = n-1;
	        while(low<=high){
	            int mid = (low+high)/2;
	            if(nums.get(mid) == k) return mid;

	            //if left half is sorted
	            if(nums.get(low)<=nums.get(mid)){
	                if(nums.get(low)<=k && k<=nums.get(mid))
	                    high = mid - 1;
	                else
	                    low = mid + 1;
	            }else{//right hald is sorted
	                if(nums.get(mid)<=k && k<=nums.get(high))
	                    low = mid + 1;
	                else
	                    high = mid - 1;
	            }
	        }return -1;
	}

}
