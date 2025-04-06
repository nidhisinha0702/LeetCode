package dpOnSubsequence;
//palindrome revolves around center
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bswrhxboawtdfqggqfdtwyypwnssnwpyyaobxhrwsb";
		System.out.println("The longest palindromic string is : "+longestPalindrome(s));

	}
	private static String longestPalindrome(String s) {
		//check the boundary conditions
		if(s==null || s.length()<1) return "";
		
		//to track the indices of the start and end for the string
		int start=0,end=0;
		//iterate through each character
		for(int i=0;i<s.length();i++) {
			int len1 = expandAroundCenter(s,i,i);//odd length
			int len2 = expandAroundCenter(s,i,i+1);//even length
			int len = Math.max(len1, len2);
			
			if(len>end-start) {
				start = i-(len-1)/2;//update the start
				end = i + (len)/2; //update the end
			}
		}
		
		return s.substring(start,end+1);
	}
	
	private static int expandAroundCenter(String s, int left, int right) {
		while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right-left -1; //length of the palindrome
	}
}
