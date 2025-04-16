package Arrays;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {3,4,5,6}, target=7;
		int[] ans = twoSum(nums, target);
		for(int a:ans)
			System.out.print(a+" ");
	}
	private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(mpp.containsKey(target-nums[i])){
                int val = mpp.get(target-nums[i]);
                return new int[]{val,i};
            }mpp.put(nums[i],i);
        }return new int[]{-1,-1};
    }
}
