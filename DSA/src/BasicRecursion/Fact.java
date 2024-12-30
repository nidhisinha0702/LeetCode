package BasicRecursion;

import java.util.Scanner;

public class Fact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int N = sc.nextInt();
		int ans = fact(N);
		System.out.println(ans);
	}
	private static int fact(int n) {
		if(n==1) return 1;
		return n*fact(n-1);
	}
}
