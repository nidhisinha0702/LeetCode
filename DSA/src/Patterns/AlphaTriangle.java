package Patterns;

import java.util.Scanner;

public class AlphaTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number::");
		int n = sc.nextInt();
		int ascii = 65;
        for(int i=0;i<n;i++){  
        ascii = 65 + (n-1);
        char c = (char)(ascii);
            for(int j=0;j<=i;j++){
                System.out.print(c+" ");
                c--;
            }
            System.out.println();
        }

	}

}
