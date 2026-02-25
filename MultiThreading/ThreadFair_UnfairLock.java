package MultiThreading;

import java.lang.Thread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadFair_UnfairLock {

        /**
         * <p>Lock type unfairLock, Instance of ReentrantLock ( prevent dead lock by allow re entring the lock ).
         * - Allow {@link #acquire()} method to Lock.
         * - Doesn't Gurantee the order ( unfair locking )
         */
        // private final Lock unfairLock = new ReentrantLock(); // ReentrantLock prevent dead lock by allow re entring the lock

        /**
         * <p>Lock type fairLock, Instance of ReentrantLock ( prevent dead lock by allow re entring the lock ).
         * - Allow {@link #acquire()} method to Lock.
         * - Gurantee the order ( fair locking )
         */
        private final Lock fairLock = new ReentrantLock(true); // ReentrantLock prevent dead lock by allow re entring the lock

        /**
         * - Acquire mathod that Acquire the Lock and releas it after some operations. 
         * 
         */
        private void accuire() {
            // unfairLock.lock();
            fairLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired the lock ");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }finally{
                System.out.println(Thread.currentThread().getName() + " releases the lock ");
                // unfairLock.unlock();
                fairLock.unlock();
                
            }
            
        }


    public class customThread extends Thread {

        /**
         * Create a costum thread with ( name ) that extends Thread Class.
         */
        customThread(String m) {
            super(m);
        }

        @Override
        public void run() {
            accuire();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadFair_UnfairLock t = new ThreadFair_UnfairLock();
        customThread t1 = t.new customThread("T1");
        customThread t2 = t.new customThread("T2");
        customThread t3 = t.new customThread("T3");
        t1.start();
        Thread.sleep(10);
        t2.start();
        Thread.sleep(10);
        t3.start();
        Thread.sleep(10);
        // try {
        //     t1.join();
        //     t2.join();

        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        //     Thread.currentThread().interrupt();
        // }

    }
}
