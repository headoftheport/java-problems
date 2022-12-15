package main.java;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return divideAndMerge(lists, 0, lists.length-1);
    }
    
    public ListNode mergeLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(list1 != null || list2 != null){
            if(list1 == null){
                curr.next = list2;
                list2 = list2.next;
            }
            else if(list2 == null){
                curr.next = list1;
                list1 = list1.next;
            }
            else if( list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            
            curr = curr.next;
        }
        
        return dummy.next;
    }
    
    public ListNode divideAndMerge(ListNode[] lists, int start, int end){
        
        if(start == end){
            return lists[start];
        }
        
        if(end-start == 1){
            return mergeLists(lists[start], lists[end]);
        }
        
        ListNode left = divideAndMerge(lists, start, (start+end)/2);
        ListNode right = divideAndMerge(lists,(start+end)/2 + 1, end);
        
        return mergeLists(left, right);
    }
    
    
}