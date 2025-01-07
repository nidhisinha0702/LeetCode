package BasicRecursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,1,2};
		ArrayList<Integer> ans = subsetSums(arr);
		System.out.println(ans);

	}
	 private static ArrayList<Integer> subsetSums(int[] arr) {
	        // code here
	        int n = arr.length;
	        ArrayList<Integer> sumSubset = new ArrayList<>();
	        func(0,0,arr,n,sumSubset);
	        Collections.sort(sumSubset);
	        return sumSubset;
	    }
	    
	    private static void func(int ind,int sum,int[] arr, int n, ArrayList<Integer> sumSubset){
	        //base case
	        if(ind == n){
	            sumSubset.add(sum);
	            return;
	        }
	        //pick condition
	        func(ind+1,sum+arr[ind],arr,n,sumSubset);
	        //not pick
	        func(ind+1,sum,arr,n,sumSubset);
	    }
}
