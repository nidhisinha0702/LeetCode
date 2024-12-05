package Patterns;

import java.util.Scanner;

public class Seeding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		 for(int i=0;i<n;i++){
	            for(int j=n-1-i;j>=0;j--){
	                System.out.print("* ");
	            }System.out.println();
	        }

	}

}
