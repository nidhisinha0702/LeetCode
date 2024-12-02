package java_class;

import java.util.Scanner;

public class q_ll {
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	Node f=null;
	Node r=null;

			static Scanner sc = new Scanner(System.in);
			static int l;

					void enqueue() {
						System.out.println("Enter data");
						int data = sc.nextInt();
						Node new_node = new Node(data);
						if(f==null) {
							f=new_node;
							r=new_node;
						}else {
							r.next=new_node;
							r=new_node;
						}
					}
					
					void dequeue() {
						if(f==null) {
							System.out.println("underflow");
						}else {
							f=f.next;
						}
					}
					
					void display()
					{
						System.out.print("items are: ");
						Node temp=f;
						while(temp!=null) {
							System.out.print(temp.data);
							temp=temp.next;
						}
						
						
						System.out.println();
					}

					public static void main(String[] args) {
							
							
							q_ll q = new q_ll();
							do {
								
								System.out.println("PRESS 1 to push");
								System.out.println("PRESS 2 to pop");
								System.out.println("PRESS 3 to display");
								System.out.println("Enter your choice");
								int d = sc.nextInt();
								switch(d) {
								case 1:
									q.enqueue();
									break;
								case 2:
									q.dequeue();
									break;
								case 3:
									q.display();
									break;
								}System.out.println("ENTER 0 to go back to the main menu");
								System.out.println("ENTER any key to exit");
								l=sc.nextInt();
							}while(l==0);
							System.out.println("EXIT successfully");
							}
							




}
