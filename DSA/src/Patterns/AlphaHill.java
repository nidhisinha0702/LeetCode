package Patterns;

import java.util.Scanner;

public class AlphaHill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        // Write your code here
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number::");
		int n = sc.nextInt();
		        for(int i=0;i<n;i++){
		            //for spaces
		            for(int j=0;j<n-i-1;j++){
		                System.out.print(" ");
		            }
		            //for character
		            char ch = 'A';
		            int breakpoint = (2*i+1)/2;
		            for(int j= 1;j<=2*i+1;j++){
		                System.out.print(ch+" ");
		                if(j<=breakpoint) ch++;
		                else
		                    ch--;
		            }
		            //for spaces
		            for(int j=0;j<n-i-1;j++){
		                System.out.print(" ");
		            }
		            System.out.println();
		        }

	}

}
