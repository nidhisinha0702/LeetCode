package java_class;

import java.util.Scanner;

public class stack_array {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		stack_array st = new stack_array();
		int l;
	do {
		
		System.out.println("PRESS 1 to push");
		System.out.println("PRESS 2 to pop");
		System.out.println("PRESS 3 to display");
		System.out.println("Enter your choice");
		int d = sc.nextInt();
		switch(d) {
		case 1:
			st.push();
			break;
		case 2:
			st.pop();
			break;
		case 3:
			st.display();
			break;
		}System.out.println("ENTER 0 to go back to the main menu");
		System.out.println("ENTER any key to exit");
		l=sc.nextInt();
	}while(l==0);
	System.out.println("EXIT successfully");
	}
	
		int top = -1;
		int n = 10;
		int a[]= new int[n];
		void push() {
		if(top == (n-1)) {
			System.out.println("Overflow");
		}
		else {
			System.out.println("enter data");
			int i = sc.nextInt();
			top = top+1;
			a[top]=i;
			System.out.println("item inserted");
		}
	}
	
	void pop() {
		if(top == -1) {
			System.out.println("Underflow");
		}
		else {
			top = top-1;
			System.out.println("item deleted");
		}
	}
	
	void display()
	{
		System.out.print("items are: ");
		for (int j=top;j>=0;j--) {
			System.out.print(a[j]+" ");
		}
		System.out.println();
	}
}
