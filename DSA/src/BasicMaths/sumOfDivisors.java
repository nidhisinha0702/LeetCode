package BasicMaths;

public class sumOfDivisors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int ans = sumOfDivisors(n);
		System.out.println("The sum of divisors: "+ans);

	}
	private static int sumOfDivisors(int n) {
        // code here
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += (n/i) * i;
        }return sum;
    }
}
