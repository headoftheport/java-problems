import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

    public static List<Integer> nums = new ArrayList<Integer>();
    public static List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return nums;
        }  
        nums.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return nums;
        
    }

    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        if(root == null) {
            return nums;
        }
        TreeNode node = root;
        while(node != null){
            nums.add(node.val);
            
            if(node.right != null){
                nodes.push(node.right);
            }
            
            node = node.left;
            if(node == null && !nodes.empty()){
                node = nodes.pop();
            }
        }
        
        return nums;
        
    }
    
}


/*
 * preorderTraversal(recursive):
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 * preorderTraversal(iterative):
 * time complexity: O(n)
 * space complexity: O(n)
 */
