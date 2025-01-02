package BasicRecursion;

import java.util.ArrayList;
import java.util.List;

public class CountAllSubSequenceWithSumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,1};
		int n = arr.length;
		int sum = 2;
		int ans = countSub(0,0,sum,n,arr);
		System.out.println("Total number of subsequences are::"+ans);
	}
	//O(2^n)
	private static int countSub(int ind,int sum,int k,int n, int []arr) {
		if(ind == n) {//all elements of array have been considered
			//condition satisfied
			if(sum == k) {
				return 1;
			}return 0;//condition not satisfied
		}
		//take
		sum += arr[ind];
		int l = countSub(ind+1,sum,k,n,arr);
		//not take
		sum -= arr[ind];
		int r = countSub(ind+1,sum,k,n,arr);
		return l+r;
	}

}
