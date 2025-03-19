package SlidingWindowTwoPointer;

public class PointsFromCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {6,2,3,4,7,2,1,7,1};
		int k = 4;
		System.out.println("The maximum score after picking k cards from left and right is : "+maxScore(arr, k));
	}
	private static int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, rightSum = 0, maxSum = 0;
        //iterate till k
        for(int i = 0;i<k;i++) leftSum += cardPoints[i];
        //assign the value to maxsum
        maxSum = leftSum;
        //start removing element from left and add from right
        int rind=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rind];
            rind--;
            //find the max 
            maxSum = Math.max(maxSum, leftSum+rightSum);
        }return maxSum;
    }
}
