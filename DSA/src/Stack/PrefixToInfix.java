package Stack;

import java.util.Stack;

public class PrefixToInfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "*-A/BC-/AKL";
		System.out.println("prefix to infix is: "+preToInfix(s));

	}
	 static String preToInfix(String exp) {
	        // code here
	        int i = exp.length()-1;
	        Stack<String> st = new Stack<>();
	         while(i >= 0){
	            //operand
	            if((exp.charAt(i) >= 'A' && exp.charAt(i) <= 'Z')||
	        	  (exp.charAt(i) >= 'a' && exp.charAt(i) <= 'z') ||
	        	  (exp.charAt(i) >= '0' && exp.charAt(i) <= '9')){
	                st.push(exp.charAt(i)+"");
	            }else{
	                String t1 = st.peek();
	                st.pop();
	                String t2 = st.peek();
	                st.pop();
	                String con = '(' + t1 + exp.charAt(i) + t2 + ')';
	                st.push(con);
	            }i--;
	        }return st.peek();
	    }
}
