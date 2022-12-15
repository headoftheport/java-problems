import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        
        if (root == null){
            return returnList;
        }
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            Integer size = queue.size();
            List<Integer> temp = new ArrayList<Integer>();
            for( Integer i = 0; i < size; i++){
                TreeNode curr = queue.remove();
                temp.add(curr.val);
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            returnList.add(temp);
           
        }
        
        return returnList;
    }


    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
       
        return Recursivehelper(root, returnList, 0);
       
       
   }
   
   public List<List<Integer>> Recursivehelper(TreeNode root, List<List<Integer>> lists, Integer level){
       if(root==null){
           return lists;
       }
       Integer len = lists.size();
       
       if(len <= level){
           lists.add(new ArrayList<Integer>());
       }
           
       lists.get(level).add(root.val);
       Recursivehelper(root.left, lists, level + 1);
       Recursivehelper(root.right, lists, level + 1);
       return lists;
           
   }
    
}
