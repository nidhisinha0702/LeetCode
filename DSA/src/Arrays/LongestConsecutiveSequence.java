package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,20,4,10,3,4,5};
		System.out.println("The length of longest consecutive sequence is : "+longestConsecutive(nums));

	}
	private static int longestConsecutive(int[] nums) {
        //put everything in set
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int len = 0;
        for(int a:set){
            //check if the previous is not there in set
            if(!set.contains(a-1)){
                //count it
                int cnt = 1;
                //check next value is there by adding cnt
                while(set.contains(a+cnt)){
                    cnt++;
                }
                len = Math.max(cnt,len);
            }
        }return len;
    }
}
