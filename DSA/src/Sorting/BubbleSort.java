package Sorting;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,1,3,9,7};
		bubbleSort(arr);
		for(int a:arr)
			System.out.print(a+" ");

	}
	//TC->Worst/Avg O(n^2) Best O(n)
	 private static void bubbleSort(int arr[]) {
		 //start from 0 ind and compare with next and perform swap iteratively
	        // code here
	        int n = arr.length;
	        for(int i=n-1;i>=0;i--){
	            //to avoid check if the array is already sorted
	            int didSwap = 0;
	            for(int j=0;j<i;j++){
	                if(arr[j]>arr[j+1]){
	                    int temp = arr[j];
	                    arr[j]=arr[j+1];
	                    arr[j+1]=temp;
	                    didSwap=1;
	                }
	            }if(didSwap == 0) break;
	        }
	    }
}
