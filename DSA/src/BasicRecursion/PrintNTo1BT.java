package BasicRecursion;

import java.util.Scanner;

public class PrintNTo1BT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int N = sc.nextInt();
		printNos(1, N);
		System.out.println();

	}
//Back Tracking
	private static void printNos(int cnt, int n) {
		if (cnt > n)
			return;
		printNos(cnt+1, n);
		System.out.print(cnt + " ");

	}

}
