import java.util.Stack;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        
        
        if (root == null){
            return true;
        }
        
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        nodes.push(root.left);
        nodes.push(root.right);
        
        while(!nodes.empty()){
            TreeNode rightNode = nodes.pop();
            TreeNode leftNode = nodes.pop();
            
            if(rightNode == null && leftNode == null){
                continue;
            }
            
            if(rightNode == null || leftNode == null){
                return false;
            }
            
            if(rightNode.val != leftNode.val){
                return false;
            }
            
            nodes.push(leftNode.left);
            nodes.push(rightNode.right);
            nodes.push(leftNode.right);
            nodes.push(rightNode.left);
                
            
        }
        return true;
        
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        return helper(root.left, root.right);
        
    }
    
    public boolean helper(TreeNode leftNode, TreeNode rightNode){
        
        if(leftNode == null && rightNode == null){
            return true;
        }
        
        if(leftNode == null || rightNode == null){
            return false;
        }
        
        if(leftNode.val != rightNode.val){
            return false;
        }
        
        return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left);
        
    }
}
