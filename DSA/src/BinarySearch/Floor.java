package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//floor value of x is the largest element in an array lesser than or equal to x.
public class Floor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> reviews = new ArrayList<>(Arrays.asList(1,3,6,8));
		int target = 5;
		System.out.println("The upper bound ind of target is : "+floor(reviews, target));
	}
	
	private static int floor(List<Integer> arr, int target) {
		int low = 0;
		int high = arr.size()-1;
		while(low<=high) {
			int mid = (low + high) >> 1;
			if(arr.get(mid) <= target) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}return arr.get(high);
	}
}
