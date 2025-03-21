package Arrays;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,9,3};
		int ans[] = plusOneOptimized(nums);
		for(int a:ans)
			System.out.print(a+" ");

	}
	private static int[] plusOne(int arr[]) {
		int n = arr.length;
		int carry = 1;
		int r = n-1;
		if(arr[n-1]<9) {
			arr[n-1]=arr[n-1]+1;
		}else {
			while(carry!=0 && r>=0) {
				int rem = (arr[r]+carry)%10;
				carry = (arr[r]+carry)/10;
				arr[r] = rem;
				r--;
			}if(carry==1) {
				int ans[] = new int[n+1];
				int i = 0;
				for(i=n-1;i>=0;i--) {
					ans[i+1]=arr[i];
				}ans[i+1]=carry;
				return ans;
			}
		}return arr;
	}
	
	private static int[] plusOneOptimized(int arr[]) {
		int n = arr.length;
		for(int i=n-1;i>=0;i--) {
			if(arr[i] < 9) {
				arr[i] = arr[i]+1;
				return arr;
			}
			arr[i]=0;
		}
		arr = new int[n+1];
		arr[0] = 1;
		return arr;
	}

}
