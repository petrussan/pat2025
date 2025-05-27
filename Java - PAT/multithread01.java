//public class multithread01 extends Thread {
public class multithread01 implements Runnable {

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            System.out.println("Thread "+Thread.currentThread().getId()+" : "+i);
//            System.out.println(i);
        }
        System.out.println("Thread "+Thread.currentThread().getId()+" finished");
    }
    
}
