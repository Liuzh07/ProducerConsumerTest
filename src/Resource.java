import sun.awt.windows.ThemeReader;

public class Resource {
    public int num = 0;
    public int sum_num = 20;

    public synchronized void remove() {
        if (num > 0) {
            sum_num--;
            System.out.println("消费者" + Thread.currentThread().getName() + "消耗一个资源，当前资源数目" + num);
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者" + Thread.currentThread().getName() + "进入等待状态");
        }

    }

    public synchronized void add() {
        if (num < sum_num) {
            num++;
            System.out.println("生产者" + Thread.currentThread().getName() + "生产一个资源，当前资源数目" + num);
            notifyAll();
        } else {
            try {
                wait();
                System.out.println("生产者" + Thread.currentThread().getName() + "进入等待状态");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
