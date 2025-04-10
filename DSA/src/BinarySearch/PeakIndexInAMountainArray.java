package BinarySearch;

public class PeakIndexInAMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1,0};
		System.out.println("Print the peak index in a mountain array : "+peakIndexInMountainArray(arr));

	}
	 private static int peakIndexInMountainArray(int[] arr) {
	       int low = 0;
	       int high = arr.length-1;
	       int ans = arr.length;
	       while(low<=high){
	        int mid = low + (high-low)/2;
	        if(arr[mid]>arr[mid+1]){
	            ans=mid;
	            high=mid-1;
	        }else{
	            low=mid+1;
	        }
	       }return ans;
	    }
}
