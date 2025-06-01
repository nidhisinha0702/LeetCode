package PatternRecursion;

public class Triangle {

	private static void triangle(int r, int c) {
		//base condition
		if(r == 0) return; 
		
		if(c < r) {
			System.out.print("*");
			triangle(r, c+1);
		}else {
			System.out.println();
			triangle(r-1, 0);
		}
	}
	
	private static void triangle2(int r, int c) {
		//base condition
		if(r == 0) return; 
		
		if(c < r) {
			triangle2(r, c+1);
			System.out.print("*");
		}else {
			triangle2(r-1, 0);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// WAP to print using recursion
		//* * * *
		//* * *
		//* *
		//*
		triangle(4, 0);
		triangle2(4, 0);
	}

}
