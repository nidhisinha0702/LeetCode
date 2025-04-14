package Strings;

public class AppendAlternates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The merged string is : "+mergeAlternately("abc", "pqr"));
	}
	private static String mergeAlternately(String word1, String word2) {
        int i=0,j=0;
        String ans = "";

        while(i<word1.length() && j<word2.length()){
            ans += word1.charAt(i) + "" + word2.charAt(j) + "";
            i++;
            j++;
        }
        //if word1 is remaining
        if(i<word1.length())
        ans += word1.substring(i,word1.length());

        //if word2 is remaining
        if(j<word2.length())
            ans += word2.substring(j,word2.length());

        return ans;
    }
}
