package Stack;

public class CelebrityProblem {

	//celebrity is known by everyone and celebrity should know no one
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = {{0,1,1,0},{0,0,0,0},{0,1,0,0},{1,1,0,0}};
		int celebrity = celebrity(matrix);
		System.out.println("The celebrity is: "+celebrity);
	}
	private static int findCelebrity(int mat[][]) {
		int n = mat.length;
		int knowMe[] = new int[n];
		int IKnow[] = new int[n];
		//iterate over the mat
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(mat[i][j]==1) {
					knowMe[j]++;
					IKnow[i]++;
				}
			}
		}
		//iterate over the array
		for(int i=0;i<n;i++) {
			if(knowMe[i]==n-1 && IKnow[i]==0)
				return i;
		}return -1;
	}
	private static int celebrity(int[][] mat) {
		//two pointer approach
		int n = mat.length;
		int top = 0;
		int bottom = n-1;
		//iterate row-wise
		while(top<bottom) {
			if(mat[top][bottom]==1)
				top++;
			else if(mat[bottom][top]==1)
				bottom--;
			else {
				top++;
				bottom--;
			}
		}if(top>bottom) return -1;
		//confirm if its a celebrity
		for(int i=0;i<n;i++) {
			if(top == i) continue;
			if(mat[top][i]==0 && mat[i][top]==1)
				return top;
			else
				return -1;
		}
		return -1;
	}

}
