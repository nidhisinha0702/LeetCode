package Trees;

import java.util.HashMap;

public class BuildTree {

	private static TreeNode buildTree(int[] preorder, int[] inorder) {
		 //inorder - left root right
        //preorder - root left right
        //the idea is to hash the inorder and find the root from the hash
        HashMap<Integer,Integer> map = new HashMap<>();
        //key are the values and val are the indices
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
	}
	
	private static TreeNode build(int[] pre, int preStIdx, int preEdIdx, int[] in, int inStIdx, int inEdIdx,  HashMap<Integer,Integer> map){
        //base condition
        if(preStIdx > preEdIdx || inStIdx > inEdIdx) return null;

        //create the root
        TreeNode root = new TreeNode(pre[preStIdx]);
        //recursivel go to left and right
        int inRootIdx = map.get(pre[preStIdx]);
        int numLeft = inRootIdx - inStIdx;

        //recursively call build with new pre and in arrays
        root.left = build(pre, preStIdx + 1, preStIdx + numLeft, in, inStIdx, inRootIdx - 1, map);
        root.right = build(pre, preStIdx + numLeft + 1, preEdIdx, in, inRootIdx + 1, inEdIdx, map);

        return root;
    }
	
	public static void main(String[] args) {
		//WAP to build tree from in and pre order
		int[] inorder = {9, 3, 15, 20, 7};
		int[] preorder = {3, 9, 20, 15, 7};
		
		System.out.println("The tree is :"+buildTree(preorder, inorder).val);
	}

}
