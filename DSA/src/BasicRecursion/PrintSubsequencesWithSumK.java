package BasicRecursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequencesWithSumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,1};
		int n = arr.length;
		int sum = 2;
		List<Integer> ans = new ArrayList<>();
		printSub(0,0,sum,n,arr,ans);

	}
	private static void printSub(int ind,int sum,int k,int n, int []arr, List<Integer> l) {
		if(ind == n) {
			if(sum == k) {
				System.out.println(l);
			}return;
		}
		//take
		l.add(arr[ind]);
		sum += arr[ind];
		printSub(ind+1,sum,k,n,arr,l);
		//not take
		sum -= arr[ind];
		l.remove(l.size()-1);
		printSub(ind+1,sum,k,n,arr,l);
	}

}
