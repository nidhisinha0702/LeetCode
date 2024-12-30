package BinarySearch;

public class MedianSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]matrix = {{1,3,5},{2,6,9},{3,6,9}};
		System.out.println("The median in a row-wise sorted matrix is::"+median(matrix));

	}
	private static int median(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            low = Math.min(low,mat[i][0]);//as all the rows are sorted hence for minimum value check 1st column
            high = Math.max(high,mat[i][m-1]);//maximum value check last column
        }
        int req = (m*n)/2;//median will be half of total elements
        while(low<=high){
            int mid = (low + high)/2;
            int smallerEquals = countSmallerEquals(mat,n,m,mid);//find all the values smaller then equal to median
            if(smallerEquals<=req) low = mid + 1;//check for more larger
            else high = mid - 1;//check for lesser value
        }return low;//opposite polarity
    }
    
   static int countSmallerEquals(int [][]mat,int n, int m, int x){
        int cnt = 0;
        for(int i=0;i<n;i++){
            cnt += upperBound(mat[i],m,x);//iterate over all the rows one by one to count smaller values(upperbound)
        }return cnt;
    }
   static int upperBound(int mat[],int n,int x){
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = (low + high)/2;
            if(mat[mid]>x){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }return ans;
    }
}
