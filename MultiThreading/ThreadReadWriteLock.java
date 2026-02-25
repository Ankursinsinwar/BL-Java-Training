package MultiThreading;

import java.lang.Thread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadReadWriteLock {

    private int count = 0;

    /**
     * <p>
     * ReadWriteLock type look, Instance of ReentrantReadWriteLock ( prevent dead lock by allowing re entring the lock ).
     * Allow multiple threads to read and one thread to wright excessvly
     * 
     */
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    
    private final Lock readLook = lock.readLock();

    private final Lock writeLook = lock.writeLock();

      /**
         * method with synchronized block that Increments the count.
         */
        private void increment() {
            writeLook.lock();
            try {
                this.count++;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                writeLook.unlock();
            }  
            
        }

        // /**
        //  * synchronized method that Increments the count.
        //  */
        // private synchronized void increment() {
        //     this.count++;
        // }

        private int getCount() {
            readLook.lock();
            try {
                return this.count;
            }finally {
                readLook.unlock();
            } 
        }

    public class ReadThread extends Thread {

        /**
         * Create a costum thread with ( name ) that extends Thread Class.
         */
        ReadThread(String m) {
            super(m);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " read: " + getCount());
            }
        }
    }

    public class WriteThread extends Thread {

        /**
         * Create a costum thread with ( name ) that extends Thread Class.
         */
        WriteThread(String m) {
            super(m);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                increment();
                System.out.println(Thread.currentThread().getName() + " incremented: ");
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadReadWriteLock t = new ThreadReadWriteLock();
        WriteThread t1 = t.new WriteThread("Tw1");
        ReadThread t2 = t.new ReadThread("Tr1");
        ReadThread t3 = t.new ReadThread("Tr2");
        // ReadThread t4 = t.new ReadThread("T4");
        t1.start();
        t2.start();
        t3.start();
        // try {
        // t1.join();
        // t2.join();

        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // Thread.currentThread().interrupt();
        // }

    }
}
