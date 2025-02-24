package Stack;

import java.util.Stack;

public class PostfixToInfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab*c+";
		System.out.println("postfix to infix is: "+postToInfix(s));
		

	}
	static String postToInfix(String exp) {
        // code here
        int i = 0;
        Stack<String> st = new Stack<>();
        while(i< exp.length()){
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
                String con = '(' + t2 + exp.charAt(i) + t1 + ')';
                st.push(con);
            }i++;
        }return st.peek();
    }
}
