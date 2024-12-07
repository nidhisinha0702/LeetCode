package BinarySearch;

public class MinimumRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//array with no duplicates
		int[] arr = new int[]{7,8,9,1,2,3,4,5,6};
		int n = arr.length;
		int ans = search(arr,n);
		if(ans == Integer.MAX_VALUE)
			System.out.println("There is no minimum present:" +ans);
		else
			System.out.println("There is minimum present:" +ans);

	}
	
	private static int search(int[] nums,int n) {
		int ans = Integer.MAX_VALUE;
		int low = 0;
		int high = n-1;
		 while(low<=high){
	            int mid = (low+high)/2;
	     //if both half are sorted
	            if(nums[low]<=nums[high]) {
	            	ans = Math.min(ans, nums[low]);
	            	break;
	            }
	     //if left half is sorted
	            if(nums[low]<=nums[mid]) {
	            	ans = Math.min(ans, nums[low]);
	            	low = mid + 1;
	            }else {
	            	//right half is sorted
	            	ans = Math.min(ans, nums[mid]);
	            	high = mid - 1;
	            }
		 }return ans;

	}
}
