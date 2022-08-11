public class RightPointers {

    class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {
        
        Node rstart = root;
        
        while(rstart != null && rstart.left != null){
            Node n = rstart;
            
            while(true){
                n.left.next = n.right;
                
                if(n.next == null){
                    break;
                }
                n.right.next = n.next.left;
                n = n.next;     
            }
            
            rstart = rstart.left;
        }
        
        return root; 
        
    }


    public Node connectRecursive(Node root) {
        
        
        return helper(root, null);
        
    }
    
    public Node helper(Node curr,Node prev){
        
        if(curr == null){
            return curr;
        }
        
        if(prev != null){
            if(prev.right != curr){
                curr.next = prev.right;
            }
            else if(prev.next != null){
                curr.next = prev.next.left;
            }
        }
        
        helper(curr.left, curr);
        helper(curr.right, curr);
        return curr;
        
    }
    
}
