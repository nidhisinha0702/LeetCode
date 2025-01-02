package Sorting;
//1st element as pivot
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,6,2,5,7,9,1,3};
		int low = 0;
		int high = arr.length -1;
		quickSort(arr,low,high);
		for(int a:arr) {
			System.out.print(a+" ");
		}

	}
	 static void quickSort(int arr[], int low, int high) {
	        // code here
	        if(low<high){
	            int pInd = partition(arr,low,high);
	            quickSort(arr,low,pInd-1);
	            quickSort(arr,pInd+1,high);
	        }
	    }

	    static int partition(int arr[], int low, int high) {
	        // your code here
	        int pivot = arr[low];
	        int i=low;
	        int j=high;
	        while(i<j){
	            while(arr[i]<=pivot && i<=high-1){
	                i++;
	            }while(arr[j]>pivot && j>=low+1){
	                j--;
	            }if(i<j) {
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }int temp = arr[low];
	        arr[low]= arr[j];
	        arr[j]=temp;
	        return j;
	    }
}
