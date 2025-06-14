package greedy;

public class CanJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,4,1,1,0,2,5};
		System.out.println("Can Jump : "+canJump(arr));

	}
	 private static boolean canJump(int[] nums) {
	        //the idea is to cross 0 if we can cross it we can reach
	        int maxInd = 0;
	        //iterate over the array
	        for(int i=0;i<nums.length;i++){
	            //if at anytime we reach ind > maxInd which is false
	            //we cannot jump
	            if(i > maxInd) return false;
	            maxInd = Math.max(maxInd, i + nums[i]);
	            //optimize cond
	            if(maxInd >= nums.length - 1) return true;
	        }
	        return true;
	    }
}
