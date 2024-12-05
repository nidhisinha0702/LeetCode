package Arrays;

public class MooreVotingAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 2, 1, 1, 1, 2, 2};
		int ans = majorityElement(arr);
	    System.out.println("The majority element is: " + ans);

	}
	private static int majorityElement(int[] arr) {
		int n = arr.length;
		int ele = Integer.MIN_VALUE;
		int cnt = 0;
		for(int i=0;i<n;i++) {
			if(cnt == 0) {
				cnt = 1;
				ele = arr[i];
			}else if(ele == arr[i]) {
				cnt += 1;
			}else {
				cnt--;
			}
		}
		//check if the count greater than n/2
		cnt = 0;
		for(int i=0;i<n;i++) {
			if(ele == arr[i]) cnt++;
		}
		
		int mini = (int)n/2;
		if(cnt > mini) 
		 return ele;
		return -1;
	}

}
