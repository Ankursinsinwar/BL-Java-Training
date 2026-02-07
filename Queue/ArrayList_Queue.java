package Queue;

import java.util.ArrayList;

public class ArrayList_Queue {
	static ArrayList<Integer> arr;

    ArrayList_Queue() {
        this.arr = new ArrayList<Integer>();

    }

    static int front = -1;
    static int rear = -1;

    public static boolean isEmpty() {
        return (rear == -1);
    }

    public static void enQueue(int data) {
        if (isEmpty()) {
            ++front;
        }
        ++rear;
        arr.add(rear, data);
    }

    public static int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue empty");
            return rear;
        }
        if (front == rear) {
            int data = arr.get(front);
            front = -1;
            rear = -1;
            return data;
        }
        int data = arr.get(front);
        ++front;
        return data;

    }

    public static int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr.get(front);
    }

    public static void main(String[] args) {
        ArrayList_Queue Queue = new ArrayList_Queue();
        Queue.enQueue(1);
        Queue.enQueue(2);
        Queue.enQueue(3);
        System.out.println("peek: " + Queue.peek());// 1
        System.out.println("deQueue: " + Queue.deQueue());// 1
        System.out.println("peek: " + Queue.peek());// 2
        Queue.enQueue(4);
        System.out.println("peek: " + Queue.peek());// 2
        System.out.println("deQueue: " + Queue.deQueue());// 2
        System.out.println("peek: " + Queue.peek());// 3
        Queue.enQueue(6);
        System.out.println("peek: " + Queue.peek());// 3
    }
}
