package Contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
//TC-O(n^2) SC-O(n^m)
public class UniqueXorTripletsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {6,7,8,9};
		System.out.println("The number of unique xor triplet are : "+uniqueXorTriplets(nums));

	}
	private static int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<3) return n;
        //xor associative and commutative property
        //a^b^c = c^b^a
        //we will create a map and store unique key(a[i]^a[j]) and idx[j] pair
        HashMap<Integer,Integer> xor = new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int key = nums[i] ^ nums[j];
                if(!xor.containsKey(key))
                xor.put(key,j);
            }
        }
        
        //create a hashset for unique values from idx j to end
        HashSet<Integer> s = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry: xor.entrySet()){
            int c = entry.getKey();
            int idx = entry.getValue();
            for(int k=idx;k<n;k++){
                s.add(c ^ nums[k]);
            }
        }
        return s.size();
        
    }
}
