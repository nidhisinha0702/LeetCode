package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 2;
		String s = "aaabbccd";
		System.out.println("Longest substring with at most k distinct character : "+subStringKCharctersOptimized(s, k));

	}
	private static int subStringKCharcters(String s, int k) {
		int maxLen = 0;
		Map<Character,Integer> mpp = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			mpp.clear();
			for(int j=i;j<s.length();j++) {
				mpp.put(s.charAt(j), mpp.getOrDefault(s.charAt(j), 0)+1);
				if(mpp.size()<=k) {
					maxLen = Math.max(maxLen, j-i+1);
				}else	break;
			}
		}return maxLen;
	}
	private static int subStringKCharctersOptimized(String s, int k) {
		int l = 0, r = 0, maxLen = 0;
		Map<Character,Integer> mpp = new HashMap<>();
		while(r<s.length()) {
			mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r), 0)+1);
			if(mpp.size()>k) {
				mpp.put(s.charAt(l), mpp.get(s.charAt(l))-1);
				if(mpp.get(s.charAt(l)) == 0) mpp.remove(s.charAt(l));
				l++;
			}
			if(mpp.size()<=k) {
				maxLen = Math.max(maxLen, r-l+1);
			}r++;
		}return maxLen;
	}
}
