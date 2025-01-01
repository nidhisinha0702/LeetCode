package BasicRecursion;

import java.util.ArrayList;
import java.util.List;

public class PrintOnlySqWithSumToK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,1};
		int n = arr.length;
		int sum = 2;
		List<Integer> ans = new ArrayList<>();
		printOnlySub(0,0,sum,n,arr,ans);
	}
	private static boolean printOnlySub(int ind,int sum,int k,int n, int []arr, List<Integer> l) {
		if(ind == n) {
			//condition satisfied
			if(sum == k) {
				System.out.println(l);
				return true;
			}return false;//condition not satisfied
		}
		//take
		l.add(arr[ind]);
		sum += arr[ind];
		if(printOnlySub(ind+1,sum,k,n,arr,l)) return true;
		//not take
		sum -= arr[ind];
		l.remove(l.size()-1);
		if(printOnlySub(ind+1,sum,k,n,arr,l)) return true;
		return false;
	}

}
