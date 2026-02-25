package MultiThreading;


public class Thread_AnonymousAndLambda {
    public static void main(String[] args) {

        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run(){
                System.out.println("Thread using anonymous class");
            }
        };

        Thread anonymousRunnableThread = new Thread(anonymousRunnable);
        anonymousRunnableThread.start();


        
        Runnable lambdRunnable = () -> System.out.println("Thread using Lambda Expration");

        Thread lambdRunnableThread = new Thread(lambdRunnable);
        lambdRunnableThread.start();
    }

}