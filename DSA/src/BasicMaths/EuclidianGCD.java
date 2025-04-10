package BasicMaths;

public class EuclidianGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 28;
		int b = 96;
		System.out.println("The Euclidian gcd will be : "+gcd(a,b));
	}

	private static int gcd(int a, int b) {
		//base case
		if(b==0) return a;
		//otherwise b becomes a
		return gcd(b,a%b);
	}
}
