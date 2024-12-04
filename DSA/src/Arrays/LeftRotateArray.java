package Arrays;
//Given an unsorted array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.
public class LeftRotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5};
		int d = 2;
		int n = arr.length;
		d = d % n;
		//we will apply reversal algorithm
		//reverse the array from 0 to d-1
		reverseArray(arr,0,d-1);
		//reverse the array from d to n-1
		reverseArray(arr,d,n-1);
		//reverse the array from 0 to n-1
		reverseArray(arr,0,n-1);
		
		for(int a:arr) {
		System.out.print(a+",");
		}

	}
	private static void reverseArray(int[] arr, int start, int end) {
		while(start<=end) {
			 int temp = arr[start];
	            arr[start] = arr[end];
	            arr[end] = temp;
	            start++;
	            end--;
		}
	}

}
