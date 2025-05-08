package Stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		List<String> ans = generateParenthesis(n);
		System.out.println(ans);

	}
	private static List<String> generateParenthesis(int n){
		List<String> ans = new ArrayList<>();
		
		int close = n, open = n;
		String op = "";
		solve(open,close,op,ans);
		return ans;
	}
	
	private static void solve(int open, int close, String op, List<String> ans) {
		//base condition
		if(open == 0 && close == 0) {
			ans.add(op);
			return;
		}
		//we can add open everytime
		if(open != 0) {
			String op1 = op + "(";
			solve(open-1,close,op1,ans);
		}
		//we can add close if we are left with open<close
		if(open < close) {
			String op2 = op + ")";
			solve(open, close-1, op2,ans);
		}
	}
}
