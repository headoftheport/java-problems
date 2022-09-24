import java.util.HashMap;

class Trie {
    
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.nodes.get(c) == null){
                curr.nodes.put(c, new TrieNode());
            }
            curr = curr.nodes.get(c);
        }
        
        curr.end = true;
    }
    
    public boolean search(String word) {
        
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.nodes.get(c) == null){
                return false;
            }
            curr = curr.nodes.get(c);
        }
        
        return curr.end == true;
    }
    
    public boolean startsWith(String prefix) {
        
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            if(curr.nodes.get(c) == null){
                return false;
            }
            curr = curr.nodes.get(c);
        }
        
        return true;
          
    }
}

class TrieNode {
    public HashMap<Character, TrieNode> nodes = new HashMap<Character, TrieNode>();
    public boolean end;
    
    public TrieNode(){
        for(int i = 0; i < 26; i++){
            nodes.put((char)('a' + i), null);
        }
        end = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */