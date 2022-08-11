import java.util.Scanner;

public class serDeser {

    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        
        if(root == null){
            return "#";
        }
        
        String str = Integer.toString(root.val);
        str += " " + serialize(root.left);
        str += " " + serialize(root.right);
        return str;
        
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        return helper(new Scanner(data));
    }
    
    public TreeNode helper(Scanner sc){
        if ( !sc.hasNext() ){
            return null;
        }
        String s = sc.next();
        if( s.equals("#")){
            return null;
        }
            
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(s);
        root.left = helper(sc);
        root.right = helper(sc);
        return root;
            
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
    
}
