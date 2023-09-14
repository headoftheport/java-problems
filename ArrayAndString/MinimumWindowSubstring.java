class Solution {
    /*
     * two pointer
     * tc: m + n
     * sc: 1
     */
    public String minWindow(String s, String t) {
        
        int[] store = new int[128];
        
        for(char c: t.toCharArray()){
            store[c-'0']++;
        }
        
        int start = 0;
        int head = 0;
        int maxLen = s.length() + 1;
        int counter = t.length();
        
        for(int end = 0; end < s.length(); end++){
            
            char c = s.charAt(end);
            if(store[c-'0'] > 0){
                counter--;
            }
            store[c-'0']--;
            while(counter == 0 ){
                if( end - start < maxLen){
                    maxLen = end - start;
                    head = start;
                }
                store[s.charAt(start)-'0']++;
                if(store[s.charAt(start)-'0'] > 0){
                    counter++;
                }
                start++;
            }
        }
        return maxLen == s.length() + 1 ? "" : s.substring(head,head + maxLen + 1);
    }
}
