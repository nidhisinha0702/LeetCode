package BasicHashing;

public class FrequencyCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,2,3,5};
		int ans[] = frequencyCount(arr);
		for(int a:ans) {
			System.out.print(a+" ");
		}
		

	}
	 private static int[] frequencyCount(int[] arr) {
	        // do modify in the given array
	        int n = arr.length;
	        int hash[] = new int[n];
	        
	        for(int i=0;i<n;i++){
	           hash[arr[i] - 1] +=  1;
	        }
	        
	        return hash;
	 }
}
