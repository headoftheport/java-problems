public class ColumnNumber {

    public int titleToNumber(String columnTitle) {
        /*
         * iterative solution
         * time complexity: O(n)
         * space complexity: O(1)
         */
        int base = 26;
        int columValue = 0;
        for(char c: columnTitle.toCharArray()){
            int temp = c - 64;
            columValue = columValue * base + temp;    
        }
        
        return columValue;
        
    }
    
}
