import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class GroupAnagram {

    public String encode(String word){
        
        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < 25; i++){
            hm.put((char)('a'+ i), 0);
        }
        
        for(char j: word.toCharArray()){
            int count = hm.get(j);
            hm.put(j,++count);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry: hm.entrySet()){
            if(entry.getValue() != 0){
               sb.append(entry.getKey());
                sb.append(entry.getValue()); 
            } 
        }
        
        return sb.toString();
        
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
         * time complexity: O(total number of characters)
         * space complexity: O(nk)
         */
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            String code = encode(s);
            if( !map.containsKey(code)){
                map.put(code, new ArrayList<String>());
            }
            map.get(code).add(s);
        }
        
        List<List<String>> ret = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            ret.add(entry.getValue());
        }
        
        return ret;
    }
    
}
