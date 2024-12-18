package BasicMaths;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		int p = n;
		int k = String.valueOf(p).length();
		int sum = 0;
		while(p>0){
			int rem = p%10;
			sum += Math.pow(rem, k);
			p = p/10;
		}
		if(n == sum)
		System.out.println(true);
		else
		System.out.println(false);

	}
}
