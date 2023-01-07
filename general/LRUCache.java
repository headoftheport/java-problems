package general;

class LRUCache {
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        protected Node(int key, int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
                
        }
        
    }
    
    private Node head;
    private int size;
    private int capacity;
    private HashMap<Integer, Node> store;
    private Node tail;
    
    
    private void addNode(Node node){
        
        node.prev =  head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
        
    }
    
    private void removeNode(Node node){
        
        Node pre = node.prev;
        Node nex = node.next;
        
        pre.next = nex;
        nex.prev = pre;
            
    }
    
    private Node popTail(){
        Node prev = tail.prev;
        removeNode(prev);
        return prev;
    }
    
    private void moveToFront(Node node){
        
        removeNode(node);
        addNode(node);
        
    }
    
    public LRUCache(int capacity) {
            
        this.capacity = capacity;
        size = 0;
        head = null;
        store = new HashMap<Integer, Node>();
        
        head = new Node(0,0);
        tail = new Node(0,0);
        
        head.next = tail;
        tail.prev = head;
        
        head.prev = null;
        tail.next = null;
        
            
    }
    
    public int get(int key) {
        
        if(!store.containsKey(key)){
            return -1;
        }
        Node curr = store.get(key);
        moveToFront(curr);
        return curr.value;
        
        
        
    }
    
    public void put(int key, int value) {
        
      
        if(store.containsKey(key)){
            Node curr = store.get(key);
            curr.value = value;
            moveToFront(curr);
        }
        else{
            
            Node temp = new Node(key, value);
            store.put(key, temp);
            addNode(temp);
            size++;
            if(size > capacity){
                Node t = popTail();
                store.remove(t.key);
                size--;
            }
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */