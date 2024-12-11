package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class TopDown {

	private static final long mod = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number for fibonacci::");
		int n = sc.nextInt();
		long ans = topDown(n);
		System.out.println("The fibonacci number is:  "+ans);
		

	}
	 static long topDown(int n) {
		 //BigInteger dp[] = new BigInteger[n+1];
		  long dp[] = new long[n+1];
	      Arrays.fill(dp,-1);
	      return func(n,dp);
	   }
	   
	   private static long func(int n, long[] dp){
	       if(n<=1) return n;
	       
	       if(dp[n]!= -1) return dp[n];
	       
	       long result= (func(n-1,dp)+func(n-2, dp))%mod;
	       dp[n] = result;
	       return result;
	   }

}
