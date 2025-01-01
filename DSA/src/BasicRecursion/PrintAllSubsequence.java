package BasicRecursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,1,2};
		int n = arr.length;
		List<Integer> ans = new ArrayList<>();
		subsequence(0,arr,n,ans);

	}
	private static void subsequence(int ind, int arr[], int n, List<Integer> al) {
		if(ind==n) {
			System.out.println(al);
			return;
		}
		
		//take
		al.add(arr[ind]);
		subsequence(ind+1,arr,n,al);
		//not take
		al.remove(al.size()-1);//we cannot do al.remove(arr[i]) because when we do al.remove on two ob(3,2) ind=2 and al ind is only 0,1
		subsequence(ind+1, arr, n, al);
	}

}
