package CodeChef;

import java.util.Scanner;

public class SecondMax {

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int numLines = sc.nextInt();
		int a=0,b=0,c=0;
		int l=0,sl=0;
		for(int i=0;i<numLines;i++){
		    a = sc.nextInt();
		    b = sc.nextInt();
		    c = sc.nextInt();
		    if(a>b && a>c){
		        l = a;
		        if(b>c)
		        sl = b;
		        else
		        sl = c;
		    }else if(b>a && b>c){
		        l = b;
		        if(a>c)
		        sl=a;
		        else
		        sl=c;
		    }else{
		        l=c;
		        if(a>b)
		        sl=a;
		        else
		        sl=b;
		    }
		    System.out.println(sl);
		}
	}
}
