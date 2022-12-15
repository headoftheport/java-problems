public class ConstructTreePreIn {
    
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        index = 0;
        return helper(preorder, inorder, 0, preorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        
        if(start > end){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[index++]);
        int pos = search(start, end, inorder,root.val);
        root.left = helper(preorder, inorder, start, pos-1);
        root.right = helper(preorder, inorder, pos+1, end);
        return root;
        
    }
    
    public int search(int start, int end, int[] inorder, int val){
        int point = -1;
        for(int i = start; i <= end; i++ ){
            if(inorder[i] == val){
                point = i;
                break;
            }
        }
        return point;
    }

    
}
