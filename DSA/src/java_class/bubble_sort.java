package java_class;

import java.util.Scanner;

public class bubble_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,temp;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of elements you want to insert in the array");
		n= sc.nextInt();
		int a[]= new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		
		for(int i=0;i<n-1;i++) {
			for (int k=0;k<n-i-1;k++) {
				if(a[k]>a[k+1]) {
					temp=a[k];
					a[k]=a[k+1];
					a[k+1]=temp;
				}
			}
		}

		System.out.println("Sorted array is::");
		for(int j=0;j<n;j++) {
			System.out.print(a[j]+" ");
		}
	}

}
