package BasicRecursion;

public class PrintNameNTimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		f(1,n);
	}
	private static void f(int i, int n) {
		if(i>n) return;
		System.out.println("Nidhi");
		f(i+1,n);
	}

}
