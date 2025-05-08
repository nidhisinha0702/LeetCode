package BST;

public class KthSmallestNodeBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		
		int ans = kthSmallest(root, 1);
		System.out.println("the val is :"+ans);

	}
	private static int kthSmallest(TreeNode root, int k) {
        //cnt array to cnt the k small val
        int cnt[] = new int[1];
        cnt[0] = 0;
        int kSmall[] = new int[1];
        inorder(root,k,cnt,kSmall);
        return kSmall[0];
    }
    private static void inorder(TreeNode root, int k, int cnt[], int kSmall[]){
        if(root == null || cnt[0]>=k) return;
        
        inorder(root.left,k,cnt,kSmall);
        cnt[0]++;
        if(cnt[0] == k){
            kSmall[0] = root.val;
            return;
        }
        inorder(root.right,k,cnt,kSmall);
    }
}
