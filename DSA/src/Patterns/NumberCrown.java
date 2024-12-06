package Patterns;

import java.util.Scanner;

public class NumberCrown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		 int start = 0;
	        for(int i=0;i<n;i++){
	            //printing 123 in increasing order
	            start=0;
	            for(int j=0;j<=i;j++){
	                System.out.print(start+1);
	                start++;
	            }//for the spaces
	            for(int j=i+1;j<2*n-i-1;j++){
	                System.out.print(" ");
	            }
	            //for last 123 in decreasing order
	            for(int j=2*n-i-1;j<=2*n-1;j++){
	                System.out.print(start);
	                start--;
	            }
	            //for new line
	            System.out.println();
	        }
	}

}
