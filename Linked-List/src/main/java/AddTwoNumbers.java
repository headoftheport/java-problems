package main.java;

public class AddTwoNumbers {
    
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummyHead = new ListNode();
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        while(p != null || q != null){
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if( p != null) p = p.next;
            if ( q != null ) q = q.next;
        }

        if (carry > 0) curr.next = new ListNode(carry);
        return dummyHead.next;
    }

    public static ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2){

        if( l1 == null) return l2;
        if (l2 == null) return l1;

        int sum = l1.val + l2.val;

        if(sum < 10){
            ListNode node = new ListNode(sum);
            node.next = addTwoNumbersRecursive(l1.next, l2.next);
            return node;
        }
       
        ListNode node = new ListNode(sum % 10);
        node.next = addTwoNumbersRecursive(new ListNode(sum / 10), addTwoNumbersRecursive(l1.next, l2.next));
        return node;
        
    }

    public static void main(String[] args) {


         main.java.LinkedList newList = new main.java.LinkedList(new int[]{1,2,3,4,5});
         newList.printList();
         main.java.LinkedList newList2 = new main.java.LinkedList(new int[]{1,2,3,4,5});
         newList2.printList();
 
 
         main.java.LinkedList returnedList = new main.java.LinkedList(addTwoNumbersRecursive(newList.head, newList2.head));
         returnedList.printList();
 
     }
}
