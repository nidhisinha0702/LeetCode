package dpOnLIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {4,8,10,240};
		List<Integer> ans = largestDivisibleSubset(nums);
		System.out.println(ans);

	}
	 private static List<Integer> largestDivisibleSubset(int[] nums) {
	        int n = nums.length;
	        int hash[] = new int[n];
	        Arrays.fill(hash,1);
	        int maxi=-1;
	        int lastInd=-1;
	        int dp[] = new int[n];
	        Arrays.fill(dp,1);
	        //sort the array
	        Arrays.sort(nums);
	        for(int i = 0;i<n;i++){
	            hash[i] = i;
	            for(int prev=0;prev<i;prev++){
	                if(nums[i] % nums[prev] == 0 && dp[i] < 1 + dp[prev]){
	                    dp[i] = 1 + dp[prev];
	                    hash[i] = prev;
	                }
	            }
	        }

	        for(int i=0;i<n;i++){
	             if(dp[i]>maxi){
	                maxi = dp[i];
	                lastInd = i;
	            }
	        }

	        ArrayList<Integer> ans = new ArrayList<>();
	        ans.add(nums[lastInd]);
	        while(hash[lastInd]!= lastInd){
	            lastInd = hash[lastInd];
	            ans.add(nums[lastInd]);
	        }
	        Collections.reverse(ans);
	        return ans;
	    }
}
