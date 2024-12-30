package BasicRecursion;

import java.util.Scanner;

public class SumOfNnos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int N = sc.nextInt();
		int ans = sumNos(N);
		System.out.println(ans);
	}
	
	private static int sumNos(int n) {
		if(n == 0) return 0;
		return n + sumNos(n-1);
	}
}
