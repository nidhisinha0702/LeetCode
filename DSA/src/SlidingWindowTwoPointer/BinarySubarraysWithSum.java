package SlidingWindowTwoPointer;

public class BinarySubarraysWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,0,0,1,1,0};
		int goal = 2;
		System.out.println("The binary subarray with sum goal is : "+numSubarraysWithSum(nums, goal));
	}
	private static int numSubarraysWithSum(int[] nums, int goal) {
        return subArrayWithSumLessAndEqual(nums,goal) - subArrayWithSumLessAndEqual(nums,goal-1);
    }
    private static int subArrayWithSumLessAndEqual(int[] nums, int goal){
        if(goal<0) return 0;
        int l = 0, r = 0, sum = 0, cnt = 0;
        while(r<nums.length){
            sum += nums[r];
            while(sum>goal){
                sum -= nums[l];
                l++;
            }
            cnt += r-l+1;
            r++;
        }return cnt;
    }
}
