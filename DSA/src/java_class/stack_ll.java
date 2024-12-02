package java_class;

import java.util.Scanner;

public class stack_ll {

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
		static class Node{
			int data;
			Node next;
			Node(int data){
				this.data = data;
				this.next = null;
			}
		}
			Node top= null;
		
			void push() {
				System.out.println("enter data");
				int data = sc.nextInt();
				Node new_node = new Node(data);
				if(top == null) {
					top = new_node;
				}
				else {
					new_node.next=top;
					top=new_node;
				}
				
				System.out.println("item inserted");
			
		}
		
		void pop() {
			if(top == null) {
				System.out.println("Underflow");
			}
			else {
				top = top.next;
				System.out.println("item deleted");
			}
		}
		
		void display()
		{
			System.out.print("items are: ");
			Node temp = top;
			while(top!=null) {
				System.out.print(top.data+" ");
			}
			System.out.println();
		}
		
	}

