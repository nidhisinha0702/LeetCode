package bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SetIthBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int i = 2;
		System.out.println("the ith bit is set::"+setIthBit(n, i));
		System.out.println("clear the ith bit:"+clearIthBit(n, i));
		System.out.println("toggle ith bit is ::"+toggleIthBit(n, i));
		System.out.println("remove the last bit:"+removeLastSetBit(n, i));
		System.out.println("the num is power of 2::"+numIsPowOf2(n));
		System.out.println("count the num of set bits::"+cntNumOfSetBits(n));
		System.out.println("set the right most unset bit::"+setBit(n));
		System.out.println("swap a and b without using temp variable::"+get(9, 13));
	}
	private static int setIthBit(int n, int i) {
		n = n | (1 << i);
		return n;
	}
	private static int clearIthBit(int n, int i) {
		n = n & ~(1 << i);
		return n;
	}
	
	private static int toggleIthBit(int n, int i) {
		n =  n ^ (1 << i);
		return n;
	}
	
	private static int removeLastSetBit(int n, int i) {
		n =  n & (n-1);
		return n;
	}
	

	private static boolean numIsPowOf2(int n) {
		if(n<=0) return false; //negative numbers are not considered as power of two
		return ((n & (n-1)) == 0);
		
	}
	
	private static int cntNumOfSetBits(int n) {
		int cnt = 0;
		while(n>1) {
			cnt += (n & 1); //check if odd
			n = n >> 1; // divide by 2
		}
		if(n == 1) cnt += 1;
		return cnt;
	}
	
	private static int setBit(int n) {
        // code here
        n = (n | (n + 1));
        return n;
	}
	
	static List<Integer> get(int a,int b)
    {
        // code here
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        
        return new ArrayList<Integer>(Arrays.asList(a,b));
    }

}
