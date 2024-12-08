package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//{3,4,5,1,2} original array={1,2,3,4,5} -> {5,1,2,3,4} (1st rotation) ->{4,5,1,2,3} (2nd Rotation)->{3,4,5,1,2} (3rd rotation)
		//index of minimum element will give us how many times the array is rotated min=1,ind=3;
		List<Integer> list = new ArrayList<>(Arrays.asList(3,4,5,1,2));
		int ans = findKRotation(list);
		System.out.println("The array is rotated by "+ans+" times.");
		

	}
	 public static int findKRotation(List<Integer> arr) {
	        // Code here
	        int n = arr.size();
	        int ans = Integer.MAX_VALUE;
			int low = 0;
			int high = n-1;
			int ind = -1;
			 while(low<=high){
		            int mid = (low+high)/2;
		     //if both half are sorted
		            if(arr.get(low)<=arr.get(high)) {
		                if(arr.get(low)<ans){
		                ind= low;
		            	ans = arr.get(low);
		                }
		            	break;
		            }
		     //if left half is sorted
		            if(arr.get(low)<=arr.get(mid)) {
		             if(arr.get(low)<ans){
		                 ind=low;
		                 ans=arr.get(low);
		             }
		            	low = mid + 1;
		            }else {
		            	//right half is sorted
		            	high = mid - 1;
		            	if(arr.get(mid)<ans){
		            	    ind=mid;
		            	    ans=arr.get(mid);
		            	}
		            }
			 }return ind;

	    }

}
