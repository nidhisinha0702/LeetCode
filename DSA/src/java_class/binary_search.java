package java_class;

import java.util.Scanner;

public class binary_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i,item,beg,end,mid,c=0;
		int[] a;
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements do you want to enter");
		n = sc.nextInt();
		a = new int[n];
		
		System.out.println("Enter elements");
		
		for(i=0;i<n;i++)
			a[i] = sc.nextInt();
		
		System.out.println("Enter item to find");
		item = sc.nextInt();
		beg=0;end=n-1;
		while(beg<=end) {
			mid=(beg+end)/2;
			if(item==a[mid]) {
				c++;
				System.out.println("item found at : "+mid);
				break;
			}
			else if(item>a[mid]) {
				beg=mid+1;
			}
			else if(item<a[mid]) {
				end=mid-1;
			}
			
		}if(c>0) {
			System.out.println("item found");
		}else {
			System.out.println("item not found");
		}
	}

}
