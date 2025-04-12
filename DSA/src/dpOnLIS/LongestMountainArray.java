package dpOnLIS;

public class LongestMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1,2,1,2};
		System.out.println("The length of the longest mountain is : "+longestMountain(arr));
	}
	private static int longestMountain(int[] A) {
        int N = A.length, res = 0;
        int[] up = new int[N], down = new int[N];
        for (int i = N - 2; i >= 0; --i) if (A[i] > A[i + 1]) down[i] = down[i + 1] + 1;
        for (int i = 0; i < N; ++i) {
            if (i > 0 && A[i] > A[i - 1]) up[i] = up[i - 1] + 1;
            if (up[i] > 0 && down[i] > 0) res = Math.max(res, up[i] + down[i] + 1);
        }
        return res;
    }
}
