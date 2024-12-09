package BinarySearch;

public class FindPeakElementI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,1};
		int ans = findPeakElement(arr);
		System.out.println("The peak element is :"+ans);

	}
	
	 public static int findPeakElement(int[] nums) {
	        int n = nums.length;
	        if(n == 1) return 0;
	        if(nums[0]>nums[1]) return 0;
	        if(nums[n-1]>nums[n-2]) return n-1;
	        //keep low and high from 1 to n-2
	        int low = 1;
	        int high = n-2;

	        while(low<=high){
	            int mid = (low + high)/2;
	            //if the mid is greater than mid - 1 and mid + 1
	            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
	                return mid;
	            //increasing slope peak is on right
	            else if(nums[mid] > nums[mid - 1])
	                low = mid + 1;
	            else
	            //decreasing slope peak is on the left
	                high = mid - 1;

	        }return -1;
	    }

}
