package main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        // if head is null then return null
        if( head == null){
            return null;
        }
        //check for other occurrence of the value after head
        head.next = removeElements(head.next, val);
        // if head is the value then return the next node
        if ( head.val == val){
            return head.next;
        }
        //otherwise return the head node
        return head;
        
      
    }

    public static ListNode removeElementsIterative(ListNode head, int val){

        while(head.val == val && head != null){
            head = head.next;
        }

        if(head == null){
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;


        while( curr != null){
            if(curr.val == val && prev == null){
                curr = curr.next;
                continue;
            }
            
            if(curr.val == val && prev != null){
                prev.next = curr.next;
                curr = curr.next;
                continue;
            } 
            
            prev = curr;
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) throws IOException{


         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("waiting for input...");
         String input = reader.readLine();
         String[] inputs = input.split(",");
         int input2 = Integer.parseInt(reader.readLine());;
 
         List<Integer> ints = Arrays.stream(inputs).map(Integer::parseInt).collect(Collectors.toList());
 
         main.java.LinkedList newList = new main.java.LinkedList(ints);
        // main.java.LinkedList newList = new main.java.LinkedList(new int[]{1,2,6,3,4,5,6});
         newList.printList();
 
 
         main.java.LinkedList returnedList = new main.java.LinkedList(removeElementsIterative(newList.head, input2));
         returnedList.printList();
 
     }
    
}
