package java_class;

import java.util.Scanner;

public class doubly_ll {

	public static void main(String[] args) {
		link_list ll = new link_list();
		ll.creation();
		ll.deletion();
		ll.traverser();

	}

	public void creation() {
		int data, m, p, n;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter data");
			data = sc.nextInt();
			Node new_node = new Node(data);
			if (head == null) {
				head = new_node;
				tail = new_node;
			} else {
				System.out.println(
						"Enter 1 to delete the item at begining ,2 to delete at the item at the end, 3 to delete the at specific location");
				m = sc.nextInt();
				switch (m) {
				case 1:
					new_node.next = head;
					head.prev = new_node;
					head = new_node;
					System.out.println("case 1 print ");
					break;
				case 2:
					tail.next = new_node;
					new_node.prev = tail;
					tail = new_node;
					System.out.println("case 2 print ");
					break;
				case 3:
					System.out.println("Enter the position of node to be added");
					p=sc.nextInt();
				        if (p == 1) {
				            if (head != null) {
				                new_node.next = head;
				                head.prev = new_node;
				            }
				            head = new_node;
				            return;
				        }

				        Node current = head;
				        int count = 1;

				        while (current != null && count < p - 1) {
				            current = current.next;
				            count++;
				        }

				        new_node.next = current.next;
				        if (current.next != null) {
				            current.next.prev = new_node;
				        }
				        current.next = new_node;
				        new_node.prev = current;
					/*
					 * System.out.println("Enter the position of node to be added"); p =
					 * sc.nextInt(); Node temp = head; //Node ptr = temp.next; for (int i = 1; i <
					 * (p - 1); i++) { temp = temp.next; //ptr = ptr.next; }
					 */
					/*new_node.prev = temp;
					new_node.next = ptr;
					temp.next = new_node;
					ptr.prev = new_node;*/
					/*
					 * temp.next.prev=new_node; new_node.next = temp.next; new_node.prev = temp;
					 * temp.next=new_node;
					 */
					System.out.println("case 3 print ");
					break;

				}
			}
			System.out.println("Do you want to add more data.If Yes press: 1");
			n = sc.nextInt();
		} while (n == 1);
	}

	 public void deletion() {

			int data,m,p,n;
			Scanner sc = new Scanner(System.in);
			do {
			System.out.println("Enter data");
			data = sc.nextInt();
			Node new_node = new Node(data);
			if(head == null) {
				System.out.println("LL is empty");
			}
			else {
				System.out.println("Enter 1 to delete the item at begining ,2 to delete at the item at the end, 3 to delete the at specific location");
				m=sc.nextInt();
				switch(m) {
				case 1:
					Node temp = head;
					temp=temp.next;
					head=temp;
					head.prev = null;
				break;
				case 2:
					Node temp1 = tail;
					temp1 = temp1.next;
					temp1.next = null;
					break;
				case 3:
					System.out.println("Enter the position of node to be deleted");
					p=sc.nextInt();
					Node temp2 = head;
					Node ptr1=temp2.next;
					for(int i=0;i<(p-2);i++) {
						temp2=ptr1;
						ptr1=ptr1.next;
					}
					temp2.next=ptr1.next;
					ptr1.next.prev=temp2;
					break;
					
				}
				
				
			}
			System.out.println("Do you want to delete more data.If Yes press: 1");
			n=sc.nextInt();
			}
			while(n==1);
			
	 }
	public void traverser() {
		Node temp = head;
		if (head == null) {
			System.out.println("LL does not exist");
		} else {
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}

	}

	Node head = null;
	Node tail = null;
}
