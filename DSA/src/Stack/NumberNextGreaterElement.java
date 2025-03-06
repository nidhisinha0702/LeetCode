package Stack;

public class NumberNextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,4,2,7,5,8,10,6};
		int queries = 2;
		int indices[] = {0,5};
		int ans[] = count_NGEs(arr.length, arr, queries, indices);
		for(int i:ans)
			System.out.print(i+" ");

	}
	 public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
		    // code here
		    int ans[] = new int[queries];
		    for(int i=0;i<queries;i++)
		    {
		    	int ind=indices[i];
		    	int cnt = 0;
		    	for(int j = indices[i];j<N;j++) {
		    		if(arr[ind]<arr[j]) {
		    			cnt=cnt+1;
		    			System.out.println("the count is "+cnt);
		    		}
		    		ans[i]=cnt;
		    	}
		    }
		    
		    return ans;
		  }
	
}

