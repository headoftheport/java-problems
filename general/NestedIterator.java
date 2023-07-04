import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    public List<NestedInteger> data;
    public Integer pos;
    public NestedIterator subList;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        
        this.data = nestedList;
        this.pos = -1;
        this.subList = null;
        
    }

    @Override
    public Integer next() {
        
        if(this.subList != null){
            return this.subList.next();
        }
        return this.data.get(pos).getInteger();
    }

    @Override
    public boolean hasNext() {
        
        if(this.subList != null && this.subList.hasNext()){
            return true;
        }
        this.subList = null;
        if(pos < data.size()-1){
            pos = pos + 1;
            if(data.get(pos).isInteger()){
                return true;
            }
            List<NestedInteger> tempList = data.get(pos).getList();
            this.subList = new NestedIterator(tempList);
            if(subList.hasNext()){
                return true;
            }
            subList = null;
            return hasNext();
        }
        
        return false;
        
    }
}

public class NestedIterator implements Iterator<Integer> {
    
    private List<Integer> data = new ArrayList<>();
    private int index = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger item: nestedList ){
            unroll(item);
        }
    }
    
    private void unroll(NestedInteger value){
        
        if(value.isInteger()){
            data.add(value.getInteger());
        }
        else{
            for(NestedInteger item: value.getList() ){
                unroll(item);
            }
        }
    }

    @Override
    public Integer next() {
        return data.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < data.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
