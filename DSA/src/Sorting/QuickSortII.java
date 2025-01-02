package Sorting;
//last element as pivot
public class QuickSortII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {24 ,18 ,38 ,43 ,14 ,40 ,1, 54};
		quickSort(arr);
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}
	
	private static void quickSort(int arr[]) {
		quickSort(arr,0,arr.length-1);
	}
	 private static void quickSort(int arr[], int low, int high) {
	        // code here
		 if(low>=high) return;
		 int pivot = arr[high];
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
	        }//we will only swap the pivot and left if the left array element is greater than pivot
	        if(arr[left]>arr[high])	swap(arr,left,high);
	        else	left = high;//else we will just change the left to high because the high is pointing to the largest ind and all other elements are smaller
	        return left;
	    }
	    
	    private static void swap(int arr[], int ind1, int ind2) {
	    	int temp = arr[ind1];
	    	arr[ind1]=arr[ind2];
	    	arr[ind2]=temp;
	    	
	    }

}
