package LockTest;

import java.util.Random;

public class ProducerThread2 extends Thread {
    private Resource02 resource02;

    public ProducerThread2(Resource02 resource02) {
        this.resource02 = resource02;
        setName("生产者");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            resource02.add();
        }
    }
}
