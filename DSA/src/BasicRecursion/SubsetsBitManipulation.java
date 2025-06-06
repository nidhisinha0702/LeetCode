
package BasicRecursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsBitManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,3};
		List<List<Integer>> ans = subsets(nums);
		System.out.println("The subsets are::"+ans);

	}
	private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;//there will be total of 2^n subsets
        for(int num=0;num<(1<<n);num++){//bits will be from 0 to 1<<n - 1
            List<Integer> sub = new ArrayList<>();
            for(int i = 0;i<n;i++){//iterate over the array elements
                if((num & (1 << i)) != 0){ // this will do an and operation on array elements with bits to give set or not set
                    sub.add(nums[i]);
                }
            }ans.add(sub);
        }return ans;
    }

}
