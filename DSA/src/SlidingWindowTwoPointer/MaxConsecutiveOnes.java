package SlidingWindowTwoPointer;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		System.out.println("The maximum consecutive length ones is : "+longestOnes(nums,k));
	}
	private static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zeros = 0;
        int l = 0,r = 0; //left and right pointer
        int maxLen = 0;
        while(r<n){
            if(nums[r] == 0)    zeros++; //increase zeros count
            if(zeros > k){ //move left if zeros > k
                if(nums[l] == 0)    zeros--; //change zero if encoutered
                l++;
            }
            if(zeros <= k){
                int len = r-l+1; //calculate len
                maxLen = Math.max(len,maxLen); //calculate maxLen
            }
            r++;//increase r throughout
        }return maxLen;
    }
}
