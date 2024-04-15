
import java.util.Comparator;


/**
 *
 * @author mmm
 */
public class TestTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Comparator cmp = new MiComparator();
        tree.insertNode(10, cmp);
        tree.insertNode(47, cmp);
        tree.insertNode(34, cmp);
        tree.insertNode(1, cmp);
        tree.insertNode(9, cmp);
        tree.insertNode(7, cmp);
        tree.insertNode(55, cmp);
        tree.insertNode(88, cmp);
        tree.insertNode(12, cmp);
        tree.insertNode(91, cmp);
        tree.insertNode(11, cmp);
        System.out.println("tree height: "+ tree.height());
        int[] arr = new int[tree.size()];
        Object[] e = tree.storeInOrder();
        for(int i = 0; i < tree.size(); i++){
            arr[i] = (int)e[i];
        }
        for(int i = 0; i < tree.size(); i++){
            System.out.println(arr[i]);
        }
        System.out.println("============after deleting: 1, 55, 11, 10.============");
        tree.deleteNode(1, cmp);
        tree.deleteNode(55, cmp);
        tree.deleteNode(11, cmp);
        tree.deleteNode(10, cmp);
        e = tree.storeInOrder();
        for(int i = 0; i < tree.size(); i++){
            arr[i] = (int)e[i];
        }
        for(int i = 0; i < tree.size(); i++){
            System.out.println(arr[i]);
        }
        System.out.println("min: "+ tree.min());
        System.out.println("max: "+ tree.max());
        System.out.println("tree height: "+ tree.height());
        System.out.println("predecessor of 47: "+ tree.findPredecesor(47, cmp));
        System.out.println("predecessor of 7: "+ tree.findPredecesor(7, cmp));
        System.out.println("predecessor of 9: "+ tree.findPredecesor(9, cmp));
        tree.insertNode(89, cmp);
        System.out.println("predecessor of 89: "+ tree.findPredecesor(89, cmp));
        System.out.println("succesor of 7: " +tree.findSuccesor(7, cmp));
        tree.insertNode(35, cmp);
        System.out.println("succesor of 35: " + tree.findSuccesor(35, cmp));
    }
}
