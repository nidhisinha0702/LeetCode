package Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,6,5,4};
		int n = arr.length;
		//find the breakpoint from where the right half is arranged in decreasing order
        int ind=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                ind=i;
                break;
            }
        }
        //if ind=-1 there is no next permulation possible
        if(ind == -1)
        reverseArray(arr,0,n-1);
        
        //find the next greater number of the breakpoint number in the array
        for(int i=n-1;i>ind;i--){
            if(arr[i]>arr[ind]){
            	 int temp=arr[i];
                 arr[i]=arr[ind];
                 arr[ind]=temp;
                 break;
            }
        }
        //right half is still arranged in decreasing order reverse it 
        reverseArray(arr, ind+1, n-1);
        
        for(int a: arr) {
        	System.out.print(a+" ");
        }
	}
	private static void reverseArray(int arr[],int start,int end){
        while(start<=end) {
			 int temp = arr[start];
	            arr[start] = arr[end];
	            arr[end] = temp;
	            start++;
	            end--;
		}
    }

}
