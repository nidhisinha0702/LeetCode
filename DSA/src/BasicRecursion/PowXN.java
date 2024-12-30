package BasicRecursion;

public class PowXN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 2.0000;
		int n = 10;
		System.out.println("The pow of x n is:: "+myPow(x,n));

	}
	
	public static double myPow(double x, int n) {
        double nn = n;
        double ans = 1.0;
        if(nn<0) nn = -1 * nn;
        while(nn>0){
            if(nn%2==0){
            x = x * x;
            nn = nn/2;
            }else{
                ans = ans * x;
                nn = nn - 1;
            }
        }
        if(n<0) ans = (double)(1.0)/(double)ans;
        return ans;
    }

}
