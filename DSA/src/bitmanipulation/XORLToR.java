package bitmanipulation;

public class XORLToR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int L = 4;
		int R = 8;
		System.out.println("the xor from ll to r is::"+findXOR(L,R));

	}
	  public static int findXOR(int l, int r) {
	        return func(l-1) ^ func(r);
	    }
	    private static int func(int n){
	        if(n % 4 == 1) return 1;
	        else if(n % 4 == 2) return n+1;
	        else if(n % 4 == 3) return 0;
	        else return n;
	    }
}
