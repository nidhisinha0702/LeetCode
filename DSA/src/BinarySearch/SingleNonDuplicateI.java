package BinarySearch;

public class SingleNonDuplicateI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,2,3,3,4,4,8,8};
		int ans = singleNonDuplicate(arr);
		System.out.println("The single element is :"+ans);
		
	}
	public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        //if the size of the array is 1
        if(n == 1) return nums[0];
        //for 0 and n-1 indexes avoid unnecessary edge cases
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        int low = 1;
        int high = n-2;
        //basic binary search
        while(low<=high){
            int mid = (low + high)/2;
            //if previous element and the next element are different then its the single element
            if((nums[mid] != nums[mid - 1]) && 
            (nums[mid]!= nums[mid + 1]))
                return nums[mid];
            //if I am standing on the left then the element is on the right 
            //so eliminate the left
            if((mid % 2 == 1 && nums[mid] ==nums[mid - 1])||
              (mid % 2 == 0 && nums[mid]== nums[mid + 1])){
                low = mid + 1;
            }
            else{
                //I am on the right half and my element is on the left half
                high = mid - 1;
            }
        }return -1;
    }

}
