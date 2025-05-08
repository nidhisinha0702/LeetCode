package BST;

public class KthLargestNodeBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		
		int ans = kthLargest(root, 1);
		System.out.println("the val is :"+ans);

	}
	private static int kthLargest(TreeNode root, int k) {
        //cnt array to cnt the k small val
        int cnt[] = new int[1];
        cnt[0] = 0;
        int kLargest[] = new int[1];
        reverseinorder(root,k,cnt,kLargest);
        return kLargest[0];
    }
    private static void reverseinorder(TreeNode root, int k, int cnt[], int kLargest[]){
        if(root == null || cnt[0]>=k) return;
        
        reverseinorder(root.right,k,cnt,kLargest);
        cnt[0]++;
        if(cnt[0] == k){
        	kLargest[0] = root.val;
            return;
        }
        reverseinorder(root.left,k,cnt,kLargest);
    }
}
