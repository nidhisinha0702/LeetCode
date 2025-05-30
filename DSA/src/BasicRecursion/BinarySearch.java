package BasicRecursion;

public class BinarySearch {

	public static void main(String[] args) {
		// WAP to show recursion for binary search
		int arr[] = {1,2,3,4,55,66,78};
		int target = 66;
		System.out.println(search(arr, target, 0, arr.length));
	}
	
	private static int search(int arr[], int tar, int st, int end) {
		//base condition
		if(st > end)
			return -1;
		
		int mid = st + (end - st)/2;
		
		if(arr[mid] == tar)
			return mid;
		
		else if(tar < arr[mid])
			return search(arr, tar, st, mid - 1);
		
		return search(arr, tar, mid + 1, end);
	}

}
