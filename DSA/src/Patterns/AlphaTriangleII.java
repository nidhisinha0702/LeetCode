package Patterns;

import java.util.Scanner;

public class AlphaTriangleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number::");
		int n = sc.nextInt();
		int ascii = 65;
	        for(int i=0;i<n;i++) {
	        	char ch = (char)(ascii + n-1 - i);
	        	for(int j =0;j<=i;j++) {
	        		System.out.print(ch+" ");
	        		ch++;
	        	}System.out.println();
	        }
	}

}
