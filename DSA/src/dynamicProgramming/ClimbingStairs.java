package dynamicProgramming;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int ans = climbStairs(n);
		System.out.println("The ways in which you can climb on top is: "+ans);

	}
	 private static int climbStairs(int n) {
	        if(n<=1) return 1;
	        int prev = 1;
	        int prev2 = 1;
	        for(int i=2;i<=n;i++){
	            int curr = prev2 + prev;
	            prev2 = prev;
	            prev = curr;
	        }return prev;
	    }

}
