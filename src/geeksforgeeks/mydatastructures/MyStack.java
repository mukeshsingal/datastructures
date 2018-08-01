package geeksforgeeks.mydatastructures;

public class MyStack<T> {
    int top;
    int size;
    T[] array;

    MyStack(int size){
        this.size = size;
        top = -1;
        array = (T[]) new Object[size];
    }

    public void push(T item){
        if(isFull()){
            System.out.println("Stack Overflow");
        }
        else{
            top = top + 1;
            array[top] = item;
            System.out.println("Added " + item);
        }
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return null;
        }
        else{
            T item = array[top];
            top = top-1;
            System.out.println("Removed " + item);
            return item;
        }
    }

    public T peek() {
        if(isEmpty()){
            return null;
        }
        else{
            return array[top];
        }
    }

    public boolean isFull(){
        return  (top == size-1);
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack(4);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }
}
