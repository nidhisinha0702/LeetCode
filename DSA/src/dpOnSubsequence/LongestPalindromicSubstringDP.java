package dpOnSubsequence;

import java.util.Arrays;

public class LongestPalindromicSubstringDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "forgeeksskeegfor";
		System.out.println("The logest palindrome substring is : "+longestPalindrome(s));
	}
	
	 private static String longestPalindrome(String s) {
		 if(s==null || s.length()<1) return "";
	       
	       String ans="";
	       
	       for(int i=0;i<s.length();i++){
	           String te = expandCenter(s,i,i+1);
	           if(te.length()>ans.length()) ans = te;
	           String to = expandCenter(s,i,i);
	           if(to.length()>ans.length()) ans = to;
	       }
	       return ans;
	    }
	    
	    private static String expandCenter(String s, int left, int right){
	        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
	            left--;
	            right++;
	        }
	        return s.substring(left+1,right);
	    }
	 
	    

}
