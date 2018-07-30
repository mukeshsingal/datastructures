## Map

* If we want to represent group of object key-value pairs. 
* Group of Entries (Single pair of Key/Value pair)
* Duplicate keys are not allowed.
* Each key/value pair is called Entry. Hence Map is considered as Entry Objects.
* Map(I) is not child of Collection(I)

|Keys|Values|
|---|---|
|101|Ram|
|102|Shyam|
|103|Rakesh|
|104|Bharat|


**Types of Map**
* Map -> HashMap -> LinkedHashMap
* Map -> IdentityHashMap
* Map -> WeakHashMap
* Map -> SortedMap -> NavigationalMap -> TreeMap
* Map -> HashTable -> Properties


**Map Interface Methods**
```java
interface Map{
   //Return null if key is new, else replace value with new value and return old value
   Object put(Object key, Object value);
   void putAll(Map map);
   //Return null if key is not present
   Object get(Object key);
   Object remove(Object key);
   boolean containsKey(Object key);
   boolean containsValue(Object value);
   boolean isEmpty();
   int size();
   void clear();
   
   interface Entry{
       Object getKey();
       Object getValue();
       Object setValue(Object value);
   }
}
```        

Map is collection of Entry object. Without map, Entry object cannot exist. Hence interface is defined
as inner interface.


## HashMap
* Internal data structure is HashTable
* Insertion order isn't preserved. Order is depend on hash code of keys.
* Duplicate Keys aren't allowed but duplicate values are allowed.
* Heterogeneous Kays/Values are allowed.
* Null is allowed for keys but only once. but value can be null any numbers of times. 
* Implemented Serializable and Cloneable but not RandomAccess.
* Best choice for search operation.

**Constructors** 
1. `HashMap map = new HashMap();` //Will Initialize HashMap for 16 EntrySets and 0.75 fill ratio.
2. `HashMap map = new HashMap(int initialCapacity);`
3. `HashMap map = new HashMap(int initialCapacity, float fillRatio);`
4. `HashMap map = new HashMap(Map m);`


```java
class Test{
    Map<Integer, String> map = new HashMap<>();
    Iterator itr = map.entrySet().getIterator(); 
    while(itr.hasNext()){
        Map.Entry entry = (Map.Entry) itr.next();
        System.out.println(entry.getKey() + entry.getValue())
    }
}
```

|HashMap| HashTable |
|---|---|
| All methods are not Synchronized | All methods are Synchronized |
| Not Thread Safe|Thread Safe as only only thread can access at a time. |
| Thread will not wait to access, so performance is high|Low performance relatively |
|null is allowed for key/value|null is not allow key/value|


**Convert HashMap to SynchronizedMap**
`Map map = Collections.synchronizeMap(HashMap m);`


## LinkedHashMap
|HashSet|LinkedHashSet|
|---|---|
| LinkedSet is child of HashSet | HashSet |
| In LinkedHashSet insertion order is preserved | Insertion order isn't preserved in HashSet|
| Inner Data Structure is HashTable | Inner Data Structure is LinkedList and HashTable |
 
Similarly 

|HashMap|LinkedHashMap|
|---|---|
| HashMap | LinkedHashMap is child of HashMap |
| Insertion order isn't preserved in HashSet |  In LinkedHashSet insertion order is preserved |
| Inner Data Structure is HashTable | Inner Data Structure is LinkedList and HashTable |
 
> In HashMap and LinkedHashMap JVM will use `.equals()` method to check duplicate keys.
```java
class temp{
    HashMap<Integer, String> map = new HashMap<>();
    Integer key1 = new Integer(10);
    Integer key2 = new Integer(10);

    map.put(key1, "value1");
    map.put(key2, "value2");

    System.out.println(map); //output: {10=value2}
}
```
## IdentityHashMap

> It is exactly same as HashMap in methods and constructors except in IdentityHashMap JVM will use `==` operator to check duplicate keys.

```java
class temp{
    IdentityHashMap<Integer, String> map = new IdentityHashMap<>();
    Integer key1 = new Integer(10);
    Integer key2 = new Integer(10);

    map.put(key1, "value1");
    map.put(key2, "value2");

    System.out.println(map); //output: {10=value1, 10=value2}
}
```

## WeakHashMap
It is exactly same as HashMap except the following difference. 

In case of hashMap even though object has no reference, it is not eligible for Garbage Collection if it is associate with 
hashMap. HashMap dominates GC. But in case of WeakHashMap, it is eligible for GC, even though object is associated with 
WeakHashMap.

```java
class Temp{
    public String toString(){
        return "temp";
    }
    public void finialize(){
        System.out.print("CleanUp is done");
    }
}

class Test{
    HashMap map = new HashMap<>();
    Temp t = new Temp();
    map.put(t, "Mukesh");
    System.out.println(m);
    t=null;
    System.gcc(); 
    
    /*
     * Here Garbage Collector cannot destroy 't' object but it is associated with HashMap. But
     * In WeakHashMap, Garbage Collector can destory object associated with WeakHashMap if object lost its
     * reference. 
     */
    
    Thread.sleep(5000);
    System.out.print(m); //output: t=Mukesh
}
``` 