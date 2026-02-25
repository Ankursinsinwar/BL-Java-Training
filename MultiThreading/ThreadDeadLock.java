package MultiThreading;



    class Resourse1 {
        public synchronized void task( Resourse2 Resourse2){
            System.out.println(Thread.currentThread().getName() + "- using Resourse1, waiting for Resource2 ");
            Resourse2.done();
        }
        public synchronized void done(){
            System.out.println(Thread.currentThread().getName() + " - Resourse1 done using Resource2 ");
        }
        

    }
    class Resourse2 {
        
        public synchronized void task( Resourse1 Resourse1){
            System.out.println(Thread.currentThread().getName() + "- using Resourse2, waiting for Resource1 ");
            Resourse1.done();
        }
        public synchronized void done(){
            System.out.println(Thread.currentThread().getName() + " - Resourse2 done using Resource1 ");
        }
    }




    class Thread1 implements Runnable {

        private Resourse1 R1;
        private Resourse2 R2;

        Thread1( Resourse1 R1,  Resourse2 R2 ) {
            this.R1 = R1;
            this.R2 = R2;
        }

        @Override
        public void run() {
            R1.task(R2);
        }
    }


    class Thread2 implements Runnable {

        private Resourse1 R1;
        private Resourse2 R2;

        Thread2( Resourse1 R1,  Resourse2 R2 ) {
            this.R1 = R1;
            this.R2 = R2;
        }

        // @Override
        // public void run() {
        //     R2.task(R1);
        // }

        @Override
        public void run() {
            synchronized(R1){ // resolves the dead lock
                R2.task(R1);
            }
        }
    }




public class ThreadDeadLock {
    public static void main(String[] args) {
        Resourse1 R1 = new Resourse1();
        Resourse2 R2 = new Resourse2();

        Thread T1 = new Thread(new Thread1(R1, R2));
        Thread T2 = new Thread(new Thread2(R1, R2));

        T1.start();
        T2.start();
    }

}