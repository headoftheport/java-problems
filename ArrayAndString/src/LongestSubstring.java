import java.util.HashMap;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        /*
         * time complexity: O(n)
         * space complexity: O(min(m,n))
         */
        
        HashMap<Character, Integer> store = new HashMap<>();
        int count = 0;
        int lastDuplicate = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!store.containsKey(c)){
                store.put(c, i);
            }
            else{
                lastDuplicate = Math.max(lastDuplicate,store.get(c));
                store.put(c, i);
            }
            count = Math.max(count, i-lastDuplicate);
        }
        return count;
        
        
    }
    
}
