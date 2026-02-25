package MultiThreading;

import java.lang.Thread;

public class ThreadCreate {
    
    public class Thread1 extends Thread {
        /**
         * Create a costum thread with ( name ) that extends Thread Class.
         */
        Thread1(String m){
            super(m);
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
                Thread.yield();
            }
        }
    }
    public class Thread2 implements Runnable {

        /**
         * Create a costum thread that implements Runnable interface.
         */
        Thread2(){

        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadCreate t = new ThreadCreate();
        Thread1 t1 = t.new Thread1("T1");
        t1.setDaemon(true); // end when main ends
        // t1.join();
        Thread2 tt = t.new Thread2();
        Thread t2 = new Thread(tt,"T2");
        t2.start();
        t1.start();
        // t2.join();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            Thread.yield();
        }
    }
}
