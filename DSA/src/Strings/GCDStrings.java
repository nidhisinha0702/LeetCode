package Strings;

public class GCDStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The gcd of strings are : "+gcdOfStrings("ABABAB", "ABAB"));

	}
	 private static String gcdOfStrings(String str1, String str2) {
	     //check if the strings sums are equal
	     if(!(str1 + str2).equals(str2 + str1)){
	        return "";
	     }

	     int gcd = GCD(str1.length(),str2.length());
	     return str1.substring(0,gcd);
	    }

	    private static int GCD(int a , int b){
	        while(b!=0){
	            int t = a % b;
	            a=b;
	            b=t;
	        }return a;
	    }
}
