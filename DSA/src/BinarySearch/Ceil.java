package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//the ceil value of x is the smallest value greater than or equal to x
public class Ceil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> reviews = new ArrayList<>(Arrays.asList(1,3,6,8));
		int target = 4;
		System.out.println("The upper bound ind of target is : "+ceil(reviews, target));
	}
	
	private static int ceil(List<Integer> arr, int target) {
		int low = 0;
		int high = arr.size()-1;
		while(low<=high) {
			int mid = (low + high) >> 1;//low + (high-low)/2
			if(arr.get(mid) >= target) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}return arr.get(low);
	}
}
