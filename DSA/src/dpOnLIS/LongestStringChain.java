package dpOnLIS;

import java.util.Arrays;
import java.util.Comparator;


public class LongestStringChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] = {"a","b","ba","bca","bda","bdca"};
		System.out.println("The longest string chain length is : "+longestStrChain(words));

	}
	private static int longestStrChain(String[] words) {
        int n = words.length;
        //create a dp array of length n
        int dp[] = new int[n];
        //initialize it with 1
        Arrays.fill(dp, 1);
        //sort because its a substring, on the basis of length
        Arrays.sort(words, new stringLengthComp());
        int maxi = -1;
        //iterate over the array
        for(int i=1;i<n;i++){
            for(int j=1;j<i;j++){
                //if the second string is bigger than first
                if(checkPossible(words[i],words[j]) && (1 + dp[j] > dp[i])){
                    dp[i]=1+dp[j];
                }
            }if(dp[i]>maxi) {
            	maxi=dp[i];
            }
        }return maxi;

    }

    private static boolean checkPossible(String a, String b){
        //a is the bigger string
        if(a.length() != b.length()+1) return false;
        int first = 0;//first pointing to a
        int second = 0;//second pointing to b
        while(first<a.length()){//while it reaches length
            if(second<b.length() &&a.charAt(first)==b.charAt(second)){//if the char matches
                //move both pointers
                first++;
                second++;
            }else{
                //move first
                first++;
            }
        }
        //if after iterating both pointer reaches length
        if(first==a.length() && second==b.length()) return true;
        return false;
    }

    static class stringLengthComp implements Comparator<String>{
        @Override
        public int compare(String s1, String s2){
            if(s1.length()<s2.length()) return -1;
            else if(s1.length()>s2.length()) return 1;
            else return 0;
        }
    }
}
