package Stack;

import java.util.Stack;

public class MinStack {
	Stack<Long> stack;
    long mini = Long.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack s = new MinStack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Mininum element " + s.getMin());
        s.pop();
        System.out.println("Top of the stack after deleting an element " + s.top());

	}
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if(stack.isEmpty()){
            stack.push(val);
            mini = val;
        }else{
            if(mini < val) stack.push(val);
            else{
                stack.push(2*val - mini);
                mini = val;
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        Long x = stack.pop();
        if(x < mini){
            mini = 2 * mini - x;
        }
    }
    
    public int top() {
        Long x = stack.peek();
        if(x < mini) return (int)mini;
        return x.intValue();
    }
    
    public int getMin() {
        return (int)mini;
    }

}
