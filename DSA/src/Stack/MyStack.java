package Stack;

public class MyStack {
	 private int[] arr;
	 private int top;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack s = new MyStack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.top());
		
	}
	 public MyStack() {
	        arr = new int[1000];
	        top = -1;
	    }

	    public void push(int x) {
	        // Your Code
	        top = top + 1;
	        arr[top] = x;
	    }

	    public int pop() {
	        // Your Code
	        int x = arr[top];
	        top = top - 1;
	        return x;
	    }
	    public int top() {
	    	return arr[top];
	    }
	    public int size() {
	    	return top + 1;
	    }
}
