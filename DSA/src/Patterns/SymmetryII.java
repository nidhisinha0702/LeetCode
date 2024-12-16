package Patterns;

import java.util.Scanner;

public class SymmetryII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number::");
		int n = sc.nextInt();
		 for(int i=n-1;i>=0;i--){
	            for(int j=0;j<n-i;j++){
	                System.out.print("* ");
	            }
	            for(int j=0;j<2*i;j++){
	                System.out.print(" ");
	            }
	            for(int j=0;j<n-i;j++){
	                System.out.print("* ");
	            }System.out.println();
	        }
	         for(int i=1;i<n;i++){
	            for(int j=0;j<n-i;j++){
	                System.out.print("* ");
	            }
	            for(int j=0;j<2*i;j++){
	                System.out.print(" ");
	            }
	            for(int j=0;j<n-i;j++){
	                System.out.print("* ");
	            }
	            System.out.println();
	        }

	}

}
