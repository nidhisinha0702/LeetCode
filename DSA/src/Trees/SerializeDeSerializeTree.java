package Trees;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeSerializeTree {

	public static void main(String[] args) {
		//[1,2,3,null,null,4,5]
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		String data = serialize(root);
		System.out.println("serialized above tree is : "+data);
		System.out.println("serialized above tree is : "+deserialize(data).val);
	}
	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res);
        
    }

    private static void dfsSerialize(TreeNode node, List<String> res){
        if(node == null){
            //adding a N for null
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String vals[] = data.split(",");
        int[] i = {0};
        return dfsDeserialize(vals, i);
    }

    private static TreeNode dfsDeserialize(String[] vals, int[] i){
        if(vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfsDeserialize(vals, i);
        node.right = dfsDeserialize(vals, i);
        return node;
    }
}
