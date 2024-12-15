package BasicMaths;


public class CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 121;
		boolean ans = isPalindrome(x);
		if(ans) System.out.println("x is palindrome");
		else	System.out.println("x is not palindrome");

	}
	private static boolean isPalindrome(int x) {
        int n = x;
        int rev = 0;
        while(n>0){
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        return rev == x;
    }

}
