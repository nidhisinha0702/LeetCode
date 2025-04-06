package graph;

public class MaxNumGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println("The maximum number of graph that can be formed by n vertices are : "+count(n));
	}
	 static long count(int n) {
		    // code here
		    //maximum number of edges n vertices can have is
		    int e = n * (n-1)/2;
		    //maximum number of graph constructed out of n vertices are
		    return (long)(Math.pow(2,e));
		  }
}
