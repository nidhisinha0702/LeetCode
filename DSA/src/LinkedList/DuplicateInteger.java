package LinkedList;

public class DuplicateInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,7,7,6,4,3,5};
		System.out.println("The suplicate number is : "+findDuplicate(nums));

	}
	private static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
