package main.java;

public class IntersectionLikedList {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while(nodeA != nodeB){
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        
        return nodeA;
        
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        int lenA = length(headA);
        int lenB = length(headB);

        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }



    public int length(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}
