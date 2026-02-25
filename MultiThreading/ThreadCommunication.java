package MultiThreading;




    class SharedResourse {

        private int data;

        private boolean hasData;

        public synchronized void produce(int val){
            while (hasData) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            data = val;
            hasData = true;
            System.out.println("Producer " + val);
            notify();
        }
        public synchronized void consume(){
             while (!hasData) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            hasData = false;
            System.out.println("Consumer " + data);
            notify();
            // return data;
        }
        

    }





    class Producer implements Runnable {

        private SharedResourse R;

        Producer( SharedResourse R ) {
            this.R = R;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                R.produce(i);
                
            }
        }
    }


    class Consumer implements Runnable {

        private SharedResourse R;

        Consumer( SharedResourse R ) {
            this.R = R;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                R.consume();
                
            }
        }
    }




public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResourse R = new SharedResourse();

        Thread ConsumerThread = new Thread(new Consumer(R),"ConsumerThread");
        Thread ProducerThread = new Thread(new Producer(R),"ProducerThread");

        ConsumerThread.start();
        ProducerThread.start();
    }

}