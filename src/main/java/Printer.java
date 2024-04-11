public class Printer implements Runnable{
    private int number;
    private static Object lock = new Object();
    public Printer(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        while (true){
            synchronized (lock){
                if (Main.queue == this.number){
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    if (Main.queue==3){
                        Main.queue=1;
                    }else {
                        Main.queue++;
                    }
                    lock.notifyAll();
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {}
                }
            }
        }
    }
}
