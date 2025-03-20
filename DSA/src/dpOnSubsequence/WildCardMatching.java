package dpOnSubsequence;

import java.util.Arrays;

public class WildCardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "*a?b*";
		String s2 = "zacabz";
		System.out.println("Wildcard pattern matching is : "+isMatchSpaceOptimization(s2,s1));

	}
	private static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int dp[][] = new int[n+1][m+1];
        for(int rows[]:dp)
        Arrays.fill(rows,-1);
        return ff(n,m,s,p,dp);
        //return f(n-1,m-1,s,p);
    }
    private static boolean f(int i, int j, String s1, String s2){
        //base case (s1 exhaust or s2 exhaust)
        if(i<0 && j<0) return true; 
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0) {
            for(int ind=0;ind<=i;ind++){
                if(s1.charAt(ind) != '*')
                    return false;
            }return true;
        }  
        //explore all possibilities
        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?')
            return f(i-1,j-1,s1,s2);
        //i can match any number of character with *
        if(s1.charAt(i) == '*')
            return f(i-1,j,s1,s2) | f(i,j-1,s1,s2);
        //if char not matching
        return false;
    }
    //Memoization
    private static boolean ff(int i, int j, String s1, String s2,int dp[][]){
        //base case (s1 exhaust or s2 exhaust)
        if(i==0 && j==0) return true; 
        if(i==0 && j>0) return false;
        if(j==0 && i>0) {
            for(int ind=1;ind<=i;ind++){
                if(s1.charAt(ind-1) != '*')
                    return false;
            }return true;
        }  
        if(dp[i][j] != -1) return dp[i][j] == 1;
        //explore all possibilities
        if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?') {
             dp[i][j] = (ff(i-1,j-1,s1,s2,dp) == true) ? 1:0;
        	return dp[i][j]==1;
        }
        //i can match any number of character with *
        if(s1.charAt(i-1) == '*') {
             dp[i][j] = ff(i-1,j,s1,s2,dp) || ff(i,j-1,s1,s2,dp) ? 1:0;
        	 return dp[i][j] == 1;
        }
        //if char not matching
        return false;
    }
    public static boolean fffTabulation(String s, String p) {
        int n = p.length();
        int m = s.length();
        boolean dp[][] = new boolean[n+1][m+1];
        for(boolean rows[]:dp)
        Arrays.fill(rows,false);
        //Tabulation
        dp[0][0]=true;
        for(int j = 1;j<=m;j++){
            dp[0][j]=false;
        }
        for(int i = 1;i<=n;i++){
            boolean flag = true;
            for(int ind=1;ind<=i;ind++){
                if(p.charAt(ind-1) != '*')
                    flag = false;
                    break;
            } dp[i][0]=flag;
        }
       
        //changing parameters
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                //i can match any number of character with *
                else if(p.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
                }
                //if char not matching
                else dp[i][j] = false;
            }
        }
        return dp[n][m];
    }
    private static boolean isMatchSpaceOptimization(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean prev[] = new boolean[m+1];
        Arrays.fill(prev,false);
        //Tabulation
        prev[0]=true; //zeroth row
        for(int j = 1;j<=m;j++){
            prev[j]=false;
        }
        //changing parameters
        for(int i=1;i<=n;i++){
            boolean cur[] = new boolean[m+1];
            boolean flag = true;
            for(int ind=1;ind<=i;ind++){
                if(p.charAt(ind-1) != '*')
                    flag = false;
                    break;
            }//for every row
            // you are assigning the 0th columns value
            cur[0]=flag;
            for(int j=1;j<=m;j++){
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?'){
                    cur[j] = prev[j-1];
                }
                //i can match any number of character with *
                else if(p.charAt(j-1) == '*'){
                    cur[j] = prev[j] | cur[j-1];
                }
                //if char not matching
                else cur[j] = false;
            }prev=cur;
        }
        return prev[m];
    }
}
