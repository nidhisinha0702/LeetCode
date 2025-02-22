package Stack;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a+b*(c^d-e)";
		System.out.println("Infix to postfix is::"+infixToPostfix(s));

	}
	
	private static String infixToPostfix(String s) {
        int i = 0;
        Stack<Character> st = new Stack<>();
        String ans = "";
        while(i<s.length()) {
        	if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')||
        	  (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
        	  (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
        		ans += s.charAt(i);
        	}else if(s.charAt(i) == '(') st.push(s.charAt(i));
        	else if(s.charAt(i) == ')') {
        		while(!st.isEmpty() && st.peek() != '(') {
        			ans += st.peek();
        			st.pop();
        		}st.pop();
        	}else {
        		while(!st.isEmpty() && priority(s.charAt(i)) <= priority(st.peek())) {
        			ans += st.peek();
        			st.pop();
        		}st.push(s.charAt(i));
        	}i++;
        }
        while(!st.isEmpty()) {
        	ans += st.peek();
        	st.pop();
        }return ans;
    }
	private static int priority(char c) {
		if(c == '^')	return 3;
		else if(c == '*' || c == '/') return 2;
		else if(c == '+' || c == '-') return 1;
		else	return -1;
	}

}
