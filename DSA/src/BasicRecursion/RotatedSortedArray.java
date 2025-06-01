package BasicRecursion;

public class RotatedSortedArray {

	private static int search(int arr[], int target, int s, int e) {
		if(s > e) return -1;
		
		int m = s + (e - s)/2;
		
		if(arr[m] == target) return m;
		
		//if 1st half is sorted
		if(arr[s] <= arr[m]) {
			//if key exist in this half
			if(target >= arr[s] && target <= arr[m]) {
				return search(arr, target, s, m-1);
			}else {//else other half
				return search(arr, target, m+1, e);
			}
		}else {
			//right half is sorted and target is in that half
			if(target >= arr[m] && target <= arr[e]) {
				return search(arr, target, m+1, e);
			}else {//else 1st half
				return search(arr, target, s, m-1);
			}
		}
	}
	
	public static void main(String[] args) {
		//WAP to search in a rotated sorted array
		int arr[] = {5,6,7,8,9,1,2,3};
		int target = 2;
		
		System.out.println(search(arr,target,0,arr.length-1));

	}

}
