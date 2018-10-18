package geeksforgeeks.ds;

public class MyLinkedStack<T> {

    MyLinkedList<T> stack = new MyLinkedList<>();


    public void push(T item) {
        stack.addToStart(item);
    }


    public T pop() {
        T item = peek();
        if (item != null) {
            stack.removeFromStart();
        }
        return item;
    }


    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return null;
        } else {
            return (T) stack.head.key;
        }
    }


    public boolean isFull() {
        return false;
    }


    public boolean isEmpty() {
        return stack.head == null;
    }

    public static void main(String[] args) {
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        stack.push(1);
        System.out.println(stack.peek());
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
    }
}
