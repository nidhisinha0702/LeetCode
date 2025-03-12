package SlidingWindowTwoPointer;

import java.util.Arrays;

public class LongestSubstringNoRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcbb";
		System.out.println("The longest substring without repeating characters is of length : "+lengthOfLongestSubstring(s));

	}
	 private static int lengthOfLongestSubstring(String s) {
	        int n = s.length();
	        int hash[] = new int[256];
	        Arrays.fill(hash,-1);
	        int l = 0,r = 0;
	        int maxLen = 0;
	        while(r<n){
	        	//java implicitly converts s.charAt(r) into its ASCII integer equivalent making it valid index in the hash array
	            if(hash[s.charAt(r)] != -1)//if in the map
	            {
	                if(hash[s.charAt(r)] >= l){
	                    l = hash[s.charAt(r)] + 1;
	                }
	            }
	            int len = r - l + 1; //find the length of the substring
	            maxLen = Math.max(len,maxLen); // find the max
	            hash[s.charAt(r)] = r; // update the map with the current index value
	            r++;
	        }return maxLen;
	    }
}
