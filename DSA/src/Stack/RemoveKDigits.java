package Stack;

import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "10";
		int k = 1;
		System.out.println("The minimum number string after removing k elements from the string is :"+removeKdigits(num, k));
	}
	public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(int i=0;i<n;i++){
            //pop larger element from stack
            while(!st.isEmpty() && k>0 && (st.peek() - '0' > num.charAt(i) - '0')){
                 st.pop();
                 k--;
            } 
            //push smaller elements 
            st.push(num.charAt(i));
        }
        //if k is remaining pop k elements
        while(k>0){
            st.pop();
            k--;
        }
        //after poping if stack is empty return zero
        if(st.isEmpty()) return "0";
        //if stack is not empty return result
        String res = "";
        while(!st.isEmpty()){
            res += st.pop();
        }
        //remove any trailing zero from result as stack follow LIFO (so front zero are to be removed)
        String result = "";
        int ind;
        for(ind=res.length()-1;ind>=0;ind--){
            if(res.charAt(ind) != '0'){
                break;
            }
        }
        //reverse the string from that ind after removal of trailing zero
        for(int i=ind;i>=0;i--){
            result += res.charAt(i);
        }
        if(result.isEmpty()) return "0";
        return result;
    }
}
