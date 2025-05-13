package BST;

public class BSTFromPreorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int preorder[] = {8,5,1,7,10,12};
		TreeNode ans = bstFromPreorder(preorder);
		System.out.println("The root is : "+ans.val);
	}
	private static TreeNode bstFromPreorder(int[] preorder) {
        //pointer to treaverse the array
        int i[] = new int[1];
        return solve(preorder, i, Integer.MAX_VALUE);
    }

    private static TreeNode solve(int[] arr, int i[], int bound){
        if(i[0] == arr.length || arr[i[0]] > bound) return null;
        TreeNode root = new TreeNode(arr[i[0]++]);
        root.left = solve(arr, i, root.val);
        root.right = solve(arr, i, bound);
        return root;
    }
}
