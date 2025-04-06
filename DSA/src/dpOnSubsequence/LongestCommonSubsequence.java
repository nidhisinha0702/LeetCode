package dpOnSubsequence;

import java.util.Arrays;
//maintains the order in the string but not necessarily consecutive
//s="abc"->"","a","b","c","ab","ac","bc","abc"
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println("The longest common subsequence length is : "+longestCommonSubsequence(text1, text2));
		System.out.println("The longest common subsequence length is : "+fff(text1, text2));
		System.out.println("The longest common subsequence length is : "+ffff(text1, text2));

	}
	  private static int longestCommonSubsequence(String text1, String text2) {
	        int n = text1.length();
	        int m = text2.length();
	        //int dp[][] = new int[n][m];
	        int dp[][] = new int[n+1][m+1];
	        for(int[] rows:dp)
	        Arrays.fill(rows,-1);
	       // return f(n-1,m-1,text1,text2,dp);
	        return ff(n,m,text1,text2,dp);
	    }

	    private static int f(int i,int j, String s, String t,int dp[][]){
	        if(i <0 || j<0)
	            return 0;
	        if(dp[i][j] != -1) return dp[i][j];
	        if(s.charAt(i) == t.charAt(j))
	            return dp[i][j] = 1 + f(i-1,j-1,s,t,dp);
	        return dp[i][j] = Math.max(f(i-1,j,s,t,dp),f(i,j-1,s,t,dp));
	    }
	    //shifting of indexes in order to write tabulation
	    private static int ff(int i,int j,String s, String t,int dp[][]){
	        if(i == 0 || j == 0) return 0;

	        if(dp[i][j] != -1) return dp[i][j];
	        if(s.charAt(i-1) == t.charAt(j-1))
	            return dp[i][j] = 1 + ff(i-1,j-1,s,t,dp);
	        return dp[i][j] = Math.max(ff(i-1,j,s,t,dp),ff(i,j-1,s,t,dp));
	    }
	    private static int fff(String text1, String text2){
	    	int n = text1.length();
	        int m = text2.length();
	        int dp[][] = new int[n+1][m+1];
	        for(int[] rows:dp)
	        Arrays.fill(rows,0);
	        for(int j=0;j<=m;j++) dp[0][j]=0;
	        for(int i=0;i<=n;i++) dp[i][0]=0;

	        for(int i=1;i<=n;i++){
	            for(int j=1;j<=m;j++){
	                if(text1.charAt(i-1) == text2.charAt(j-1))
	                    dp[i][j] = 1 + dp[i-1][j-1];
	                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
	            }
	        }
	        return dp[n][m];
	    }
	    private static int ffff(String text1, String text2){
	    	 int n = text1.length();
	         int m = text2.length();
	         int prev[] = new int[m+1];
	        
	         for(int j=0;j<=m;j++) prev[j]=0;

	         for(int i=1;i<=n;i++){
	        	 int cur[] = new int[m+1];
	             for(int j=1;j<=m;j++){
	                 if(text1.charAt(i-1) == text2.charAt(j-1))
	                     cur[j] = 1 + prev[j-1];
	                 else cur[j] = Math.max(prev[j],cur[j-1]);
	             }prev = cur;
	         }
	         return prev[m];
	    }
	    
}
