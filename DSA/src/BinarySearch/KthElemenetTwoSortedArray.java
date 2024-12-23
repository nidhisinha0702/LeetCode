package BinarySearch;

public class KthElemenetTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,3,6,7,9};
		int b[]= {1,4,8,10};
		int k =4;
		System.out.println("The kth element in merged two sorted aray is ::"+kthElement(a,b,k));

	}
	 private static int kthElement(int a[], int b[], int k) {
	        // code here
	        int n = a.length;
	        int m = b.length;
	        //always choose one with less length for TC
	        if(n>m) return kthElement(b, a, k);
	        //for greater values of k we need to choose atleast k-m
	        //for lower values of k we need to choose min of k and n
	        int low = Math.max(0,k-m), high = Math.min(n,k);
	        //left will be k and find the max will return the kth element
	        int left = k;
	        while(low<=high){
	            int mid1 = (low+high)/2;
	            int mid2 = left - mid1;
	            //find l1,l2,r1and r2
	            int l1 = (mid1-1>=0)?a[mid1-1]:Integer.MIN_VALUE;//then only l1 will exist in a
	            int l2 = (mid2-1>=0)?b[mid2-1]:Integer.MIN_VALUE;//then only l2 exist in b
	            int r1 = (mid1<n)?a[mid1]:Integer.MAX_VALUE;//only take element from a if mid ind<n
	            int r2 = (mid2<m)?b[mid2]:Integer.MAX_VALUE;//only take element from b if mid ind<m
	            if(l1<=r2 && l2<=r1) return Math.max(l1,l2);
	            else if(l1>r2) high = mid1-1;
	            else low = mid1+1;
	        }
	        return 0;
	    }

}
