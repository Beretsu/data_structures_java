
/**
 *
 * @author mmm
 * @param <E>
 */
public class DynamicArray <E>{
    
    private int capacity = 10;
    private Object[] array;
    private int size;
    
    public DynamicArray(){
        array = new Object[capacity];
    }
    
    public DynamicArray(int initialSize){
        capacity = initialSize;
        array = new Object[capacity];
    }
    
    public void addToEnd(E element){
        ensureCapacity();
        array[size] = element;
        size++;
    }
    
    private void ensureCapacity(){
        if(size == capacity){
            capacity = capacity * 2;
            Object[] temp = new Object[capacity];
            for(int i = 0; i < size; i++){
                temp[i] = array[i];
            }
            array = temp;
        }
    }
    
    public void addAt(E element, int index){
        if(index >= 0 && index <= size){
            ensureCapacity();
            if(index != size){
                for(int i = size-1; i >= index; i--){
                    array[i+1] = array[i];
                }
            }
            array[index] = element;
            size++;
        }
    }
    
    public void removeAt(int index){
        if(index >= 0 && index < size){
            if(index < size-2){
                for(int i = index+1; i < size; i++){
                    array[i-1] = array[i];
                }
            }
            size--;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return 0 == size;
    }
    
    public E get(int index){
        if(index >= 0 && index < size){
            return (E)array[index];
        }
        throw new IndexOutOfBoundsException();
    }
}
