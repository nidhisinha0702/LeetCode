package BasicMaths;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 61271;
		int nums[] = AllPrimeFactors(N);
		for(int n:nums)
		System.out.print(n+"");

	}
	private static int[] AllPrimeFactors(int N) {
	 List<Integer> list = new ArrayList<>();
     for(int i=2;i<=Math.sqrt(N);i++){
         if(N%i == 0){
             list.add(i);
         }while(N%i == 0)
             N=N/i;
     }
     if(N!=1) list.add(N);
     return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
