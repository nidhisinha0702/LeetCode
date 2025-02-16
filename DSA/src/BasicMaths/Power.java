package BasicMaths;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The power of x and n is::"+myPow(2.00,10));
	}
	private static double myPow(double x, int n) {
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
