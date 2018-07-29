package geeksforgeeks.string;

public class StringInformation {

    /*
     * String toString() Method :
     *      When we print object reference, internally it is called toString Method
     *      ClassName@HashCode, UID for objects
     *      If there is no parent in Java Class, object will be parent class
     *      So if toString method is not defined in class, so object toString method will be invoked.
     *
     * boolean equals(Object obj1, Object 2)
     *      perform reference comparision
     *      Override in class so that you can perform content comparision
     *
     * compareTo Method
     *      compare based on lexical order, return 0 if equals else return +ve/-ve based on lexical values
     *
     *length vs length()
     *
     * String:
     *      In java String is immutable, we cannot change string content once it is created.
     *      String s1 == String s2 -> false because different objects have different reference
     *      String s1.equals(Sting s2) -> true because content is same
     *      String s = new String("ABC") -> create 1 object in Heap(s) and 1 in SCP(String Constant Pool) area
     *      String s = "ABC" -> create 1 object in SCP(s) area.
     *      Object creation in SCP is optional. First JVM check if object is already present in SCP
     *      with required content, if object is present, then existing object will be reused.
     *
     *      Five different memory areas in JVM
     *      - Heap area (Garbage Collector work here)
	 *      - Method area and runtime constant pool(SCP is present here & destroyed at JVM shutdown)
	 *      - JVM stack
	 *      - Native method stacks
     *      - PC registers
     *
     *
     * StringBuffer
     *      Provide mutable strings which can be modified using its methods.
     *      https://docs.oracle.com/javase/10/docs/api/java/lang/StringBuffer.html
     *      equals method and == operator both provide reference comparision.
     *      Thread safe, if one thread is using this, then other have to wait.
     *
     * StringBuilder
     *      Mutable but not thread safe.
     */
    public static void main(String[] args) {

    }
}
