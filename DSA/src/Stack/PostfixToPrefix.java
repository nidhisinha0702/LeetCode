package Stack;

import java.util.Stack;

public class PostfixToPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABC/-AK/L-*";
		System.out.println("postfix to prefix is: "+postToPre(s));

	}
	static String postToPre(String post_exp) {
        // code here
        int i = 0;
        Stack<String> st = new Stack<>();
        while(i<post_exp.length()){
            //operand
	            if((post_exp.charAt(i) >= 'A' && post_exp.charAt(i) <= 'Z')||
	        	  (post_exp.charAt(i) >= 'a' && post_exp.charAt(i) <= 'z') ||
	        	  (post_exp.charAt(i) >= '0' && post_exp.charAt(i) <= '9')){
	                st.push(post_exp.charAt(i)+"");
	            }else{
	            String t1 = st.peek();
                st.pop();
                String t2 = st.peek();
                st.pop();
                String con = post_exp.charAt(i) + t2 + t1;
                st.push(con);
                }i++;
        }return st.peek();
    }
}
