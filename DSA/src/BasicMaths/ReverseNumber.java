package BasicMaths;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = -123;//-2147483648;//(int) Math.pow(2, 31);
		boolean NegativeFlag = false;
		int ans = reverse(n,NegativeFlag);
		System.out.println("The reverse of n is: "+ans);
		

	}
	private static int reverse(int x, boolean flag) {
	       int revNumber=0;
	       if(x<0) {
	    	   flag = true;
	    	   x = -(x);
	       }
//The above approach won’t work if we are given a signed 32-bit integer x, and return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 – 1], then return 0. So we cannot multiply the number*10 and then check if the number overflows or not.
//We must check the overflow condition before multiplying by 10 by using the following logic :
//You are checking the boundary case before you do the operation. (reversed >INT_MAX ) wouldn’t work because reversed will overflow and become negative if it goes past MAX_VALUE.  Dividing MAX_VALUE by 10 lets you check the condition without overflowing 
//INT_MAX is equal 2147483647. INT_MIN is equal  -2147483648.  The last digits are 7 and 8. This is the reason why we also  check  rem > 7 and rem < -8 conditions
	       while(x>0){
	       int lastDigit = x % 10;
	       
	       if(revNumber > Integer.MAX_VALUE / 10 || revNumber == Integer.MAX_VALUE/10 && lastDigit > 7) return 0;
	       if(revNumber > Integer.MAX_VALUE / 10 || revNumber == Integer.MAX_VALUE/10 && lastDigit < -8) return 0;
	       
	       revNumber = revNumber * 10 + lastDigit;
	       x = x / 10;
	       }if(flag) return -(revNumber);
	       return revNumber;
	}
	//Here the time complexity is logarithmic base 10 of N
}
