package Arrays;

public class reverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {1, 2, 9, 4, 3, -2, 5, 12};
	        System.out.println("Before reversing array ");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }

	        reverseArray(arr);

	        System.out.println("\nAfter reversing array: ");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	}

	private static void reverseArray(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
        int l=0;
        int r=n-1;
        for(int i=0;i<n/2;i++){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
		
	}

}
