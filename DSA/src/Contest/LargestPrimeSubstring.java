package Contest;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LargestPrimeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12234";
		System.out.println("length is : "+sumOfLargestPrimes(s));

	}
	 public static long sumOfLargestPrimes(String s) {
		        long largest = 0;
		        Set<Long> set = new TreeSet<>((a,b) -> Long.compare(b, a));
		        //iterate 
		        for(int i =0;i<s.length();i++){
		            String temp = "";
		            for(int j = i;j<s.length();j++){
		                temp += (s.charAt(j) + "");
		                long sub =  Long.parseLong(temp);
		                if(isPrime(sub)){
		                    set.add(sub);
		                }
		                
		            }
		        }
		        Iterator<Long> it = set.iterator();
			        int cnt = 0;
			        for(Long num : set) {
			        	if(cnt >= 3) break;
			        	largest += num;
			        	cnt++;
			        }
			        return largest;
		       
		    }
		    
		    private static boolean isPrime(long n){
		        if(n <= 1){
		            return false;
		        }
		        for(int i = 2;i<=Math.sqrt(n); i++){
		            if(n % i == 0)
		                return false;
		        }
		        return true;
		    }
}
