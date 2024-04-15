
/**
 *
 * @author mmm
 * @param <E>
 */
public class DoublyLinkedLinkedList<E> {
    
    private Node<E> head;
    private int size;
    
    public void addHead(E data){
        Node<E> newNode = new Node<>(null, data, head);
        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }
    
    public void addTail(E data){
        Node<E> newNode = new Node<>(null, data, null);
        if(head != null){
            Node<E> iterador = head;
            while(iterador.next != null){
                iterador = iterador.next;
            }
            iterador.next = newNode;
            newNode.prev = iterador;
        }else{
            head = newNode;
        }
        size++;
    }
    
    public void addAt(E data, int index){
        if(index >= 0 && index <= size){
            if(index == 0){
                addHead(data);
            }else{
                Node<E> node = getNode(index-1);
                Node<E> newNode = new Node<>(node, data, node.next);
                if(node.next != null){
                    node.next.prev = newNode;
                }
                node.next = newNode;
                size++;
            }
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void deleteAt(int index){
        if(index >= 0 && index < size){
            if(index == 0){
                head = head.next;
                head.prev = null;
            }else{
                Node<E> prevNode = getNode(index-1);
                prevNode.next = prevNode.next.next;
                if(prevNode.next != null){
                    prevNode.next.prev = prevNode;
                }
            }
            size--;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    public E get(int index){
        if(index >= 0 && index < size){
            return getNode(index).data;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void reverse(){
        Node<E> prev = null, current = head, next;
        while(current != null){
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    public int size(){
        return size;
    }
    
    private Node<E> getNode(int index){
        Node<E> iterador = head;
        for(int i = 0; i < index; i++){
            iterador = iterador.next;
        }
        return iterador;
    }

    private class Node<E> {

        E data;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
