package dpOnSubsequence;

import java.util.Arrays;

public class DistinctSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println("The number of distinct subsequence t in s is : "+numDistinctSpaceOptimized(s,t));

	}
	private static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n][m];
        for(int row[]:dp) Arrays.fill(row,-1);
        return f(n-1,m-1,s,t,dp);
    }
    private static int f(int i,int j, String s, String t, int dp[][]){
        //base case
        if(j<0) return 1;//exhausted t means matched everything
        if(i<0) return 0;//exhausted s means still remaining t
        //explore all possibilities
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j))
        return dp[i][j]=f(i-1,j-1,s,t,dp)+f(i-1,j,s,t,dp);
        else
        return dp[i][j]=f(i-1,j,s,t,dp);
    }
    private static int numDistinctTabulation(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[]:dp) Arrays.fill(row,0);
        //write base case
        for(int i=0;i<=n;i++)
        dp[i][0]=1;
        for(int j=1;j<=m;j++)
        dp[0][j]=0;
        //changing parameter
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                //copy paste the recurrence
                if(s.charAt(i-1) == t.charAt(j-1))
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else
                dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][m];
    }
    private static int numDistinctSpaceOptimized(String s, String t) {
        int n = s.length();
        int m = t.length();
        int prev[] = new int[m+1]; Arrays.fill(prev,0);
        //write base case
        prev[0]=1;
    
        //changing parameter
        for(int i = 1;i<=n;i++){
            for(int j = m;j>=1;j--){//iterating in reverse order because we need either the prev or prev-1 so we can override the same prev[] from back
                //copy paste the recurrence
                if(s.charAt(i-1) == t.charAt(j-1))
                prev[j]=prev[j-1]+prev[j];
            }
        }
        return prev[m];
    }
}
