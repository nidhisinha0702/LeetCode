package BasicRecursion;

public class reverseArrayRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,2,5,4};
		int n = arr.length;
		//revRecursion(0,arr.length-1,arr);
		revRecursionSinglePointer(0, arr, n);
		for(int a:arr) {
			System.out.print(a+" ");
		}
		
	}
	private static void revRecursion(int l,int r,int[] a) {
		if(l<r) { 
		int temp = a[l];
		a[l] = a[r];
		a[r]=temp;
		revRecursion(l+1,r-1,a);
		}
	}
	private static void revRecursionSinglePointer(int i,int[] a,int n) {
		if(i<=n/2) {
		int temp = a[i];
		a[i] = a[n-i-1];
		a[n-i-1]=temp;
		revRecursionSinglePointer(i+1,a,n);
		}
	}

}
