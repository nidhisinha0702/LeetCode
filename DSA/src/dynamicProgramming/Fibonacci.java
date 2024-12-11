package dynamicProgramming;

public class Fibonacci {

	    // Top-Down approach using memoization
	    public static long topDownFibonacci(int n, java.util.HashMap<Integer, Long> memo) {
	        if (n <= 1) {
	            return n;
	        }
	        if (memo.containsKey(n)) {
	            return memo.get(n);
	        }

	        long result = topDownFibonacci(n - 1, memo) + topDownFibonacci(n - 2, memo);
	        memo.put(n, result);
	        return result;
	    }

	    // Bottom-Up approach using tabulation
	    public static long bottomUpFibonacci(int n) {
	        if (n <= 1) {
	            return n;
	        }

	        long[] dp = new long[n + 1];
	        dp[0] = 0;
	        dp[1] = 1;

	        for (int i = 2; i <= n; i++) {
	            dp[i] = dp[i - 1] + dp[i - 2];
	        }

	        return dp[n];
	    }

	    public static void main(String[] args) {
	        int n = 697; // Example input

	        // Top-Down approach
	        java.util.HashMap<Integer, Long> memo = new java.util.HashMap<>();
	        long topDownResult = topDownFibonacci(n, memo);
	        System.out.println("Top-Down Fibonacci of " + n + " is: " + topDownResult);

	        // Bottom-Up approach
	        long bottomUpResult = bottomUpFibonacci(n);
	        System.out.println("Bottom-Up Fibonacci of " + n + " is: " + bottomUpResult);
	    }
	

}
