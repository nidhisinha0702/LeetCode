package BinarySearch;

public class SearchRotatedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//search in a rotated array with duplicates
		int[] arr = new int[]{7,8,9,1,2,3,4,5,6};
		int n = arr.length;
		int target = 1;
		boolean ans = search(arr,n,target);
		if(ans)
			System.out.println("Target is present");
		else
			System.out.println("Target is not present");

	}
	private static boolean search(int[] nums,int n, int target) {
		int low = 0;
		int high = n-1;
		 while(low<=high){
	            int mid = (low+high)/2;
	            if(nums[mid] == target) return true;
	            //if low = mid = high the edge case for duplicate elements {3,1,2,3,3,3,3}
	            if(nums[low] == nums[mid] && nums[mid] == nums[high])
	            {
	                low = low + 1;
	                high = high - 1;
	                continue;
	            }

	            //if left half is sorted
	            if(nums[low]<=nums[mid]){
	                if(nums[low]<=target && target<=nums[mid])
	                    high = mid - 1;
	                else
	                    low = mid + 1;
	            }else{//right half is sorted
	                if(nums[mid]<=target && target<=nums[high])
	                    low = mid + 1;
	                else
	                    high = mid - 1;
	            }
	        }return false;
	}

}
