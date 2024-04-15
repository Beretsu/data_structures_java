
/**
 *
 * @author mmm
 */
public class TestQueue {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        for(int i = 0; i < 50; i++){
            queue.enQueue(i);
        }
        System.out.println(queue.getCapacity());
        System.out.println(queue.size());
        queue.print();
        queue.deQueue();
        queue.deQueue();
        queue.print();
    }
}
