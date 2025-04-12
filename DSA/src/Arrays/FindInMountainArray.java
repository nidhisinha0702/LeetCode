package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,5,3,2,0};
		int target = 0;
		System.out.println("Idx is : "+findInMountainArray(target, arr));
		
	}
	 private static int findInMountainArray(int target, int[] mountainArr) {
	        int peakInd = peakInd(mountainArr);
	        int peak = peakInd(mountainArr);
	        //call binary search for left
	        int ans = binarySearch(0, peak, target, mountainArr, true);
	        
	        if(ans != -1) return ans;

	        //call binary search for right
	        ans = binarySearch(peak + 1, mountainArr.length-1, target, mountainArr, false);
	        return ans;
	    }
	 private static int binarySearch(int low, int high, int target, int[] mountainArr, boolean isAsc){
	        while(low<=high){
	            int mid = low + (high-low)/2;
	            int midVal = mountainArr[mid];
	            if(midVal == target){
	                return mid;
	            }else if(midVal>target){
	                if(isAsc)
	                high = mid - 1;
	                else
	                low = mid + 1;
	            }else{
	                if(isAsc)
	                low = mid + 1;
	                else
	                high = mid - 1;
	            }
	        }return -1;
	    }
	    private static int peakInd(int[] mountainArr){
	        int n = mountainArr.length;
	        int low = 1;
	        int high = n-2;
	        while(low<=high){
	            int mid = low + (high-low)/2;
	            int midVal = mountainArr[mid];
	            int midPlusOne = mountainArr[mid+1];
	            int midMinusOne = mountainArr[mid-1];
	            if((midMinusOne < midVal) &&
	               (midVal > midPlusOne) ){
	                return mid;
	            }else if(midVal < midPlusOne){
	                low = mid + 1;
	            }else{
	                high = mid - 1;
	            }
	        }return -1;
	    }
	 
}
