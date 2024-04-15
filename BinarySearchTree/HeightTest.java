
import java.util.Comparator;

/**
 *
 * @author mmm
 */
public class HeightTest {

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
        System.out.println("tree height: " + tree.IterativeHeight());
    }
}
