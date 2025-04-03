package Trees;

public class MaxNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		System.out.println("The maximum number of node at level i is : "+countNodes(i));
	}
	 static int countNodes(int i) {
	        // code here
	        return (int)Math.pow(2,i-1);
	    }
}
