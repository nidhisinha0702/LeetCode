package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BottomUp {
	private static final long mod = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number for fibonacci::");
		int n = sc.nextInt();
		long ans = bottomUp(n);
		System.out.println("The fibonacci number is:  "+ans);
		
	}
	private static long bottomUp(int n) {
        // code here
        long dp[] = new long[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;dp[1]=1;
        
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]%mod+dp[i-2]%mod)%mod;
        }
        return dp[n];
    }
}
