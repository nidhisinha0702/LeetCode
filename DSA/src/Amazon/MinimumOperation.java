package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> reviews = new ArrayList<>(Arrays.asList(3,1,6,8));
		List<Integer> counts = new ArrayList<>(Arrays.asList(1,5));
		
		List<Long> ans = minOperation(reviews,counts);
		System.out.println(ans);
	}
	private static List<Long> minOperation(List<Integer> reviews, List<Integer> counts){
		//the idea here is to sort , prefix sum, binary search
		Collections.sort(reviews);
		int n = reviews.size();
		
		int sum[] = new int[n+1];
		
		for(int i=0;i<n;i++) {
			sum[i+1] = sum[i] + reviews.get(i);
		}
		
		List<Long> ans = new ArrayList<>();
		
		//iterate counts one by one
		for(int target:counts) {
			//we will find the index greater than target and saparate the reviews array into left and right sorted halves
			int ind = upperBound(reviews, target);
			
			//left will be the smaller and equal to the target
			long left = (ind * target * 1L) - sum[ind];
			//right will be the greater than target
			long right = (sum[n] - sum[ind]) - (1L * target * (n - ind));
			
			ans.add(left+right);
		}return ans;
	}
	
	private static int upperBound(List<Integer> arr, int tar) {
		int low = 0;
		int high = arr.size()-1;
		int ans = arr.size();
		while(low<=high) {
			int mid = (low + high) >> 1;
			if(arr.get(mid) > tar) {
				ans = mid;
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}return ans;
	}

}
