package java_class;

import java.util.Scanner;

public class linear_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i,item;
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
		int c =0 ;
		for(i=0;i<a.length;i++) {
			if(a[i]==item) {
				c++;
				break;
			}
		}
		if(c>0) {
			System.out.println("item exist at location: "+i);
		}else {
			System.out.println("item does not exist");
		}
				
	}

}
