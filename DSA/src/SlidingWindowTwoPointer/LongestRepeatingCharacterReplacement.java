package SlidingWindowTwoPointer;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AABABBA";
		int k = 1;
		System.out.println("The longest repeating character replacement length is : "+characterReplacement(s, k));

	}
	private static int characterReplacement(String s, int k) {
        int l = 0,r = 0, maxLen = 0, maxFreq = 0;
        int hash[] = new int[26];
        Arrays.fill(hash,0);
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,hash[s.charAt(r)-'A']);
            if(((r-l+1)-maxFreq) > k){
                hash[s.charAt(l)-'A']--;
                maxFreq=0;
                l++;
            }
            if((r-l+1)-maxFreq <= k)
                maxLen = Math.max(maxLen,r-l+1);
            r++;
        }return maxLen;
    }
}
