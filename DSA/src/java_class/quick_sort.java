package java_class;

import java.util.Scanner;

public class quick_sort {

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
		quick_sort q1= new quick_sort();
		q1.quick1(a,0,n-1);
		
		for(i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
	}
	void quick1(int a[],int start,int end) {
		if(start<end) {
			int p = partition(a,start,end);
			quick1(a,start,p-1);
			quick1(a,p+1,end);
		}
	}

	int partition(int a[], int start, int end) {
		int pivot = a[end];
		int pindex=start;
		for(int i=start;i<end-1;i++) {
			if(a[i]<=pivot) {
				int t = a[pindex];
				a[pindex]=a[i];
				a[i]=t;
				pindex++;
			}
		}
		int t = a[pindex];
		a[pindex]=a[end];
		a[end]=t;
		return (pindex);
	}

}