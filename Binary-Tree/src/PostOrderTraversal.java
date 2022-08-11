import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;

public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> returnList = new ArrayList<Integer>();
        return helper(root, returnList);  
        
    }

    public List<Integer> helper(TreeNode root, List<Integer> list){
        
        if(root == null){
            return list;
        }
        
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
       
        return list;
    }


    public List<Integer> postorderTraversalIterative(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        LinkedList<Integer> returnList = new LinkedList<Integer>();
        
        if(root == null){
            return returnList;
        }
        
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            returnList.addFirst(node.val);
            if(node.left != null){
                stack.add(node.left);
            }
            
            if(node.right != null){
                stack.add(node.right);
            }
            
                
        }
        
        return returnList;
        
    }

    public List<Integer> postorderTraversalIterative_2(TreeNode root) {
        
        
        List<Integer> returnList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if(root == null){
            return returnList;
        }
        
        stack.push(root);
        stack.push(root);
        
        while(!stack.empty()){
            TreeNode curr = stack.pop();
            if( !stack.empty() && curr == stack.peek()){
                if(curr.right != null){
                    stack.push(curr.right);
                    stack.push(curr.right);
                }
                
                if(curr.left != null){
                    stack.push(curr.left);
                    stack.push(curr.left);
                }
            }
            else {
                returnList.add(curr.val);
            }
            
            
        }
        
        return returnList;
            
        
        
    }
    
}
