package bitmanipulation;

public class CheckKthBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 13;
		int k = 2;
		System.out.println("The ith bit is set::"+checkKthBit(n, k));

	}
	static boolean checkKthBit(int n, int k) {
        // Your code here
        return ((n & (1<<k)) != 0);
    }

}
