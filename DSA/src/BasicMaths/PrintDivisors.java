package BasicMaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintDivisors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		List<Integer> ans = printDivisors(n);
		System.out.println("The divisors of "+n+" are "+ans);

	}
	private static List< Integer > printDivisors(int n) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
    //6*6 <=36 7*7<=36
    //O(sqrt(n))
        for(int i=1;i*i<=n;i++){
            if(n%i == 0){ ans.add(i);
                if((n/i) != i){
                ans.add(n/i);
                }
            }
        }
       // O(no. of factors * log (no. of factors)): n is the number of factors
       Collections.sort(ans);
       return ans;

    }
}
