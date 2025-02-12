package bitmanipulation;

public class TwoNumWithOddOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {4,2,4,5,2,3,3,1};
		int ans[] = twoOddNum(nums,8);
		for(int a:ans)
		System.out.print(a+" ");

	}
	 private static int[] twoOddNum(int Arr[], int N)
	    {
	        // code here
	        long xor = 0;
	        for(int i=0;i<N;i++)
	            xor = xor ^ Arr[i]; //xor of all the numbers in Arr
	        long rightmost = (xor & (xor - 1)) ^ xor; //find the rightmost bit which is turned on
	        long b1 = 0, b2 = 0;
	         for(int i=0;i<N;i++){
	             if((Arr[i] & rightmost) != 0)	b1 = b1 ^ Arr[i];
	             else   b2 = b2 ^ Arr[i];  
	         }
	         if(b1 < b2) {
	        	 long temp = b1;
	        	 b1 = b2;
	        	 b2 = temp;
	         }
	         return new int[]{(int)b1,(int)b2};
	    }

}
