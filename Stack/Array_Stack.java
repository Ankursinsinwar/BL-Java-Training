package Stack;

public class Array_Stack {
    static int arr[];
    static int size;
    
    Array_Stack(int n){
        this.size = n;
        this.arr = new int[n];
    }
    
    static int top = -1;

    public static boolean isEmpty() {
        return (top == -1);
    }
    public static boolean isFull() {
        return (top == size-1);
        
    }
    public static void push(int data) {
        if (isFull()) {
            System.out.println("Stack overfluw");
            return;
        }
        arr[++top] = data;
    }
    public static int pop() {
        if (isEmpty()) {
            System.out.println("Stack underfluw");
            return top;
        }
        return arr[top--];
        
    }
    public static int peek() {
        return arr[top];
    }

    public static void main(String[] args) {
        Array_Stack stack = new Array_Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("peek: "+stack.peek());//3
        System.out.println("pop: "+stack.pop());//3
        System.out.println("peek: "+stack.peek());//2
        stack.push(4);
        System.out.println("peek: "+stack.peek());//4
        System.out.println("pop: "+stack.pop());//4
        System.out.println("peek: "+stack.peek());//2
        stack.push(6);
        System.out.println("peek: "+stack.peek());//6
    }
}
