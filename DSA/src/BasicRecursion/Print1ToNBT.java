package BasicRecursion;

import java.util.Scanner;

public class Print1ToNBT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int N = sc.nextInt();
		printNos(N, N);
		System.out.println();

	}

	private static void printNos(int cnt, int n) {
		if (cnt < 1)
			return;
		printNos(cnt-1, n);
		System.out.print(cnt + " ");

	}
}
