package dynamicProgramming;
//There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.
//For Example
//If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.

import java.util.Arrays;

public class FrogJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,20, 30, 10};
		int n = 4;
		int ans = frogJump(n,arr);
		System.out.println("the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair:"+ans);

	}
	 private static int frogJump(int n, int heights[]) {
	        int[] dp = new int[n+1];
	        Arrays.fill(dp,-1);
	        return f(n-1,heights,dp);

	    }
	 //Here the approach is recursion and memoization(top-down approach)
	    private static int f(int ind, int heights[],int[] dp){
	        if(ind == 0) return 0;
	        if(dp[ind]!=-1) return dp[ind];
	        int left = f(ind - 1,heights,dp) + Math.abs(heights[ind] - heights[ind-1]);
	        int right = Integer.MAX_VALUE;
	        if(ind > 1)
	        right = f(ind - 2,heights,dp) + Math.abs(heights[ind] - heights[ind-2]);
	        return dp[ind]=Math.min(left,right);

	    }

}
