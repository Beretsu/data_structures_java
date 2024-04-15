
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mmm
 * @param <E>
 */
public class BinarySearchTree<E> {

    private BSTNode root;
    private int size;

    private class BSTNode<E> {

        E data;
        BSTNode<E> left;
        BSTNode<E> right;

        BSTNode(E data) {
            this.data = data;
        }
    }

    public void insertNode(E data, Comparator obj) {
        root = insertNodeUtil(root, data, obj);
        size++;
    }

    private BSTNode insertNodeUtil(BSTNode<E> root, E data, Comparator obj) {
        if (root == null) {
            root = new BSTNode(data);
        } else if (obj.compare(data, root.data) <= 0) {
            root.left = insertNodeUtil(root.left, data, obj);
        } else {
            root.right = insertNodeUtil(root.right, data, obj);
        }
        return root;
    }
    
    public E min(){
        return findMin(root);
    }

    private E findMin(BSTNode root) {
        BSTNode<E> iterator = root;
        while (iterator.left != null) {
            iterator = iterator.left;
        }
        return iterator.data;
    }
    
    public E max(){
        return findMax(root);
    }

    private E findMax(BSTNode root) {
        BSTNode<E> iterador = root;
        while (iterador.right != null) {
            iterador = iterador.right;
        }
        return iterador.data;
    }
    
    public boolean exist(E data, Comparator cmp){
        return (search(data, cmp) != null);
    }

    private BSTNode search(E data, Comparator obj) {
        return searchUtil(root, data, obj);
    }

    private BSTNode searchUtil(BSTNode root, E data, Comparator obj) {
        if (root == null) {
            return null;
        }
        if (obj.compare(data, root.data) < 0) {
            return searchUtil(root.left, data, obj);
        }
        if (obj.compare(data, root.data) > 0) {
            return searchUtil(root.right, data, obj);
        }
        return root;
    }

    public int height() {
        return findHeight(root);
    }

    private int findHeight(BSTNode root) {
        if (root == null) {
            return -1;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return (left > right) ? left + 1 : right + 1;
    }

    public Object[] storePreLevelOrder() {
        if(root == null){
            return null;
        }
        BSTNode<E> iterator = root;
        MyQueue<BSTNode<E>> queue = new MyQueue<>();
        queue.enQueue(iterator);
        ArrayList<E> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            BSTNode<E> top = queue.front();
            if (top.left != null) {
                queue.enQueue(top.left);
            }
            if (top.right != null) {
                queue.enQueue(top.right);
            }
            E t = queue.deQueue().data;
            list.add(t);
        }
        return list.toArray();
    }

    public Object[] storePreOrder() {
        if(root == null){
            return null;
        }
        Stack<BSTNode<E>> stack = new Stack<>();
        ArrayList<E> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BSTNode<E> current = stack.peek();
            list.add(current.data);
            stack.pop();
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return list.toArray();
    }

    public Object[] storeInOrder() {
        if(root == null){
            return null;
        }
        Stack<BSTNode<E>> stack = new Stack<>();
        ArrayList<E> list = new ArrayList<>();
        stack.push(root);
        BSTNode<E> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.data);
            current = current.right;
        }
        return list.toArray();
    }

    public Object[] storePostOrder() {
        if(root == null){
            return null;
        }
        Stack<BSTNode<E>> s1 = new Stack<>();
        Stack<BSTNode<E>> s2 = new Stack<>();
        ArrayList<E> list = new ArrayList<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
            if (s2.peek().left != null) {
                s1.push(s2.peek().left);
            }
            if (s2.peek().right != null) {
                s1.push(s2.peek().right);
            }
        }
        while (!s2.isEmpty()) {
            list.add(s2.pop().data);
        }
        return list.toArray();
    }

    public void deleteNode(E data, Comparator cmp) {
        root = deleteNodeUtil(data, root, cmp);
        size--;
    }

    private BSTNode<E> deleteNodeUtil(E data, BSTNode<E> root, Comparator cmp) {
        if (root == null) {
            size++;
            return null;
        }
        if (cmp.compare(data, root.data) < 0) {
            root.left = deleteNodeUtil(data, root.left, cmp);
        } else if (cmp.compare(data, root.data) > 0) {
            root.right = deleteNodeUtil(data, root.right, cmp);
        } else {
            if (root.right != null && root.left != null) {
                E min = findMin(root.right);
                root.data = min;
                deleteNodeUtil(min, root.right, cmp);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }
    
    public E findPredecesor(E data, Comparator cmp){
        BSTNode<E> s = search(data, cmp);
        if(s == null){
            return null;
        }
        if(s.left != null){
            return findMax(s.left);
        }
        E predecessor = null;
        BSTNode<E> iterator = root;
        while(!s.data.equals(iterator.data)){
            if(cmp.compare(iterator.data, s.data) < 0){
                predecessor = iterator.data;
                iterator = iterator.right;
            }else{
                iterator = iterator.left;
            }
        }
        return predecessor;
    }
    
    public E findSuccesor(E data, Comparator cmp){
        BSTNode<E> s = search(data, cmp);
        if(s == null){
            return null;
        }
        if(s.right != null){
            return findMin(s.right);
        }
        E succesor = null;
        BSTNode<E> iterator = root;
        while(!s.data.equals(iterator.data)){
            if(cmp.compare(iterator.data, s.data)  > 0){
                succesor = iterator.data;
                iterator = iterator.left;
            }else{
                iterator = iterator.right;
            }
        }
        return succesor;
    }
    
    public int size(){
        return size;
    }
    
    public int IterativeHeight(){
        if(root == null){
            return -1;
        }
        Queue<BSTNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        int height = -1;
        while(true){
            int nodeCount = queue.size();
            if(nodeCount == 0){
                return height;
            }
            height++;
            while(nodeCount > 0){
                BSTNode<E> node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                nodeCount--;
            }
        }
    }
}
