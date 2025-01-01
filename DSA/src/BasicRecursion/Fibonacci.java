package BasicRecursion;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The fibonacci of a number n is::"+fib(5));

	}
	private static int fib(int n) {
		if(n<=1) return n;
		return fib(n-1) + fib(n-2);
	}

}
