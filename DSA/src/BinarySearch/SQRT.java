package BinarySearch;

public class SQRT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 52;
		int ans = sqrtN(n);
		System.out.println("The floor of the sqrt of N is :"+ans);

	}
	public static int sqrtN(long N) {
		/*
		 * Write your code here
		 */
		 long low = 1;
		 long high = N;
		 while(low<=high){
			 long mid = (low+high)/2;
			 long val = mid * mid;
			 if(val<=N){
				 low = mid + 1;
			 }else{
				 high = mid - 1;
			 }
		 }return (int)high;
	}
}
