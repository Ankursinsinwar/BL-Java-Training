package MultiThreading;

import java.lang.Thread;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock {
    public static class Counter {
        /**
         * count ( initialy at 0)
         */
        private int count = 0;

        /**
         * <p>Lock type countLock, Instance of ReentrantLock ( prevent dead lock by allow re entring the lock ).
         * - Allow {@link #increment()} method to Lock
         */
        private final Lock countLock = new ReentrantLock(); // ReentrantLock prevent dead lock by allow re entring the
                                                            // lock

        /**
         * Synchronized method that Increments the count.
         *
         * @see #getCount()
         */
        // private synchronized void increment() {
        // System.out.println(Thread.currentThread().getName() + " doing " +
        // this.getCount() + " + 1");
        // try {
        // Thread.sleep(5000);
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // Thread.currentThread().interrupt();
        // }
        // this.count++;
        // System.out.println(Thread.currentThread().getName() + " did it " +
        // this.getCount());

        // }

        /**
         * Locked mathod that Increments the count of the counter.
         *
         * @see #getCount()
         */
        private void increment() {
            System.out.println(Thread.currentThread().getName() + " doing " + this.getCount() + " + 1");
            try {

                if (countLock.tryLock(1000, TimeUnit.MILLISECONDS)) {

                    try {
                        Thread.sleep(5000);
                        this.count++;
                        System.out.println(Thread.currentThread().getName() + " did it " + this.getCount());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        Thread.currentThread().interrupt();
                    } finally {
                        countLock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " could not accuire look, try later ");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }

        }

        /**
         * Returns the count of the counter.
         *
         * @return count of the current counter
         * @see #increment()
         */
        private int getCount() {
            return this.count;
        }
    }

    public class customThread extends Thread {
        private Counter counter;

        /**
         * Create a costum thread with ( name, Counter ) that extends Thread Class.
         */
        customThread(String m, Counter counter) {
            super(m);
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }

    public static void main(String[] args) {
        ThreadLock t = new ThreadLock();
        Counter counter = new Counter();
        customThread t1 = t.new customThread("T1", counter);
        t1.start();
        customThread t2 = t.new customThread("T2", counter);
        t2.start();
        try {
            t1.join();
            t2.join();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
        System.out.println(counter.getCount());

    }
}
