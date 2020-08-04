public class ProducerConsumerWithWaitNofity {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer01 = new Producer(resource);
        Producer producer02 = new Producer(resource);
        Producer producer03 = new Producer(resource);
        Consumer consumer01 = new Consumer(resource);
        Consumer consumer02 = new Consumer(resource);
        Consumer consumer03 = new Consumer(resource);
        producer01.start();
        producer02.start();
        producer03.start();
        consumer01.start();
        consumer02.start();
        consumer03.start();

    }
}
