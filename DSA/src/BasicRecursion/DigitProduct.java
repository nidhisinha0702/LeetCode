package BasicRecursion;

public class DigitProduct {

	public static void main(String[] args) {
		// WAP to find the product of each digit 
		int ans = prod(1243);
		System.out.println(ans);

	}

	private static int prod(int n) {
		if(n % 10 == n) return n;
		
		return prod(n/10) * (n % 10);
	}
}
