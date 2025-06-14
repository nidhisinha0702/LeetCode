package greedy;

public class MinimumJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,1,4,1,1,1,2};
		System.out.println("minimum jump needed to reach end : "+jump(arr));

	}
	private static int jump(int[] nums) {
        //we will keep range with l and r
        int l = 0, r = 0, jumps = 0;
        //iterate untill reach last ind
        while(r < nums.length - 1){
            //farthes we can go from current range
            int farthest = 0;
            for(int i = l;i<=r;i++){
                farthest = Math.max(farthest, i + nums[i]);
            }
            //new range starts from where prev end + 1
            l = r + 1;
            r = farthest;
            jumps++;
        }return jumps;
    }
}
