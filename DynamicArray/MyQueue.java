
/**
 *
 * @author mmm
 * @param <E>
 */
public class MyQueue<E> {

    private int capacity = 10;
    private Object[] array;
    private int start;
    private int end = -1;
    private int size;

    public MyQueue() {
        array = new Object[capacity];
    }

    public MyQueue(int initialSize) {
        capacity = initialSize;
        array = new Object[capacity];
    }

    public void enQueue(E data) {
        if (size == capacity) {
            capacity = capacity * 2;
            Object[] temp = new Object[capacity];
            if (end < start) {
                for (int i = start; i < size; i++) {
                    temp[i - start] = array[i];
                }
                for (int i = 0; i < start; i++) {
                    temp[i + start] = array[i];
                }
            } else {
                for (int i = 0; i < size; i++) {
                    temp[i] = array[i];
                }
            }
            start = 0;
            end = size;
            array = temp;
        } else {
            end = (end + 1) % capacity;
        }
        array[end] = data;
        size++;
    }

    public E deQueue() {
        if (size == 0) {
            throw new EmptyQueueException();
        }
        E ret = (E) array[start];
        if (size == 1) {
            start = 0;
            end = -1;
            size--;
            return ret;
        }
        start = (start + 1) % capacity;
        size--;
        return ret;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E front() {
        return (E) array[start];
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (end <= start) {
            if (index >= end && index <= start) {
                return (E) array[index];
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            if (index >= start && index <= end) {
                return (E) array[index];
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }
    
    public int getCapacity(){
        return capacity;
    }

    public void print() {
        if (end < start) {
            for (int i = start; i < size; i++) {
                System.out.print(array[i]+", ");
            }
            for (int i = 0; i < start; i++) {
                System.out.print(array[i]+", ");
            }
            System.out.println();
        } else {
            for (int i = start; i < size; i++) {
                System.out.print(array[i]+", ");
            }
            System.out.println();
        }
    }
}
