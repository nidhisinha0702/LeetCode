package Sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,1,3,9,7};
		insertionSort(arr);
		for(int a:arr)
			System.out.print(a+" ");
	}
	//TC->Worst/Avg O(n^2) Best O(n)
	  private static void insertionSort(int arr[]) {
	        // code here
		  //Take an element and place it at its correct position
	        int n = arr.length;
	        for(int i=0;i<n;i++){
	            int j = i;
	            while(j>0 && arr[j-1]>arr[j]){
	                int temp = arr[j-1];
	                arr[j-1]=arr[j];
	                arr[j]=temp;
	                j--;
	            }
	        }
	        
	    }
}
