package slidingWindow;

import java.util.Arrays;

public class MaxFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,4};
		int k = 5;
		int ans = maxFrequency(nums,k);
		System.out.println("The maximum most frequent element by performing k operation is :"+ans);

	}
	private static int maxFrequency(int[] nums, int k) {
		//as the input numbers are not sorted
        Arrays.sort(nums);
        int left = 0, ans = 0; long sum = 0;

        for(int right=0; right<nums.length;right++){
        	//calculate the sum of the window
           sum += nums[right];
           //check if the len*max number of that window which is current element is > sum + k
           if(((right - left + 1)*(long)nums[right]) > (sum + k)){
        	//reduce the window size and the sum as well.
            sum -= nums[left];
            left++;
           }
           //find the max by the len and prev max
           ans = Math.max(ans, right-left+1);
        }return ans;
    }

}
