package main.java;
import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    ListNode head;

    public LinkedList(List<Integer> newList){
        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        for(int i=0; i < newList.size(); i++){
            ListNode hold = new ListNode(newList.get(i));
            curr.next = hold;
            curr = curr.next;
        }

        this.head = temp.next;
    }

    public LinkedList(int[] newList){
        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        for(int i=0; i < newList.length; i++){
            ListNode hold = new ListNode(newList[i]);
            curr.next = hold;
            curr = curr.next;
        }

        this.head = temp.next;
    }

    public LinkedList(ListNode head){
        this.head = head;
    }

    public void printList(){

        ListNode temp = head;
        List<Integer> holder = new ArrayList<Integer>();
        while(temp != null){
            holder.add(temp.val);
            temp = temp.next;
        }
        System.out.println(holder);
    }

}
