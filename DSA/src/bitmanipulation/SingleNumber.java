package bitmanipulation;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]= {4,1,2,1,2};
		System.out.println("the number that appear once is::"+singleNumber(num));
	}
	 private static int singleNumber(int[] nums) {
         int XOR=0;
        for(int i=0;i<nums.length;i++){
            XOR=XOR ^ nums[i];
        }
        return XOR;
    }
}
