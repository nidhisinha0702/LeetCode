package dpOnSubsequence;

public class LongestCommonPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbabcbcab";
		System.out.println("The longest palindrome subsequence length is : "+longestPalindromeSubseq(s));

	}
	 private static int longestPalindromeSubseq(String s) {
	        StringBuilder sb = new StringBuilder(s);
	        String t = sb.reverse().toString();
	        return ffff(s,t);
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
