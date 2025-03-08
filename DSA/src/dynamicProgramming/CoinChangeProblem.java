package dynamicProgramming;

import java.util.Arrays;

public class CoinChangeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = {1,2,5};
		int amount = 5;
		System.out.println("The number of combinations that make up the amount are : "+change(amount,coins));

	}
	private static int change(int amount, int[] coins) {
        return fff(amount,coins);
    }
    private static int f(int ind,int tar, int[] arr){
        //write recursion//convert into memoization(top-down)
        int n = arr.length;
        //initialize 2d dp array of size n and tar+1
        int dp[][] = new int[n][tar+1];
        //fill it with -1
        for(int i[]:dp) Arrays.fill(i,-1);
        //base case
        if(ind == 0){
            return (tar % arr[0] == 0) ? 1:0;
        }
        //return if the subproblem is already solved
        if(dp[ind][tar] != -1) return dp[ind][tar];
        //explore all ways
        int nottake = f(ind-1,tar,arr);
        int take = 0;
        if(arr[ind]<=tar) take = f(ind,tar-arr[ind],arr);
        //return sum
        return dp[ind][tar] = nottake + take;
    }
    private static int ff(int target, int[] arr){
        //base case
        int n = arr.length;
        int dp[][] = new int[n][target+1];
        for(int[] row:dp) Arrays.fill(row,0);

        for(int T=0;T<=target;T++)
            dp[0][T] = (T % arr[0] == 0)? 1:0;
        //bottom-up ind->1 to n-1 and target->0 to T
        for(int ind=1;ind<n;ind++){
            for(int tar=0;tar<=target;tar++){
                int nottake = dp[ind-1][tar];
                int take = 0;
                if(arr[ind]<=tar) take = dp[ind][tar-arr[ind]];
                //return sum
                dp[ind][tar] = nottake + take;
            }
        }
        return dp[n-1][target];
    }
    //space optimization
    private static int fff(int target, int[] arr){
        //base case
        int n = arr.length;
        //prev and curr
        int prev[] = new int[target+1];
        int cur[] = new int[target+1];

        for(int T=0;T<=target;T++)
            prev[T] = (T % arr[0] == 0)? 1:0;
        //bottom-up ind->1 to n-1 and target->0 to T
        for(int ind=1;ind<n;ind++){
            for(int tar=0;tar<=target;tar++){
                int nottake = prev[tar];
                int take = 0;
                if(arr[ind]<=tar) take = cur[tar-arr[ind]];
                //return sum
                cur[tar] = nottake + take;
            }prev=cur;
        }
        return prev[target];
    }
}
