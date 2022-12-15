import java.util.List;
import javafx.util.Pair;  
import java.util.ArrayList;

public class CountAndSay {
    
    public String countAndSay(int n) {
        
        int start = 1;
        String val = "1";
        for(int i = 2; i <= n; i++ ){
            val = say(count(val));
            // System.out.println(val);
            
        }
        
        return val;
        
    }
    
    public List<Pair<Character, Integer>> count(String val){
        // System.out.println(val.length());
        int count = 0;
        char curr = '\0';
        List<Pair<Character, Integer>> list = new ArrayList<Pair<Character, Integer>>();
        for(int i = 0; i < val.length(); i++){
            if(curr == '\0'){
                curr = val.charAt(i);
            }
            // System.out.println(val.charAt(i));
            if(val.charAt(i) != curr){
                // System.out.println(curr);
                list.add( new Pair<Character, Integer>(curr, count));
                curr = val.charAt(i);
                count = 0;
            }
            count++;
        }
        list.add( new Pair<Character, Integer>(curr, count));
        
        return list;
    }
    
    public String say(List<Pair<Character, Integer>> list){
        StringBuilder sb = new StringBuilder();
        for( Pair<Character, Integer> pair: list){
            // System.out.println(pair.getValue());
            sb.append(pair.getValue());
            sb.append(pair.getKey());
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }


    public String countAndSay2(int n) {
        
        String val = "1";
        for(int i = 2; i <= n; i++ ){
            // System.out.println(val);
            val = helper(val);
            
        }
        return val;
        
    }


    public String helper(String val){
        StringBuilder sb = new StringBuilder();
        char c = val.charAt(0);
        int count = 1;
        for(int i = 1; i < val.length(); i++){

            if(val.charAt(i) == c){
                count++;
            }
            else{
                sb.append(count);
                sb.append(c);
                c = val.charAt(i);
                count = 1;
            }
        }

        sb.append(count);
        sb.append(c);
        return sb.toString();

    }

}
