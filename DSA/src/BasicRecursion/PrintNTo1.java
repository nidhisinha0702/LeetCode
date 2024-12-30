package BasicRecursion;

import java.util.Scanner;

public class PrintNTo1 {

	public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the number");
				int N = sc.nextInt();
				printNos(N,N);
				System.out.println();

	}
	 private static void printNos(int cnt,int n) {
	  if(cnt < 1) return;
      System.out.print(cnt+" ");
      cnt--;
      printNos(cnt,n);

}
}
