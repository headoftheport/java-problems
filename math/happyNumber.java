import java.util.HashSet;

public class happyNumber {

    public boolean isHappy(int n) {
        /*
         * uses the hashset
         * time complexity : O(logn)
         * spce = O(logn)
         */
        HashSet<Integer> hp = new HashSet<>();
        int sumValue = n;
        
        while(sumValue != 1){
            int temp = 0;
            // System.out.println(sumValue);
            while(sumValue > 0){
                // System.out.println("temp: "+temp+" sumValue: "+sumValue);
                temp += Math.pow((sumValue%10), 2);
                sumValue = sumValue / 10;
            }
            
            if(hp.contains(temp)){
                return false;
            }
            hp.add(temp);
            sumValue = temp;
        }
        
        return true;
    }

    public int getNext(int n){
        int temp  = 0;
        while(n > 0){
            temp += Math.pow((n%10), 2);
            n = n / 10;
        }
        
        return temp;
    }
    public boolean isHappy2(int n) {
        /*
         * uses the constat space
         * time complexity : O(logn)
         * spce = O(1)
         */
        int slow = n;
        int fast = getNext(n);
        
        while(fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        
        return fast == 1;
    }
    
}
