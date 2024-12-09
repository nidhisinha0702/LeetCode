package BasicRecursion;

import java.util.Scanner;

public class Print1toN {
	static int cnt = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int N = sc.nextInt();
		printNos(N);
		System.out.println();

	}
	
    private static void printNos(int n) {
        // Your code here
        if(cnt > n) return;
        System.out.print(cnt+" ");
        cnt++;
        printNos(n);
    }
}
