package Stack;

import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp[] = {30,38,30,36,35,40,28};
		int ans[] = dailyTemperatures(temp);
		for(int d:ans)
		System.out.print(d+" ");

	}
	private static int[] dailyTemperatures(int[] temperatures) {
        //the intuition is to maintain a monotonic stack of increasing order from back
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        ans[n-1] = 0;//last ele
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            //if the stack has smaller ele than curr pop it
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i])
            st.pop();

            //otherwise i will calculate the greater ele dis 
            if(!st.isEmpty()) ans[i] = st.peek() - i;
            else ans[i] = 0;
            //push that to stack
            st.push(i);
        }return ans;
    }
}
