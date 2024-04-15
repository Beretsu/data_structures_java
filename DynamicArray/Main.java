
/**
 *
 * @author mmm
 */
public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.addToEnd(1);
        arr.addToEnd(2);
        arr.addToEnd(3);
        arr.addToEnd(4);
        arr.removeAt(1);
        arr.addAt(8, 1);
        arr.addToEnd(0);
        arr.addToEnd(88);
        for (int i = 0; i < 10; i++) {
            arr.addToEnd(i*10);
        }
        System.out.println("size: "+arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.size(); i++){
            stack.push(arr.get(i));
        }
        System.out.println("stack size: " + stack.size());
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            stack.pop();
        }
        System.out.println("after pop");
        System.out.println("stack size: " + stack.size());
        stack.peek();
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
    }
}
