package BasicRecursion;

public class DigitSum {

	public static void main(String[] args) {
		// WAP to find the sum of digits of a number
		int ans = sum(1342);
		System.out.println(ans);
	}
	
	private static int sum(int n) {
		if(n == 0) return 0;
		
		return sum(n / 10) + (n % 10);
	}

}
