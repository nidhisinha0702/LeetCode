package Arrays;

public class pushZeroesToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] nums = {1, 2, 0, 4, 3, 0, 5, 0};
	        System.out.println("Before moving zeroes: ");
	        for (int num : nums) {
	            System.out.print(num + " ");
	        }

	        moveZeroes(nums);

	        System.out.println("\nAfter moving zeroes: ");
	        for (int num : nums) {
	            System.out.print(num + " ");
	        }
	}
	static void moveZeroes(int arr[]) {
		 int j=-1;
	        int n = arr.length;
	        //find the 1st 0 index
	        for(int i=0;i<n;i++){
	            if(arr[i]==0){
	                j=i;
	                break;
	            }
	        }
	       //if j=-1 there is no 0
	       if(j==-1) return;
	       //place i from j+1 and swap zero and non-zero elements
	       for(int i=j+1;i<n;i++){
	           if(arr[i]!=0){
	               int temp=arr[i];
	               arr[i]=arr[j];
	               arr[j]=temp;
	               j++;
	           }
	       }
	}

}
