import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MaximumDepthofBinaryTree {
   /*
    * recursive solution
    * time complexity O(n)
    * space complexity O(1) 
    */
    public int maxDepth(TreeNode root) {
        
        if (root == null){
            return 0;
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        
    }

     /*
    * Iterative DFS solution
    * time complexity O(n)
    * space complexity O(n) 
    */

    public int maxDepthIterativeDFS(TreeNode root) {
        
        if (root == null){
            return 0;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> max = new Stack<Integer>();
        
        stack.push(root);
        max.push(1);
        Integer val = 0;
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            Integer tempMax = max.pop();
            val = Math.max(tempMax, val);
            if( temp.left != null){
                stack.push(temp.left);
                max.push(tempMax+1);
                    
            }
            if( temp.right != null){
                stack.push(temp.right);
                max.push(tempMax+1);
                    
            }
        }
        
        return val;
      
    }

    /*
    * Iterative BFS solution
    * time complexity O(n)
    * space complexity O(n) 
    */

    public int maxDepthBFS(TreeNode root) {
        
        Integer count = 0;
        if (root == null){
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<Integer> max = new Stack<Integer>();
        
        queue.offer(root);
        while(!queue.isEmpty()){
            Integer size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            count++;
        }
        
        
        return count; 
       
        
    }
}
