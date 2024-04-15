
import java.util.Comparator;


/**
 *
 * @author mmm
 */
public class TestHeap {
    public static void main(String[] args) {
//        MyHeap<Integer> heap = new MyHeap<>(new MiComparador());
//        heap.insertNode(3);
//        heap.insertNode(4);
//        heap.insertNode(9);
//        heap.insertNode(12);
//        heap.insertNode(1);
//        heap.insertNode(93);
//        heap.insertNode(0);
//        Object[] arr = heap.heapSort();
//        int[] arreglo = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            arreglo[i] = (int)arr[i];
//            System.out.println(arreglo[i]);
//        }
        Integer[] a = {4,5,2,5,6,3,1,4,4,76,3,2,5,74,2,21,5,7,4,3,43,24,7,99,7,6,4};
        MyHeap heap = new MyHeap(a, new MiComparador());
        int[] arr = new int[a.length];
        Object[] ob = heap.heapSort();
        for (int i = 0; i < ob.length; i++) {
            arr[i] = (int)ob[i];
            System.out.println(arr[i]);
        }
    }
    
    private static class MiComparador implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
}
