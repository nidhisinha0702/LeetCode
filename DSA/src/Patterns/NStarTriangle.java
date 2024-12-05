package Patterns;

import java.util.Scanner;

public class NStarTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		 //outer for loop for the rows
        for(int i=0;i<n;i++){
            //for spaces before star
           for(int j=0;j<n-i-1;j++){
               System.out.print(" ");
           }
           //for the stars
           for(int j=0;j<2*i+1;j++){
               System.out.print("*");
           }
           //for spaces after star
           for(int j=0;j<n-i-1;j++){
               System.out.print(" ");
           }

           //line break
           System.out.println();

       }
	}

}
