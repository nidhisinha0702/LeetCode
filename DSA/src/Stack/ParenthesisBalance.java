package Stack;

import java.util.Stack;

public class ParenthesisBalance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="({[)";
		if(isValid(s)==true)
		System.out.println("True");
		else
		System.out.println("False");

	}
	
	 private static boolean isValid(String s) {
	        Stack<Character> stack = new Stack<>();
	        for(int i=0;i<s.length();i++){
	            char curr = s.charAt(i);
	            if(!stack.isEmpty()){
	                char last = stack.peek();
	                if(isPair(last,curr)){
	                    stack.pop();
	                    continue;
	                }
	            }stack.push(curr);
	        }
	        return stack.isEmpty();
	    }

	    private static boolean isPair(char last,char cur){
	        return ((last == '(' && cur == ')')||
	                (last == '{' && cur == '}')||
	                (last == '[' && cur == ']'));
	    }
}
