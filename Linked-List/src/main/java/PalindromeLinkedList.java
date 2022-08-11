package main.java;

public class PalindromeLinkedList {
    
    public static boolean isPalindrome(ListNode head) {
        
        ListNode mid = findTheMid(head);
        ListNode reverseHead = ReverseLinkedList.reverseList(mid.next);
        
        
        ListNode it1 = head;
        ListNode it2 = reverseHead;
        
        while(it1 != reverseHead && it2 != null ){
            System.out.println(it1.val);
            System.out.println(it2.val);
            
            if(it1.val != it2.val){
                return false;
            }
            it1 = it1.next;
            it2 = it2. next;
        }
        
        return true;
        
    }
    
    
    public static ListNode findTheMid(ListNode head){
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while(fastPointer.next != null && fastPointer.next.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
                
        }
        
        return slowPointer;
    }
    
    public static ListNode reverse(ListNode head){
        
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

    private static ListNode firstPointer;
    public static  boolean isPalindromeRecursive(ListNode head) {
        
       firstPointer = head;
       return recursivelyCheck(head);
    }
    
    public static boolean recursivelyCheck(ListNode node){
        if(node != null){
            if(!recursivelyCheck(node.next)){ return false;}
            if(node.val != firstPointer.val){return false;}
            firstPointer = firstPointer.next;
        }
        
        return true;
    }

    public static void main(String[] args){


        /*  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("waiting for input...");
         String input = reader.readLine();
         String[] inputs = input.split(",");
 
         List<Integer> ints = Arrays.stream(inputs).map(Integer::parseInt).collect(Collectors.toList());
 
         main.java.LinkedList newList = new main.java.LinkedList(ints); */
         main.java.LinkedList newList = new main.java.LinkedList(new int[]{1,2,2});
         newList.printList();
 
 
        //  main.java.LinkedList returnedList = new main.java.LinkedList(isPalindrome(newList.head));
        //  returnedList.printList();
        System.out.println(isPalindromeRecursive(newList.head));
 
     }
}
