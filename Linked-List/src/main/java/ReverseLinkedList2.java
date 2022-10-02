package main.java;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        while(left > 1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        
        ListNode leftNode = prev;
        ListNode rightNode = curr;
        
        while(right > 1){
            ListNode temp = rightNode.next;
            rightNode.next = temp.next;
            temp.next = curr;
            curr = temp;
            right--;
        }
        
        if(leftNode == null){
            return curr;
        }
        
        leftNode.next = curr;
        return head;
    }

    public ListNode successor = null;
    public ListNode reverseBetween2(ListNode head, int left, int right){
        if(left==1){
            return reverse(head, right);
        }

        head.next = reverseBetween2(head.next, left-1, right-1);
        return head;
    }

    public ListNode reverse(ListNode head, int n){
        if(n==1){
            successor = head.next;
            return head;
        }

        ListNode last = reverse(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    
}
