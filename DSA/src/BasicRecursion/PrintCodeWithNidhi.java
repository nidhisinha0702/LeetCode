package BasicRecursion;

import java.util.Scanner;

public class PrintCodeWithNidhi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many times you want to print");
		int n = sc.nextInt();
		printCWN(n);
	}
	
	private static void printCWN(int N) {
		 //base condition
        if(N==0)
         return;
        System.out.print("CodeWithNidhi"+" ");
        N--;
        printCWN(N);
	}

}
