package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//smallest index such that arr[ind]>x
public class UpperBound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> reviews = new ArrayList<>(Arrays.asList(1,3,6,8));
		int target = 1;
		System.out.println("The upper bound ind of target is : "+upperBound(reviews, target));
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
	}return low;
	}
}
