package main.java;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static RandomNode copyRandomList (RandomNode head) {
        
        RandomNode curr = head;
        RandomNode returnHead = new RandomNode(0);
        RandomNode itr = returnHead;
        
        HashMap <RandomNode, RandomNode> map = new HashMap <RandomNode, RandomNode>();
        
        while(curr != null){
            map.put(curr, new RandomNode(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null){
            
         RandomNode temp = map.get(curr);
            temp.random = map.get(curr.random);
            itr.next = temp;
            curr = curr.next;
            itr  = itr.next;
            
        }
        return returnHead.next;   
    }

    public RandomNode copyRandomListWithoutMap(RandomNode head) {
        
        RandomNode curr = head;
        while(curr != null){
            
            RandomNode temp = new RandomNode(curr.val);
            RandomNode nextUp = curr.next;
            curr.next = temp;
            temp.next = nextUp;
            curr = nextUp;
            
        }
        
        curr = head;
        
        while(curr != null && curr.next !=null){
            RandomNode copy = curr.next;
            if(curr.random == null){
                copy.random = null;
            }
            else{
                copy.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        
        curr = head;
        RandomNode dummyHead = new RandomNode(0);
        RandomNode itr = dummyHead;
        
        while(curr != null){
            
            RandomNode temp = curr.next;
            curr.next = temp.next;
            
            itr.next = temp;
            itr = itr.next;
            curr = curr.next;
            
        }
        
        return dummyHead.next;
        
        
    }


    Map<RandomNode, RandomNode> visited = new HashMap<RandomNode, RandomNode>();

    public RandomNode copyRandomListRecursive(RandomNode head) {
        
        if(head == null){
            return head;
        }
        if(visited.containsKey(head)){
            return visited.get(head);
        }
        
        RandomNode copy = new RandomNode(head.val);
        visited.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);
        
        return copy;
        
        
    }
    
}
