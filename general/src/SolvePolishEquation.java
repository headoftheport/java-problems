import java.util.Stack;

public class SolvePolishEquation {
    int back;
    public int evalRPN(String[] tokens) {
        /*
         * using stack
         * time O(n)
         * space O(n)
         */
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(token.equals("+")  ||token.equals("-") || token.equals("/") || token.equals("*")){
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(calculate(op1, op2, token));
                // System.out.println(stack.peek());
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.peek();
    }
    
    public int calculate(int op1, int op2, String symbol){
        int ans = 0;
        switch(symbol){
            case "+":
                ans = op1 + op2;
                break;
            case "-":
                ans = op2 - op1;
                break;
            case "/":
                ans = op2 / op1;
                break;
            case "*":
                ans = op1 * op2;
                break;        
        }
        
        return ans;
    } 

    
    public int evalRPN2(String[] tokens) {
        /*
         * using recursion
         * time O(n)
         * space O(n)
         */
        back = tokens.length;
        return helper(tokens);
    }
    
    
    public int helper(String[] tokens){
        
        String token = tokens[--back];
        if(token.equals("+")  ||token.equals("-") || token.equals("/") || token.equals("*")){
            int second = helper(tokens);
            int first = helper(tokens);
            
            switch(token){
                case "+":
                    return first + second;
                case "-":
                    return first - second;
                case "*":
                    return first * second;
                case "/":
                    return first / second;
            }
        }
        
        return Integer.parseInt(token);
    }
}
