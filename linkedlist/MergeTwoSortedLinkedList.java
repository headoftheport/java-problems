package main.java;

public class MergeTwoSortedLinkedList {

    public static ListNode mergeTwoLinkedList(ListNode list1, ListNode list2){

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        ListNode dummy = new ListNode();
        if(list1.val < list2.val){
            dummy.next = list1;
            list1.next = mergeTwoLinkedList(list1.next, list2);
        }
        else{
            dummy.next = list2;
            list2.next = mergeTwoLinkedList(list1, list2.next);
        }

        return dummy.next;
    }


    public static void main(String[] args){

         main.java.LinkedList newList = new main.java.LinkedList(new int[]{1,2,3,4,5});
         main.java.LinkedList newList2 = new main.java.LinkedList(new int[]{1,2,3,4,5});
         newList.printList();
 
 
         main.java.LinkedList returnedList = new main.java.LinkedList(mergeTwoLinkedList(newList.head, newList2.head));
         returnedList.printList();
 
     }
    
}
