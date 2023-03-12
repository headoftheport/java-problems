package main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = head.next;
        
        while(evenNode != null && evenNode.next != null){
            oddNode.next = evenNode.next;
            evenNode.next = evenNode.next.next;
            oddNode = oddNode.next;
            evenNode = evenNode.next;     
                
        }
        
        oddNode.next = evenHead;
        return head;
            
        
    }

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("waiting for input...");
        String input = reader.readLine();
        String[] inputs = input.split(",");

        List<Integer> ints = Arrays.stream(inputs).map(Integer::parseInt).collect(Collectors.toList());

        main.java.LinkedList newList = new main.java.LinkedList(ints); 
        // main.java.LinkedList newList = new main.java.LinkedList(new int[]{1,2,3,4,5});
        newList.printList();


        main.java.LinkedList returnedList = new main.java.LinkedList(oddEvenList(newList.head));
        returnedList.printList();
 
     }
    
}
