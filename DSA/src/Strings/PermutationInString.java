package Strings;

public class PermutationInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ab";
		String s2 = "eidbaooo";
		System.out.println("The permutation of s1 is there in s2 : "+isFreqSame(s1, s2));
	}

	private static boolean isFreqSame(String s1, String s2) {
		 //count the freq of char + no of freq
        int freq[] = new int[26];//lower case english characters

        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        //s1 permutation will be our window
        int windSize = s1.length();
        //sliding window based approach
        for(int i=0;i<s2.length();i++){
            int windIdx = 0, idx = i;
            int windFreq[] = new int[26];
            //iterate in the window
            while(windIdx < windSize && idx < s2.length()){
                //store the char and its freq
                windFreq[s2.charAt(idx)-'a']++;
                windIdx++; idx++;
            }

            if(isFreqSame(freq,windFreq)){
                return true;
            }
        }return false;
    }
    private static boolean isFreqSame(int freq1[], int freq2[]){
        for(int i=0;i<26;i++){
            if(freq1[i] != freq2[i])
            return false;
        }return true;
    }
}
