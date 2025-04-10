package Arrays;

import java.util.ArrayList;
import java.util.List;

public class GCDOfSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 4, 8, 24, 14, 20, 25, 35, 7, 49, 7};
		int k = 3;
		int ans[] = printGCD(arr,k);
		for(int a:ans)
			System.out.print(a+" ");

	}
	private static int[] printGCD(int arr[], int k) {
		int n = arr.length;
		List<Integer> ans = new ArrayList<>();
		//iterate over the array
		//for single element the gcd is itself
		for(int i=0;i<n-k+1;i++) {
			int gcd = arr[i];
			for(int j=i+1;j<i+k;j++) {
				//this will compare the gcd of all the elements from i to j
			gcd = gcd(gcd,arr[j]);
			}
			//finally we will add it to ans
			ans.add(gcd);
		}
		
		int res[] = ans.stream().mapToInt(Integer::intValue).toArray();
		return res;
	}
	private static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
