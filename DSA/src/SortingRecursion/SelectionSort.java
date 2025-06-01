package SortingRecursion;

import java.util.Arrays;

public class SelectionSort {

	private static void selection(int arr[], int e, int s, int max) {
		//base condition
		if(e == 0) return;
		
		if(s < e) {
			//if start is greater than max
			if(arr[s] > arr[max]) {
				selection(arr, e, s+1, s);
			}else {
				selection(arr, e, s+1, max);
			}
		}else {
			//once entire line is evaluated and we are going to change to new line
			//we will swap max with end - 1
			int temp = arr[max];
			arr[max] = arr[e-1];
			arr[e-1] = temp;
			selection(arr, e-1, 0, 0);
		}
	}
	
	public static void main(String[] args) {
		// WAP to perform selection sort (select largest and put at the end)
		int arr[] = {1,4,3,5};
		selection(arr, arr.length, 0, 0);
		System.out.println(Arrays.toString(arr));

	}

}
