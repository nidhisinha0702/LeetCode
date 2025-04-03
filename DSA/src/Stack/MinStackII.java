package Stack;

import java.util.Stack;

public class MinStackII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		MinStackII ob = new MinStackII();
		ob.push(8707, s);
		System.out.println(ob.min(s));
		

	}
	 int mini = Integer.MAX_VALUE;
		public void push(int a,Stack<Integer> s)
		{
		    //stack is empty
		    if(isEmpty(s)){
		        s.push(a);
		        mini = a;//update the mini with 1st val
		    }else{
		        //if new val is greater than we dont need to modify the mini
		        if(a>mini) s.push(a);
		        else {
		            //we modify the mini with new val and to preserve the prev mini we push 2*val-mini
		            s.push(2 * a - mini);
		            mini = a;   
		        }
		        
		    }
		}
		public int pop(Stack<Integer> s)
	        {
	            //st is empty
	            if(isEmpty(s)) return -1;
	            else{
	                int x = s.pop();
	                if(x < mini) {//if the top val is less than mini this was the modified val
	                    int y = mini; //we will return the mini so store in a var
	                    mini = 2 * mini - x;//go back to prev_mini
	                    return y;
	                }
	                return x;
	            }
		}
		public int min(Stack<Integer> s)
	        {
	          return mini;
		}
		public boolean isFull(Stack<Integer>s, int n)
	        {
	          return (s.size()==n);
		}
		public boolean isEmpty(Stack<Integer>s)
	        {
	          return s.isEmpty();
		}
}
