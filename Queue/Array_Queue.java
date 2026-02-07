package Queue;

import Queue.Array_Queue;

public class Array_Queue {

    static int arr[];
    static int size;

    Array_Queue(int n) {
        this.size = n;
        this.arr = new int[n];
    }

    // static int front = -1;
    static int rear = -1;

    public static boolean isEmpty() {
        return (rear == -1);
    }

    public static boolean isFull() {
        return (rear == size - 1);

    }

    public static void enQueue(int data) {
        if (isFull()) {
            System.out.println("Queue overLoad");
            return;
        }
        arr[++rear] = data;
    }

    public static int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue empty");
            return -1;
        }
        int data = arr[0];
        --rear;
        for (int i = 0; i < size-1; i++) {
            arr[i] = arr[i+1];
        }
        return data;

    }

    public static int peek() {
        return arr[0];
    }

    public static void main(String[] args) {
        Array_Queue Queue = new Array_Queue(5);
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
