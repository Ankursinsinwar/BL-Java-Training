package MultiThreading;

public class ThreadLifeCycle extends Thread{

    @Override
    public void run(){
        System.out.println("Running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        ThreadLifeCycle t1 = new ThreadLifeCycle();
        System.out.println(t1.getState()); // NEW
        
        t1.start();
        System.out.println(t1.getState()); // RUNNABLE

        Thread.sleep(1000); // RUNNING
        System.out.println(t1.getState()); //TIMED_WATING
        
        t1.interrupt();
        System.out.println(t1.getState()); //TERMINATED

        t1.join();
        System.out.println(t1.getState()); //TERMINATED

        
    }
}
