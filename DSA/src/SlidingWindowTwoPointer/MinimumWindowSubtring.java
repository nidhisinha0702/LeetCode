package SlidingWindowTwoPointer;

public class MinimumWindowSubtring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ddaaabbca";
		String t = "abc";
		System.out.println("The minimum window sustring in s of t is : "+minWindow(s, t));

	}
	private static String minWindow(String s, String t) {
        int l = 0, r = 0, cnt = 0, sInd = -1;
        int minLen = Integer.MAX_VALUE;
        int hash[] = new int[128];
        int n = s.length();
        int m = t.length();
        //if the n<m
        if(n<m) return "";
        //insert the character,frequency in hash map 
        for(int i=0;i<m;i++)
            hash[t.charAt(i)]++;
        //iterate over s to find min window substring with t
        while(r<n){
            if(hash[s.charAt(r)]>0)
                cnt += 1;
            hash[s.charAt(r)]--;//decrease the count for all current character
            //when we have a valid window try to minimize it
            while(cnt == m){
                if(r-l+1<minLen){
                    minLen = r-l+1;
                    sInd = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) cnt -= 1;
                l++;
            }r++;
        }return (sInd == -1)?"":s.substring(sInd,sInd+minLen);
    }

}
