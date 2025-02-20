package Stack;

public class MyQueue {

	int front,rear;
	int q[] = new int[100005];
	int currSize = 0;
	int size = q.length;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue queue = new MyQueue();
		queue.push(4);
		queue.push(8);
		queue.push(3);
		System.out.println("Top of the queue before deleting any element:"+queue.top());
		System.out.println("Size of the queue before deleting any element:"+queue.size());
		System.out.println("The element deleted is:"+queue.pop());
		System.out.println("Size of the queue after deleting an element:"+queue.size());
		System.out.println("Top of the queue after deleting an element:"+queue.top());

	}
	MyQueue(){
		front = -1;
		rear = -1;
	}
	void push(int x) {
		if(currSize == 0) {
			front ++;
			rear ++;
		}else {
			rear = (rear + 1) % size;
		}
		q[rear] = x;
		currSize += 1;
	}
	int pop() {
		if(currSize == 0) return -1;
		int x= q[front];
		if(currSize == 1) {
			front = rear = -1;
		}else {
			front = (front + 1) % size;
		}
		currSize -= 1;
		return x;
	}
	int top() {
		return q[front];
	}
	int size() {
		return currSize;
	}

}
