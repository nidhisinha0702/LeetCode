package java_class;

import java.util.Scanner;

public class two_Darray {

	public static void main(String[] args) {
		int n,m,p;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of rows");
		n = sc.nextInt();
		System.out.println("Enter no. of columns");
		m = sc.nextInt();
		int a[][] = new int[n][m];
		System.out.println("Enter values");
		for(int i=0; i<n;i++) { //n=2,m=3
			for(int j=0;j<m;j++) {
			a[i][j]= sc.nextInt(); // a[0][0], a[0][1],a[0][2], a[1][0],a[1][1]...
		}
		}
		
		for(int i=0; i<n;i++) { //n=2,m=3
			for(int j=0;j<m;j++) {
			System.out.print(a[i][j]+" ");// a[0][0], a[0][1],a[0][2], a[1][0],a[1][1]...
		}System.out.println();
		}

	}

}
