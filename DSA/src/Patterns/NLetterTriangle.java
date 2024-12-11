package Patterns;

import java.util.Scanner;

public class NLetterTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int ascii = 65;
        for(int i=0;i<n;i++){
            ascii=65;
            for(int j=0;j<=i;j++){
                char c = (char)(ascii);
                System.out.print(c+" ");
                ascii++;
            }System.out.println();
        }
        // Write your code here
        int asci = 65;
        for(int i=0;i<n;i++){
            asci = 65;
            for(int j=0;j<n-i;j++){
                char charac = (char)asci;
                System.out.print(charac+" ");
                asci++;
            }System.out.println();
        }

	}

}
