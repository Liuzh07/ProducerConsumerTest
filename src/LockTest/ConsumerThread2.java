package LockTest;

public class ConsumerThread2 extends Thread {
    private Resource02 resource02;

    public ConsumerThread2(Resource02 resource02) {
        this.resource02 = resource02;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource02.remove();
        }
    }
}
