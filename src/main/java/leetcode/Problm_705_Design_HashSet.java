package leetcode;

public class Problm_705_Design_HashSet {
    
}

class MyHashSet {
    private boolean[] set;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set=new boolean[100];
    }
    
    public void add(int key) {
        if (key>=set.length)
            extend(key);
        set[key]=true;
    }
    
    public void remove(int key) {
        if (key<set.length)
            set[key]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (key>=set.length)
            return false;
        else return set[key];
    }
    public void extend(int key) {
        set=Arrays.copyOf(set,key+1);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */