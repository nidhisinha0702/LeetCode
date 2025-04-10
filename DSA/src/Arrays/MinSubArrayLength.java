package Arrays;

public class MinSubArrayLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {4,8,4};
		int n = 3;
		//Find the Length of the smallest subarray that must be removed in order to maximize the gcd
		System.out.println("The Lenth is : "+getMinSubarrayLength(a, n));

	}
	private static int getMinSubarrayLength(int a[], int n) {
		//GCD is a non-increasing function i.e., if we add elements in the array then gcd wil wither decrease or remain constant.
		//find the max of 1st and last element of the array
		int ans = Math.max(a[0], a[n-1]);
		
		//we will use two pointer
		int low = 0, high = n-1;
		
		//check if the ans completly divides the num
		while(low<n && a[low] % ans == 0)
			low++;
		while(high>low && a[high] % ans == 0)
			high--;
		
		//return the length
		return (high-low+1);
	}
}
