package linkedlist.divideandconquer;

import linkedlist.ListNode;
public class SortLinkedList {
    
    public ListNode sortList(ListNode head) {
        /* 
         * time: O(nlogn)
         * space: O(logn) recurssion stack
         */
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        
        
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        
        while(l1 != null && l2 != null){
            if( l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if(l1 != null){
            curr.next = l1;
        }
        
        if(l2 != null){
            curr.next = l2;
        }
        
        return dummyHead.next;
    }
 
    ListNode tail;
    ListNode newListNode;
    
    public ListNode sortList2(ListNode head) {
        /* 
         * time: O(nlogn)
         * space: O(logn) recurssion stack
         */
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode();
        ListNode start = head;
        int n = getCount(head);
        
        for( int i = 1; i < n; i = i * 2){
            tail = dummy;
            while(start != null){
                if(start.next == null){
                    tail.next = start;
                    break;
                }
                
                ListNode mid = getMid(start, i);
                merge2(start, mid);
                start = newListNode;
            }
            
            start = dummy.next;
        }
        
        return dummy.next;
        
    }
    
    public ListNode getMid(ListNode head, int size){
        ListNode slow = head;
        ListNode fast = head.next;
        
        for(int i = 1; i < size && ( slow.next != null || fast.next != null); i++){
            if(fast.next != null){
                fast = (fast.next.next != null) ? fast.next.next : fast.next;
            }
            if(slow.next != null){
                slow = slow.next;
            }
        }
        
        ListNode mid = slow.next;
        slow.next = null;
        newListNode = fast.next;
        fast.next = null;
        return mid;
    }
    
    public ListNode merge2(ListNode l1, ListNode l2){
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            
            curr = curr.next;
        }
        
        curr.next = (l1 != null) ? l1 : l2;
        
        while(curr.next != null){
            curr = curr.next;
        }
        
        tail.next = dummy.next;
        tail = curr;
        return dummy;
        
    }
    
    public int getCount(ListNode head){
        
        ListNode curr = head;
        int count = 0;
        
        while(curr != null){
            curr = curr.next;
            count++;
        }
        
        return count;
    }
}
