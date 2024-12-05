package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MajorityElementII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Moore's voting algorithm
		int[] nums= {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
		int n = nums.length;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int cnt1 = 0,cnt2 = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        //find the candidate for voting
        for(int i = 0;i<n;i++){
            if(cnt1 == 0 && ele2 != nums[i]){
            	cnt1 = 1;
            	ele1 = nums[i];
                
            }else if(cnt2 == 0 && ele1 != nums[i]){
            	cnt2 = 1;
            	ele2 = nums[i];
                
            }
            else if(ele1 == nums[i]){
            	cnt1 += 1;
            }else if(ele2 == nums[i]){
            	cnt2 += 1;
            }else {
            	cnt1--;
            	cnt2--;
            }
        }
        //find the candidates are greater than n/3
        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0;i<n;i++) {
        	if(ele1 == nums[i]) cnt1++;
        	if(ele2 == nums[i]) cnt2++;
        }
        int mini = (int)n/3;
        if(cnt1>mini) ans.add(ele1);
        if(cnt2>mini) ans.add(ele2);
        Collections.sort(ans);
        System.out.println(ans);
	}

}
