package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFramework {
    public static void main(String[] args) {
        ExecutorService exicuter = Executors.newFixedThreadPool(2);
        Callable<Integer> callable = () -> 2;  // Runnable dont return anything, it does
        Future<Integer> future = exicuter.submit(callable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        if (future.isDone()) {
            System.out.println("Done");
        }
            
        
        // exicuter.submit(() ->  System.out.println("hii"));
        exicuter.shutdown();
    }
}
