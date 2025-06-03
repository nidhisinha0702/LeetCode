package Sorting;
//random element as pivot
import java.util.Random;

public class QuickSortIII {
	//WAP to demo quick sort and pick pivot as random element
	public static void main(String[] args) {
		Random rand = new Random();
		int[] numbers = new int[10];
		for(int i=0;i<numbers.length;i++) {
			numbers[i]=rand.nextInt(100);
		}
		System.out.println("Before:");
		printArray(numbers);
		quickSort(numbers);
		System.out.println();
		System.out.println("After:");
		printArray(numbers);
	}
	private static void printArray(int[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i]+" ");
		}
	}
	private static void quickSort(int arr[]) {
		quickSort(arr,0,arr.length-1);
	}
	 private static void quickSort(int arr[], int low, int high) {
	        // code here
		 if(low>=high) return;
		 int pivotIndex = new Random().nextInt(high-low)+low;
		 int pivot = arr[pivotIndex];
		 swap(arr,pivotIndex,high);
	     int pInd = partition(arr,low,high,pivot);
	     quickSort(arr,low,pInd-1);
	     quickSort(arr,pInd+1,high);
	       
	    }

	    private static int partition(int arr[], int low, int high, int pivot) {
	        // your code here
	        int left=low;
	        int right=high-1;
	        while(left<right){
	            while(arr[left]<=pivot && left<right){
	                left++;
	            }while(arr[right]>=pivot && left<right){
	                right--;
	            }swap(arr,left,right);
	        }if(arr[left]>arr[high])	swap(arr,left,high);
	        else	left = high;
	        return left;
	    }
	    
	    private static void swap(int arr[], int ind1, int ind2) {
	    	int temp = arr[ind1];
	    	arr[ind1]=arr[ind2];
	    	arr[ind2]=temp;
	    }

}
