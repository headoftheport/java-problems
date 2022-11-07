import java.util.HashMap;

public class FractionRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if(numerator == 0){
            return "0";
        }
        Boolean sign = ( numerator < 0 == denominator < 0 );
        if(sign == false){
            sb.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        if(num < den){
            sb.append("0");
        }
        else{
            sb.append(String.valueOf(num/den));
            num = num % den;
        }
        if(num > 0){
            sb.append(".");
        }

        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
        hm.put(num, sb.length());
        while(num != 0){
            num = num * 10;
            sb.append(String.valueOf(num/den));
            num = num % den;
            // System.out.println(num);
            if(hm.containsKey(num)){
                int index = hm.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            else{
                hm.put(num, sb.length());
            }
        }
        
        return sb.toString();
            
        
    }
    
}
