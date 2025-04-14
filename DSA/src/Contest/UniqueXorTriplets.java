package Contest;

public class UniqueXorTriplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,1,2};
		System.out.println("The number of uniquexortriplets is : "+uniqueXorTriplets(nums));
	}
//All the numbers representable with the number of bits required to represent n.
	//so the triplets are 2^number_of_bits_in_n
	
	private static int uniqueXorTriplets(int nums[]) {
		int n = nums.length;
		if(n<3) return n;
		
		int cnt = 0;
		while(n>0) {
			n=n>>1;
			cnt++;
		}
		
		return (int)Math.pow(2, cnt);
	}
}
