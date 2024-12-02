package java_class;

import java.util.Scanner;

public class q_array {
	static Scanner sc = new Scanner(System.in);
	static int l;
	int f=-1,r=-1;
	int n=10;
	int q[]=new int[n];

			void enqueue() {
				if(r ==(n-1)) {
					System.out.println("overflow condition");
				}else {
					System.out.println("enter data");
					int i= sc.nextInt();
					if(f==-1 && r==-1) {
						f=0;
						r=0;
						q[r]=i;
					}else {
						r=r+1;
						q[r]=i;
					}
				}
		
			}
			
			void dequeue() {
				if(f == -1 && r==-1) {
					System.out.println("Underflow condition");
				}
				else {
					f = f+1;
					System.out.println("item deleted");
				}
			}
			
			void display()
			{
				System.out.print("items are: ");
				for (int j=f;j<=r;j++) {
					System.out.print(q[j]+" ");
				}
				System.out.println();
			}

			public static void main(String[] args) {
					
					
					q_array qst = new q_array();
					do {
						
						System.out.println("PRESS 1 to push");
						System.out.println("PRESS 2 to pop");
						System.out.println("PRESS 3 to display");
						System.out.println("Enter your choice");
						int d = sc.nextInt();
						switch(d) {
						case 1:
							qst.enqueue();
							break;
						case 2:
							qst.dequeue();
							break;
						case 3:
							qst.display();
							break;
						}System.out.println("ENTER 0 to go back to the main menu");
						System.out.println("ENTER any key to exit");
						l=sc.nextInt();
					}while(l==0);
					System.out.println("EXIT successfully");
					}
					


}
