package LockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition producercondition=lock.newCondition();
        Condition consumercondition=lock.newCondition();
        Resource02 resource02=new Resource02(lock,producercondition,consumercondition);
        ProducerThread2 producerThread01=new ProducerThread2(resource02);
        ProducerThread2 producerThread02=new ProducerThread2(resource02);
        ProducerThread2 producerThread03=new ProducerThread2(resource02);
        ConsumerThread2 consumerThread01=new ConsumerThread2(resource02);
        ConsumerThread2 consumerThread02=new ConsumerThread2(resource02);
        ConsumerThread2 consumerThread03=new ConsumerThread2(resource02);
        producerThread01.start();
        producerThread02.start();
        producerThread03.start();
        consumerThread01.start();
        consumerThread02.start();
        consumerThread03.start();


    }
}
