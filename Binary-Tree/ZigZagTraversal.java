import java.util.LinkedList;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

public class ZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        /*
         * using DFS
         * time complexity: O(n)
         * space complexity: O(logn) (queue)
         */
        
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        List<List<Integer>> returnList = new ArrayList<>();
        if(root == null){
            return returnList;
        }
        
        deque.offer(root);
        Boolean turn = false;
        while(deque.peek() != null){
            int len = deque.size();
            List<Integer> temp = new ArrayList<Integer>();
            while(len > 0){
                TreeNode node = deque.poll();
                if(turn){
                    temp.add(node.val);
                }
                else{
                    temp.add(0, node.val);
                }
                if(node.right != null){
                    deque.offer(node.right);
                }
                if(node.left != null){
                    deque.offer(node.left);
                }  
                len--;
            }
            returnList.add(temp);
            turn = !turn;
        }
        return returnList;
        
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        /*
         * using DFS
         * time complexity: O(n)
         * space complexity: O(logn) (recurssion stack)
         */
        List<List<Integer>> ans = new ArrayList<>();
        zigzag(root, ans, 0);
        return ans;
    }
    
    public void zigzag(TreeNode node, List<List<Integer>> ans, int level){
        if(node == null){
            return;
        }
        
        if(ans.size() <= level){
            ans.add(new ArrayList<Integer>());
        }
        
        if(level % 2 == 0){
            ans.get(level).add(node.val);
        }
        else{
            ans.get(level).add(0,node.val);
        }
        
        zigzag(node.left, ans, level+1);
        zigzag(node.right, ans, level+1);
    }
    
}
