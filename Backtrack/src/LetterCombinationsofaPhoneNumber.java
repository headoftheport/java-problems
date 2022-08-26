import java.util.LinkedList;
import java.util.List;
import java.lang.StringBuilder;

public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        /*
         * Using FIFO Queue and BFS
         */
        
        LinkedList<String> ans = new LinkedList<String>();
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.length() == 0)
            return ans;
        ans.add("");
        
        for(int i = 0; i < digits.length(); i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length() == i){
                String t = ans.remove();
                for(char s : map[x].toCharArray())
                    ans.add(t+s);
            }
        }
        
        return ans;
        
    }


    public List<String> letterCombinations2(String digits) {
        /*
         * Using FIFO Queue and BFS
         */
        LinkedList<String> ans = new LinkedList<String>();
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.length() == 0)
            return ans;
       
        backtrack(digits, ans, map, 0, "");
        return ans;
        
    }

    public void backtrack(String digits, LinkedList<String> ans,String[] map, int index, String curr){

        if(index >= digits.length()){
            ans.add(curr.toString());
            return;
        }

        String value = map[digits.charAt(index)-'0'];
        for(char c: value.toCharArray()){
            backtrack(digits, ans, map, index+1, curr + c);
        }

        return;
    }



    
}
