package BasicRecursion;

public class ReverseNumber {


	private static int reverse(int n) {
		int digits = (int)(Math.log10(n)) + 1;
		return helper(n, digits);
	}

	private static int helper(int n, int digits) {
		if(n%10 == 0) return n;
		int rem = n % 10;
		return rem * (int)(Math.pow(10, digits-1)) + helper(n/10, digits - 1);
	}

	public static void main(String[] args) {
		//WAP to reverse a number
		int num = 1824;
		System.out.println(reverse(num));
	}
	
}
