package BasicRecursion;

import java.util.ArrayList;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 9;
		ArrayList<Long> ans = factorialNumbers(n);
		for(long num:ans) {
			System.out.print(num+" ");
		}

	}
	 static long fact = 1;
	    static ArrayList<Long> factorialNumbers(long n) {
	        // code here
	        ArrayList<Long> ans = new ArrayList<>();
	        if(n == 1) {
	        	ans.add(fact);
	        	return ans;
	        }
	        return factN(n,ans,fact,1);
	        }
	        
	    static ArrayList<Long> factN(long n, ArrayList<Long> ans,long fact,long curr){
	    	if(fact>n) return ans;
	    	ans.add(fact);
	    	return factN(n,ans,fact * (curr+1), curr + 1);
	    }
}
