**Map**

* If we want to represent group of object key-value pairs. 
* Group of Entries (Single pair of Key/Value pair)
* Duplicate keys are not allowed.
* Each key/value pair is called Entry. Hence Map is considered as Entry Objects.

Java 

Map -> HashMap -> LinkedHashMap
Map -> IdentityHashMap
Map -> WeakHashMap
Map -> SortedMap -> NavigationalMap -> TreeMap
Map -> HashTable -> Properties

Map(I) is not child of Collection(I)

|Keys|Values|
|101|Ram|
|102|Shyam|
|103|Rakesh|
|104|Bharat|


Map Interface Methods :
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


**HashMap**
* Internal data structure is HashTable
* Insertion order isn't preserved. Order is depend on hash code of keys.
* Duplicate Keys aren't allowed but duplicate values are allowed.
* Heterogeneous Kays/Values are allowed.
* Null is allowed for keys but only once. but value can be null any numbers of times. 
* Implemented Serializable and Cloneable but not RandomAccess.
* Best choice for search operation.

**Constructors** 
1. HashMap map = new HashMap(); //Will Initialize HashMap for 16 EntrySets and 0.75 fill ratio.
2. HashMap map = new HashMap(int initialCapacity);
3. HashMap map = new HashMap(int initialCapacity, float fillRatio)
4. HashMap map = new HashMap(Map m);



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


| HashMap | HashTable |
| All methods are not Synchronized | All methods are Synchronized |
| Not Thread Safe|Thread Safe as only only thread can access at a time. |
| Thread will not wait to access, so performance is high|Low performance relatively |
|null is allowed for key/value|null is not allow key/value|

Convert HashMap to SynchronizedMap 
Map map = Collections.synchronizeMap(HashMap m);
This map is thread-safe

 