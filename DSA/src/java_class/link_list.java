package java_class;

import java.util.Scanner;

public class link_list {

	public static void main(String[] args) {
		link_list ll = new link_list();
		ll.creation();
		ll.sorting();
		ll.traverser();
		ll.deletion();
		
		
	}
	public void creation() {
		int data,m,p,n;
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("Enter data");
		data = sc.nextInt();
		Node new_node = new Node(data);
		if(head == null) {
			head = new_node; //10
		}
		else {
			System.out.println("Enter 1 to insert the item at begining ,2 to insert at the item at the end, 3 to insert the at specific location");
			m=sc.nextInt();
			switch(m) {
			case 1:
				new_node.next = head;//30,20,10
				head = new_node;
			break;
			case 2:
				Node temp = head;
				while(temp.next!=null)
				{
					temp = temp.next;
				}
				temp.next = new_node;
				break;
			case 3:
				System.out.println("Enter the position of node to be inserted");
				p=sc.nextInt();
				Node temp1 = head;
				for(int i=0;i<(p-1);i++) {
					temp1=temp1.next;
				}
				new_node.next = temp1.next;
				temp1.next= new_node;
				break;
				
			}
			
			
		}
		System.out.println("Do you want to add more data.If Yes press: 1");
		n=sc.nextInt();
		}
		while(n==1);
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
			break;
			case 2:
				Node temp1 = head;
				Node ptr=temp1.next;
				while(ptr.next!=null)
				{
					temp1 = ptr;
					ptr=ptr.next;
				}
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
		if(head == null) {
			System.out.println("LL does not exist");
		}
		else {
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
		}
	}
	
	public void sorting() {
		int c = 0;
		if(head!=null) {
			Node temp = head;
			while(temp!=null) {
				temp=temp.next;
				c++;
			}
		}
		System.out.println("no of nodes: "+c);
		
		for(int i=0;i<c;i++) {
			for(int j=0;j<c-i-1;j++) {
				Node temp=head;
				Node temp1=temp.next;
				int d;
				if(temp.data>temp1.data) {
					d=temp.data;
					temp.data=temp1.data;
					temp1.data=d;
				}temp=temp1;
				temp1=temp1.next;
			}
		}
		System.out.println("sorted array is");
		Node temp2=head;
		while(temp2!=null) {
			System.out.print(temp2.data+" ");
			temp2=temp2.next;
		}
	}
	
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
		
	}
	Node head = null;
}
