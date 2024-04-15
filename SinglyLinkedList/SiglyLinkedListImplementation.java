/**
 *
 * @author mmm
 * @param <E>
 */
public class SiglyLinkedListImplementation <E>{
    private Node<E> head;
    private int size;
    
    public void addToHead(E data){
        final Node<E> temp = new Node<>(data, head);
        head = temp;
        size++;
    }
    
    public void addToTail(E data){
        final Node<E> temp = new Node<>(data, null);
        if(head != null){
            Node<E> iterator = head;
            while(iterator.next != null){
                iterator = iterator.next;
            }
            iterator.next = temp;
        }else{
            head = temp;
        }
        size++;
    }
    
    public void addAt(E data, int index){
        if(index >= 0 && index <= countElements()){
            if(index == 0){
                addToHead(data);
            }else{
                Node<E> iterador = head;
                for (int i = 0; i < index-1; i++) {
                    iterador = iterador.next;
                }
                Node<E> temp = new Node<>(data, iterador.next);
                iterador.next = temp;
                size++;
            }
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void deleteAt(int index){
        if(index >= 0 && index < countElements()){
            if(index == 0){
                head = head.next;
            }else{
                Node<E> iterador = head;
                for (int i = 0; i < index-1; i++) {
                    iterador = iterador.next;
                }
                iterador.next = iterador.next.next;
            }
            size--;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void reverseList(){
        Node<E> prev = null, current = head, next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    public int size(){
        return size;
    }
    
    public E get(int index){
        if(index >= 0 && index < countElements()){
            return getNode(index).data;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    private Node<E> getNode(int index){
        Node<E> iterador = head;
        for (int i = 0; i < index; i++) {
            iterador = iterador.next;
        }
        return iterador;
    }
    
    private int countElements(){
        int count = 0;
        Node<E> iterador = head;
        while(iterador != null){
            iterador = iterador.next;
            count++;
        }
        return count;
    }
    
    private class Node<E>{
        E data;
        Node<E> next;
        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }
}
