package bitmanipulation;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1010";
		String b = "1011";
		System.out.println("The summation of binary number is : "+addBinary(a,b));
	}
	private static String addBinary(String a, String b) {
		       int n = a.length()-1;
		       int m = b.length()-1;
		       int carry = 0;
		       StringBuilder sb = new StringBuilder();
		       while(n>=0 || m>=0){
		        int t1=0,t2=0,sum;
		        if(n>=0)
		         t1 = (a.charAt(n--) -'0');
		        if(m>=0)
		         t2 = (b.charAt(m--) -'0');
		         sum = t1 + t2 + carry;
		        if(sum>=2){
		            carry = 1;
		            sum -= 2;
		        }else carry = 0;
		            sb.append(sum);
		       }
		       if(carry==1)
		       sb.append(carry);
		       return sb.reverse().toString();
    }
}
