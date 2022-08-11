package main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;       
        }
        
        return prev;
            
    }

    public static ListNode reverseListRecursive(ListNode head) {
        
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rest;    
        
    }
    
    public static void main(String[] args) throws IOException {


       /*  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("waiting for input...");
        String input = reader.readLine();
        String[] inputs = input.split(",");

        List<Integer> ints = Arrays.stream(inputs).map(Integer::parseInt).collect(Collectors.toList());

        main.java.LinkedList newList = new main.java.LinkedList(ints); */
        main.java.LinkedList newList = new main.java.LinkedList(new int[]{1,2,3,4,5});
        newList.printList();


        main.java.LinkedList returnedList = new main.java.LinkedList(reverseListRecursive(newList.head));
        returnedList.printList();

    }
    
}
