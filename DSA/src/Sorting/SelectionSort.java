package Sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,1,3,9,7};
		selectionSort(arr);
		for(int a:arr)
			System.out.print(a+" ");
	}
	//TC->Worst/Avg/Best O(n^2) 
	 private static void selectionSort(int[] arr) {
	        // code here
	        int n = arr.length;
	        //select the minimum and swap
	        for(int i=0;i<n-1;i++){
	            int mini = i;//take 1st ind as mini ind
	            for(int j=i;j<n;j++){
	                //check with all other element and find minimum
	                if(arr[j]<arr[mini])    mini=j;
	            }
	                //swap the minimum with 1st element of start array
	                int temp = arr[i];
	                arr[i] = arr[mini];
	                arr[mini] = temp;
	        }
	    }
}
