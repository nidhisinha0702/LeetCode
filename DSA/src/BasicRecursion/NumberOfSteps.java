package BasicRecursion;

public class NumberOfSteps {

	private static int numberOfSteps(int num) {
		return helper(num, 0);
	}
	
	private static int helper(int num, int steps) {
		if(num == 0) return steps;
		
		if(num % 2 == 0) {
			return helper(num/2, steps + 1);
		}
		return helper(num - 1, steps + 1);
	}

	public static void main(String[] args) {
		// WAP to find the number of steps
		System.out.println(numberOfSteps(41));

	}

}
