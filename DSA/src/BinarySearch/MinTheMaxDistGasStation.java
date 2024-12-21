package BinarySearch;

public class MinTheMaxDistGasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 5, 7, 9};
        int k = 4;
        double ans = minMaxDist(arr, k);
        System.out.println("The answer is: " + ans);

	}
	private static double minMaxDist(int arr[], int k) {
		int n = arr.length;
		double low = 0;
		double high = 0;
		for(int i=0;i<n-1;i++) {
			high = Math.max(high, arr[i+1] - arr[i]);
		}
		double diff = 1e-6;
		while(high - low > diff) {
			double mid = (low + high)/2;
			int cnt = numberOfGastStationsRequired(arr,mid);
			if(cnt > k) low = mid;
			else high= mid;
		}return high;
	}
	private static int numberOfGastStationsRequired(int arr[],double dist) {
		int cnt = 0;
		for(int i=1;i<arr.length;i++) {
			int numberInBetween = (int)((arr[i]-arr[i-1])/dist);
			if((arr[i] - arr[i-1]) == dist * numberInBetween) numberInBetween--;
			cnt += numberInBetween;
		}return cnt;
	}
}
