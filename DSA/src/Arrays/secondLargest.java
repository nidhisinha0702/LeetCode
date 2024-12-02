package Arrays;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class secondLargest {
	//{ Driver Code Starts
	// Initial Template for Java
	    public static void main(String[] args) throws Exception {
	    		int[] arr= {5,4,10,9,-1,6};
	            int ans = getSecondLargest(arr);
	            System.out.println(ans);

	        }
// } Driver Code Ends

// User function Template for Java
	    public static int getSecondLargest(int[] arr) {
	        // Code Here
	        int largest=-1;
	        int sLargest=-1;
	        for(int i=0;i<arr.length;i++){
	            if(arr[i]>largest){
	                sLargest=largest;
	                largest=arr[i];
	            }else if(arr[i]<largest && arr[i]>sLargest){
	                sLargest=arr[i];
	            }
	        }return sLargest;
	    }

}
