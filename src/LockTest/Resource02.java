package LockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Resource02 {
    private int num = 0;
    private int size = 20;
    private Lock lock;
    private Condition producercondition;
    private Condition consumerCondition;

    public Resource02(Lock lock, Condition producercondition, Condition consumerCondition) {
        this.lock = lock;
        this.producercondition = producercondition;
        this.consumerCondition = consumerCondition;
    }

    public void add() {
        lock.lock();
        if (num < size) {
            num++;
            System.out.println("生产者" + Thread.currentThread().getName() + "生产一个资源，目前资源数目" + num);
            consumerCondition.signalAll();
        } else {
            try {
                producercondition.await();
                System.out.println("生产者" + Thread.currentThread().getName() + "等待");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();

            }

        }
    }

    public void remove() {
        lock.lock();
        if (num > 0) {
            num--;
            producercondition.signalAll();
            System.out.println("消费者" + Thread.currentThread().getName() + "消耗一个资源,目前资源数目" + num);
        } else {
            try {
                consumerCondition.await();
                System.out.print("消费者" + Thread.currentThread().getName() + "等待中");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
