package MultiThreading;

import java.lang.Thread;

public class ThreadCount {
    public static class Counter {
        private int count = 0;

        // /**
        //  * method with synchronized block that Increments the count.
        //  */
        // private void increment() {
        //     this.count++;
        // }

         /**
         * method with synchronized block that Increments the count.
         */
        private void increment() {
            synchronized(this){
                this.count++;
            }
        }

        // /**
        //  * synchronized method that Increments the count.
        //  */
        // private synchronized void increment() {
        //     this.count++;
        // }

        private int getCount() {
            return this.count;
        }
    }

    public class customThread extends Thread {
        private Counter counter;

        /**
         * Create a costum thread with ( name , Counter ).
         */
        customThread(String m, Counter counter) {
            super(m);
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    }

    public static void main(String[] args) {
        ThreadCount t = new ThreadCount();
        Counter counter = new Counter();
        customThread t1 = t.new customThread("T1", counter);
        customThread t2 = t.new customThread("T2", counter);
        t1.start();
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
