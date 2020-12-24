public class Thread2 extends Thread {

    @Override
    public void run() {
        System.out.println("ПОТОК2 - - " + (int)Math.pow(Thread1.num,2));
    }
}