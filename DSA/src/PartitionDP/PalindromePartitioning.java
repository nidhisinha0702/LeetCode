package PartitionDP;

import java.util.Arrays;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		System.out.println(" The minimum cuts needed for a palindrome partiotioning of s is : "+minCutTab(s));

	}
	 private static int minCut(String s) {
	        int dp[] = new int[s.length()];
	        Arrays.fill(dp,-1);
	        return f(0,s.length(), s, dp)-1;//doing a minus -1 for the last partition
	    }
	    private static int f(int i, int n, String s, int dp[]){
	        if(i==n) return 0;
	        if(dp[i] != -1) return dp[i];
	        int mini = Integer.MAX_VALUE;
	        for(int j=i;j<n;j++){
	            if(isPalindrome(i,j,s)){
	                int cost = 1 + f(j+1, n, s, dp);
	                mini = Math.min(mini, cost);
	            }
	        }return dp[i]=mini;
	    }

	    private static boolean isPalindrome(int i, int j, String s){
	        while(i<j){
	            if(s.charAt(i) != s.charAt(j))
	            return false;
	            i++;
	            j--;
	        }return true;
	    }
	    private static int minCutTab(String s) {
	        int n = s.length();
	        int dp[] = new int[n+1];
	        Arrays.fill(dp,0);
	        for(int i=n-1;i>=0;i--){//changing parameter
	            int mini = Integer.MAX_VALUE;//copy the recurrence
	            for(int j=i;j<n;j++){
	                if(isPalindrome(i,j,s)){
	                    int cost = 1 +dp[j+1];
	                    mini = Math.min(mini, cost);
	                }
	            } dp[i]=mini;
	        }
	        return dp[0]-1;//doing a minus -1 for the last partition
	    }
	    
}
