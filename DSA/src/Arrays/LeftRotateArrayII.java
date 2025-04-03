package Arrays;

public class LeftRotateArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		int d = 3;
		rotateArr(arr,d);
		for(int a:arr)
			System.out.print(a+" ");
	}
	static void rotateArr(int arr[], int d) {
        // add your code here
        //find the size of the array
        int n = arr.length;
        //check if the d>n
        d = d % n;
        //iterate over the given array and extract d characters to temp array
        int temp[] = new int[d];
        
        for(int i=0;i<d;i++){
            temp[i] = arr[i];
        }
        //move the rest to start position
        for(int j=d;j<n;j++){
            arr[j-d]=arr[j];
        }
        //now append the rest to the array
        for(int k=d;k>0;k--){
            arr[n-k]=temp[d-k];
        }
    }
}
