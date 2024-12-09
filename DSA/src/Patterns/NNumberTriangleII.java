package Patterns;

import java.util.Scanner;

public class NNumberTriangleII {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int start = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                start++;
                System.out.print(start+" ");
            }System.out.println();
        }

	}

}
