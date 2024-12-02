package java_class;

import java.util.Scanner;

public class merge_sort {
	void merge(int a[],int start,int mid,int end) {
		int l = mid-start+1;//no. of elements
		int r = end-mid;
		int left_subarray[] = new int[l];
		int right_subarray[] = new int[r];
		
		for(int i=0;i<l;++i)
			left_subarray[i] = a[start + i];
		for(int j=0;j<r;++j)
			right_subarray[j] = a[mid + 1 + j];
		
		int i=0,j=0;
		int k=start;
		while(i<l && j<r) {
			if(left_subarray[i] <= right_subarray[j]) {
				a[k] = left_subarray[i];
				i++;
			}
			else {
				a[k] = right_subarray[j];
				j++;
			}
			k++;
		}
	
	while(i<l) {
		a[k] = left_subarray[i];
		i++;
		k++;
	}while(j<r) {
		a[k] = right_subarray[i];
		j++;
		k++;
	}
	}

	void mergesort(int a[], int start, int end) {
		if(start<end) {
			int mid=(start+end)/2;
			mergesort(a,start,mid);
			mergesort(a,mid+1,end);
			merge(a,start,mid,end);
		}
	}
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
		
		merge_sort ob = new merge_sort();
		ob.mergesort(a,0,n-1);
		
		for(i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
