package java_class;

import java.util.Scanner;

public class selection_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i,j,loc,ptr,temp;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of elements you want to insert in the array");
		n= sc.nextInt();
		int a[]= new int[n];
		System.out.println("enter elements");
		
		for(i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		
		for(i=0;i<n-1;i++) {
			loc=i;
			for(j=i+1;j<n;j++) {
				if(a[j]<a[loc]) {
					loc=j;
				}
			}temp=a[i];
			a[i]=a[loc];
			a[loc]=temp;
		}
		for(i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
