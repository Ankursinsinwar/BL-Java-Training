package Stack;

import java.util.ArrayList;

public class ArrayList_Stack {
	static ArrayList<Integer> arr;
    
    ArrayList_Stack(){
        this.arr = new ArrayList<Integer>();
    }
    
    static int top = -1;

    public static boolean isEmpty() {
        return (top == -1);
    }
    
    public static void push(int data) {
        ++top;
        arr.add(data);
    }
    public static int pop() {
        if (isEmpty()) {
            System.out.println("Stack underfluw");
            return top;
        }
        return arr.remove(top--);
        
    }
    public static int peek() {
        return arr.get(top);
    }

    public static void main(String[] args) {
        ArrayList_Stack stack = new ArrayList_Stack();
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

