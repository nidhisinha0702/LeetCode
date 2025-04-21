package Arrays;

public class ProductExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,4,6};
		int ans[] = productExceptSelf(arr);
		for(int a : ans)
			System.out.print(a+" ");

	}
	private static int[] productExceptSelf(int[] nums) {
        //lets find prefixmul
        int n = nums.length;
        int prefixMul[] = new int[n];
        prefixMul[0] = 1;
        for(int i=1;i<n;i++)
        prefixMul[i]= nums[i-1] * prefixMul[i-1];

        //suffixmul
        int suffixMul[] = new int[n];
        suffixMul[n-1] = 1;
        for(int i=n-2;i>=0;i--)
        suffixMul[i] = nums[i+1] * suffixMul[i+1];

        for(int i=0;i<n;i++)
        prefixMul[i] = prefixMul[i] * suffixMul[i];

        return prefixMul;
    }
}
