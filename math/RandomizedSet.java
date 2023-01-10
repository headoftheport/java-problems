import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;

class RandomizedSet {
    
    List<Integer> nums;
    HashMap<Integer, Integer> indexMap;

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        indexMap = new HashMap<Integer, Integer>();
    }
    
    public boolean insert(int val) {
        
        if(indexMap.containsKey(val)){
            return false;
        }
        
        indexMap.put(val, nums.size());
        nums.add(val);
        return true;
            
        
    }
    
    public boolean remove(int val) {
        
        if(!indexMap.containsKey(val)){
            return false;
        }
        
        int index = indexMap.get(val);
        int lastValue = nums.get(nums.size()-1);
        nums.set(index,lastValue);
        indexMap.put(lastValue, index) ;
        nums.remove(nums.size()-1);
        indexMap.remove(val);
        return true;
            
        
            
        
    }
    
    public int getRandom() {
        int index = (int)Math.floor(Math.random() * nums.size());
        return nums.get(index);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */