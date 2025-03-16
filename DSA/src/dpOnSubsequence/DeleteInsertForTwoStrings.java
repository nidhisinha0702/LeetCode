package dpOnSubsequence;

public class DeleteInsertForTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "sea";
		String word2 = "eat";
		System.out.println("The minimum number of steps required to make word1 and word2 the same : "+minDistance(word1, word2));
	}
	private static int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2*ffff(word1,word2);
    }
     private static int ffff(String text1, String text2){
	    	 int n = text1.length();
	         int m = text2.length();
	         int prev[] = new int[m+1];
	        
	         for(int j=0;j<=m;j++) prev[j]=0;

	         for(int i=1;i<=n;i++){
	        	 int cur[] = new int[m+1];
	             for(int j=1;j<=m;j++){
	                 if(text1.charAt(i-1) == text2.charAt(j-1))
	                     cur[j] = 1 + prev[j-1];
	                 else cur[j] = Math.max(prev[j],cur[j-1]);
	             }prev = cur;
	         }
	         return prev[m];
	    }
}
