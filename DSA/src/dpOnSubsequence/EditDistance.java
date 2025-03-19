package dpOnSubsequence;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "horse";
		String word2 = "ros";
		System.out.println("Minimum number of operation needed to convert string 1 to string 2 is : "+minDistanceSpaceOptimization(word1, word2));
	}

	/*
	 * public int minDistance(String word1, String word2) { int n = word1.length();
	 * int m = word2.length(); return f(n-1,m-1,word1,word2); }
	 */
	//0 base indexing
    private static int f(int i, int j, String s1, String s2){
        //base case
        //if s1 exhaust
        if(i<0) return j+1;
        if(j<0) return i+1;
        //explore all possibility
        //if the character matches
        if(s1.charAt(i) == s2.charAt(j)) 
        //no operation needed simply move the pointer
         return  f(i-1,j-1,s1,s2);
        //if not matches we have three operation insert, delete, replace
        return 1 + Math.min(f(i,j-1,s1,s2), Math.min(f(i-1,j,s1,s2),f(i-1,j-1,s1,s2)));
    }
    //1 base indexing
    private static int ff(int i, int j, String s1, String s2){
        //base case
        //if s1 exhaust
        if(i==0) return j;
        if(j==0) return i;
        //explore all possibility
        //if the character matches
        if(s1.charAt(i-1) == s2.charAt(j-1)) 
        //no operation needed simply move the pointer
         return  f(i-1,j-1,s1,s2);
        //if not matches we have three operation insert, delete, replace
        return 1 + Math.min(f(i,j-1,s1,s2), Math.min(f(i-1,j,s1,s2),f(i-1,j-1,s1,s2)));
    }
    
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[] : dp) Arrays.fill(row,-1);
        return fMemoization(n,m,word1,word2,dp);
    }
    private static int fMemoization(int i, int j, String s1, String s2, int dp[][]){
        //base case
        //if s1 exhaust
        if(i==0) return j;
        if(j==0) return i;
        //explore all possibility
        //memoization
        if(dp[i][j] != -1) return dp[i][j];
        //if the character matches
        if(s1.charAt(i-1) == s2.charAt(j-1)) 
        //no operation needed simply move the pointer
         return  dp[i][j] = fMemoization(i-1,j-1,s1,s2,dp);
        //if not matches we have three operation insert, delete, replace
        return dp[i][j] = 1 + Math.min(fMemoization(i,j-1,s1,s2,dp), Math.min(fMemoization(i-1,j,s1,s2,dp),fMemoization(i-1,j-1,s1,s2,dp)));
    }
    public static int minDistanceTabulation(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[] : dp) Arrays.fill(row,0);

        //base case
        for(int j=0;j<=m;j++) dp[0][j] = j;
        for(int i=0;i<=n;i++) dp[i][0] = i;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                 if(word1.charAt(i-1) == word2.charAt(j-1)) 
                //no operation needed simply move the pointer
                  dp[i][j] = dp[i-1][j-1];
                else
                //if not matches we have three operation insert, delete, replace
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1]));
            }
        }
        return dp[n][m];
    }
    public static int minDistanceSpaceOptimization(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int prev[] = new int[m+1];
        
        Arrays.fill(prev,0);
        //base case
        for(int j=0;j<=m;j++) prev[j] = j;
        //for(int i=0;i<=n;i++) cur[0] = i;

        for(int i=1;i<=n;i++){
        	int cur[] = new int[m+1];
            cur[0] = i;
            for(int j=1;j<=m;j++){
                 if(word1.charAt(i-1) == word2.charAt(j-1)) {
                //no operation needed simply move the pointer
                  cur[j] = prev[j-1];
                 }
                else{
                //if not matches we have three operation insert, delete, replace
                    cur[j] = 1 + Math.min(prev[j-1], Math.min(prev[j],cur[j-1]));
                }
            }prev=cur;
        }
        return prev[m];
    }
    
}
