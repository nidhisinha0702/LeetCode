package SlidingWindowTwoPointer;

import java.util.Arrays;

public class SubstringContainingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbacba";
		System.out.println("Number of substring containing all three characters are : "+numberOfSubstrings(s));
	}
	  private static int numberOfSubstrings(String s) {
	        //create a last seen array with initial value -1 for a,b,c
	        int lastSeen[] = new int[3];
	        Arrays.fill(lastSeen,-1);
	        int cnt = 0;
	        //iterate over the array
	        for(int i=0;i<s.length();i++){
	            //update last seen
	            lastSeen[s.charAt(i)-'a'] = i;
	            //check if the lastseen is not -1
	            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1)
	            //min + 1
	            cnt += 1 + Math.min(lastSeen[0], Math.min(lastSeen[1],lastSeen[2]));
	        }return cnt;
	    }
}
