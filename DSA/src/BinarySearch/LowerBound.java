package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//smallest index such that arr[ind]>=x
public class LowerBound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> reviews = new ArrayList<>(Arrays.asList(1,3,6,8));
		int target = 5;
		System.out.println("The upper bound ind of target is : "+lowerBound(reviews, target));
	}
	
	private static int lowerBound(List<Integer> arr, int tar) {
		int low = 0;
		int high = arr.size()-1;
		while(low<=high) {
			int mid = (low + high) >> 1;
			if(arr.get(mid) >= tar) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}return low;
	}
}
