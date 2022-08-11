import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {

    // recursive solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }

    /*
     * time complexity : O(n)
     * space complexity: O(n), on average case O(logN)
     */

    // iterative solution
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        
        List<Integer> intList = new ArrayList<Integer>();
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        TreeNode node = root;
        
        while(node != null || !nodes.empty()){
            while(node != null){
                nodes.push(node);
                node = node.left;
            }
            
            node = nodes.pop();
            intList.add(node.val);
            node = node.right;
                
            
        }
        
        return intList;
        
    }

    /*
     * time complexity : O(n)
     * space complexity: O(n), on average case O(logN)
     */


    //  morris traversal
    public List<Integer> inorderTraversalMorris(TreeNode root) {
        
        List<Integer> intList = new ArrayList<Integer>();
        TreeNode curr = root;
        TreeNode pre = null;
        while(curr != null){
            if(curr.left == null){
                intList.add(curr.val);
                curr = curr.right;
            }
            else{
                pre = curr.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp = curr.left;
                curr.left = null;
                curr = temp;
            }
        }
        
        return intList;
            
        
    }
    
}
