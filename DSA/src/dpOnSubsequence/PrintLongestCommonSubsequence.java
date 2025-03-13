package dpOnSubsequence;

import java.util.Arrays;

public class PrintLongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcde";
		String t = "bdgek";
		System.out.println("The LCS string is : "+printLCSubsequence(s, t));

	}
	private static String printLCSubsequence(String text1, String text2){
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
	    int len = dp[n][m];
	    String str = "";
		for(int i=0;i<len;i++) {
			str += '$'; 
		}
		StringBuilder ss = new StringBuilder(text1);
		StringBuilder str2 = new StringBuilder(str);
	    int ind = len - 1;
	    int i = n, j = m;
		    while(i>0 && j>0) {
		    	if(ss.charAt(i-1) == text2.charAt(j-1)) {
		    		str2.setCharAt(ind, ss.charAt(i-1));
		    		ind--;
		    		i--;
		    		j--;
		    		
		    	}else if(dp[i-1][j]>dp[i][j-1]) {
		    		i--;
		    	}else	j--;
		    }return str2.toString();
	}
}
