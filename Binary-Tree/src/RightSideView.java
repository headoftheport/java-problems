import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        /*
         * using DFS
         * time: O(n)
         * space: O(logn)
         */
        List<Integer> values = new ArrayList<>();
        dfs(root, 0, values);
        return values;
        
    }
    
    public void dfs(TreeNode node, int level,  List<Integer> values){
        if(node == null){
            return;
        }
        
        if(values.size() <= level){
            values.add(node.val);
        }
        
        dfs(node.right, level+1, values);
        dfs(node.left, level+1, values);
        return;
    }


    public List<Integer> rightSideView2(TreeNode root) {
        /*
         * using BFS
         * time: O(n)
         * space: O(logn)
         */
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return values;
        }
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == 0){
                    values.add(node.val);
                }
                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
            }
        }
        return values;
        
    }
    
}
