package BasicMaths;

import java.util.Arrays;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		System.out.println("prime numbers are::"+countPrimes(n));
	}
	private static int countPrimes(int n) {
		if(n<2) return 0;
        int prime[] = new int[n+1];
        Arrays.fill(prime,1);
        for(int i=2;i*i<=n;i++){
            if(prime[i] == 1){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=0;
                }
            }
        }
        int cnt = 0;
        for(int i=2;i<n;i++){
            if(prime[i] == 1){
                cnt++;
            }
        }return cnt;
    }
}
