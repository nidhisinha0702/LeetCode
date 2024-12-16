package BasicMaths;

public class LCMandGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 5;
		int b = 10;
		int []arr = lcmAndGcd(a, b);
		for(int ar:arr) {
		System.out.println("The lcm and gcd of a and b are: "+ar);
		}

	}
	  private static int[] lcmAndGcd(int a, int b) {
	        // code here
	        int lcm=1;
	        int gcd = 1;
	        int n1 = a,n2 = b;
	        while(n1 > 0 && n2 > 0){
	            if(n1 > n2) n1 = n1 % n2;
	            else    n2 = n2 % n1;
	        }
	        if (n1 == 0) gcd = n2;
	        else     
	        	gcd = n1;
	      //  a * b = lcm * gcd;
	      lcm = (a * b) / gcd;
	        
	        return new int[]{lcm,gcd};
	    }
}
