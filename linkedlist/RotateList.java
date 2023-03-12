package main.java;

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        int length = 1;
        
        while(fast.next != null){
            fast = fast.next;
            length = length + 1;
        }
        // System.out.println(length);
        int rem = k % length;
        // System.out.println(rem);
        if(rem == 0){
            return head;
        }
        
        fast = head;
        while(count < rem){
            fast = fast.next;
            count = count + 1;
        }
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode temp = slow.next;
        slow.next = null;
        fast.next = head;
        head = temp;
        
        return head;   
        
    }

    public ListNode rotateRightSolutionTwo(ListNode head, int k) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        int count = 1;
        
        while(count < k && fast.next != null) {
            fast = fast.next;
            count = count + 1;
        }
        
        if(fast.next == null){
            k = k % count;
        }
        
        if(k == 0){
            return head;
        }
        
        count = 0;
        fast = head;
        
        while(count < k){
            fast = fast.next;
            count = count + 1;
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode temp = slow.next;
        slow.next = null;
        fast.next = head;
        head = temp;
        
        return head;
           
    }

    public ListNode rotateRightSolutionThree(ListNode head, int k) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        int count = 1;
        ListNode last = head;
        
        for(; last.next != null; last = last.next)count++;
        
        k = k % count;
        
        if(k == 0)return head;
        
        ListNode temp = head;
        
        for(int i = 1; i < count-k;i++){
            temp = temp.next;
        }
        
        ListNode next = temp.next;
        temp.next = null;
        last.next = head;
        return next;
    }
    
}


/*
[1,2,3,4,5]
2
[0,1,2]
4
[]
0
[1,2]
0
 */