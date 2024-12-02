package java_class;

import java.util.Scanner;

public class circularq_array {
			static Scanner sc = new Scanner(System.in);
			static int l;
			int f=-1,r=-1;
			int n=5;
			int q[]=new int[n];

					void enqueue() {
						if(f==(r+1)%n) {
							System.out.println("overflow condition");
						}else {
							System.out.println("enter data");
							int i= sc.nextInt();
							if(f==-1 && r==-1) {
								f=0;
								r=0;
								q[r]=i;
							}else {
								r=(r+1)%n;
								q[r]=i;
							}
						}
				
					}
					
					void dequeue() {
						if(f == -1 && r==-1) {
							System.out.println("Underflow condition");
						}else if(f==r) {
							System.out.println("underflow");
							f=-1;
							r=-1;
						}
						else {
							f = (f+1)%n;
							System.out.println("item deleted");
						}
					}
					
					void display()
					{
						int i;
						System.out.print("items are: ");
						for(i=f;i!=r;i=(i+1)%n) {
							System.out.print(q[i]+" ");
						}System.out.print(q[i]);
						System.out.println();
					}

					public static void main(String[] args) {
							
							
							circularq_array qarray = new circularq_array();
							do {
								
								System.out.println("PRESS 1 to enqueue");
								System.out.println("PRESS 2 to dequeue");
								System.out.println("PRESS 3 to display");
								System.out.println("Enter your choice");
								int d = sc.nextInt();
								switch(d) {
								case 1:
									qarray.enqueue();
									break;
								case 2:
									qarray.dequeue();
									break;
								case 3:
									qarray.display();
									break;
								}System.out.println("ENTER 0 to go back to the main menu");
								System.out.println("ENTER any key to exit");
								l=sc.nextInt();
							}while(l==0);
							System.out.println("EXIT successfully");
							}
							



}
