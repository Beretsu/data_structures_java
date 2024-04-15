
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mmm
 * @param <E>
 */
public class MyHeap <E>{//min
    
    private final ArrayList<E> list;
    private int size;
    private final Comparator cmp;

    public MyHeap(Comparator cmp) {
        list = new ArrayList<>();
        this.cmp = cmp;
    }
    
    public MyHeap(E[] arr, Comparator cmp){
        list = new ArrayList<>();
        this.cmp = cmp;
        size = arr.length;
        list.addAll(Arrays.asList(arr));
        heapify();
    }
    
    private void  heapify(){
        for (int i = list.size()-1; i >= 0; i--) {
            tickleDown(i);
        }
    }
    
    public void insertNode(E data){
        list.add(size, data);
        int ref = size;
        int root = (ref-1)/2;
        while(ref != 0 && cmp.compare(list.get(ref), list.get(root)) < 0){
            Collections.swap(list, ref, root);
            ref = root;
            root = (ref-1)/2;
        }
        size++;
    }
    
    public E extract(){
        E val = list.get(0);
        Collections.swap(list, 0, size-1);
        size--;
        tickleDown(0);
        return val;
    }
    
    private void tickleDown(int root){
        int smallest = root;
        int left = 2*root+1;
        int right = 2*root+2;
        if(left < size && cmp.compare(list.get(smallest), list.get(left)) > 0){
            smallest = left;
        }
        if(right < size && cmp.compare(list.get(smallest), list.get(right)) > 0){
            smallest = right;
        }
        if(root != smallest){
            Collections.swap(list, root, smallest);
            tickleDown(smallest);
        }
    }
    
    public Object[] heapSort(){
        while(size != 0){
            extract();
        }
        return list.toArray();
    }
    
    public Object[] getArray(){
        return list.toArray();
    }
}
