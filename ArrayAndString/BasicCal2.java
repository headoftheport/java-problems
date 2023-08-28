class Solution {
    public int calculate(String s) {
        /*
         * tc: n
         * sc: 1
         */
        int sum = 0;
        int tempSum = 0;
        char lastSign = '+';
        int num = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            if(Character.isDigit(s.charAt(i))){
                num = num * 10+ s.charAt(i) - '0';
            }
        
            if(i == s.length()-1 || !Character.isDigit(s.charAt(i)) && s.charAt(i) != ' '){
                
                switch(lastSign){
                        
                    case '+':
                        sum += tempSum;
                        tempSum = num;
                        break;
                    case '-':
                        sum += tempSum;
                        tempSum = -num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;
                }
                
                lastSign = s.charAt(i);
                num = 0;
            }
        }
        
        sum += tempSum;
        return sum;
    }
}
