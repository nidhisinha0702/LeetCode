package dpOnSubsequence;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ABCDGH", s2 = "ACDGHR";
		System.out.println("The longest common substring length is : "+spaceOptimized(s1, s2));
	}
	 private static int longestCommonSubstr(String s1, String s2) {
	        // code here
	        int n = s1.length();
	        int m = s2.length();
	        
	        int dp[][] = new int[n+1][m+1];
	        //base case
	        for(int i=0;i<=n;i++) dp[i][0]=0;
	        for(int j=0;j<=m;j++) dp[0][j]=0;
	        
	        int ans = 0;
	        
	        for(int i=1;i<=n;i++){
	            for(int j=1;j<=m;j++){
	                if(s1.charAt(i-1) == s2.charAt(j-1)) {
	                    dp[i][j] = 1 + dp[i-1][j-1];
	                    ans = Math.max(dp[i][j],ans);
	                }
	                else    dp[i][j] = 0;
	            }
	        }return ans;
	    }
	 private static int spaceOptimized(String s1, String s2) {
	        // code here
	        int n = s1.length();
	        int m = s2.length();
	        
	        int prev[] = new int[m+1];
	        
	        int ans = 0;
	        
	        for(int i=1;i<=n;i++){
	            int cur[] = new int[m+1];
	            for(int j=1;j<=m;j++){
	                if(s1.charAt(i-1) == s2.charAt(j-1)) {
	                    cur[j] = 1 + prev[j-1];
	                    ans = Math.max(cur[j],ans);
	                }
	                else    cur[j] = 0;
	            }prev=cur;
	        }return ans;
	    }
}
