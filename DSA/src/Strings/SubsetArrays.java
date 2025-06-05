package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetArrays {

	//TC-> O(n * 2^n) SC->O(2^n * n)
	private static List<List<Integer>> subset(int arr[]){
		List<List<Integer>> outer = new ArrayList<>();
		
		outer.add(new ArrayList<>());
		
		for(int num: arr) {
			int n = outer.size();
			for(int i=0;i<n;i++) {
				List<Integer> inner = new ArrayList<>(outer.get(i));
				inner.add(num);
				outer.add(inner);
			}
		}
		
		return outer;
	}
	
	private static List<List<Integer>> subsetDuplicate(int arr[]){
		//to make duplicates together sort it
		Arrays.sort(arr);
		List<List<Integer>> outer = new ArrayList<>();
		
		outer.add(new ArrayList<>());
		int start = 0, end = 0;
		
		for(int i=0;i<arr.length;i++) {
			start = 0;
			//if current and previous element is same , s = e + 1
			if(i > 0 && arr[i] == arr[i-1]) {
				start = end + 1;
			}
			end = outer.size() - 1;
			int n = outer.size();
			for(int j=start;j<n;j++) {
				List<Integer> inner = new ArrayList<>(outer.get(j));
				inner.add(arr[i]);
				outer.add(inner);
			}
		}
		
		return outer;
	}
	
	public static void main(String[] args) {
		// WAp to find all the subset of array
		int arr[] = {1,2,3};
		int arr1[] = {2,1,2};
		System.out.println(subset(arr));
		System.out.println(subsetDuplicate(arr1));

	}

}
