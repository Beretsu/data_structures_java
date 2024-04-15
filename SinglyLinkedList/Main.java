
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmm
 */
public class Main {
    public static void main(String[] args) {
        SiglyLinkedListImplementation<Integer> list = new SiglyLinkedListImplementation<>();
        list.addToHead(5);
        list.addToHead(6);
        list.addToHead(7);
        list.addToHead(9);
        list.addToTail(0);
        list.deleteAt(3);
        list.addAt(88, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(""+list.get(i));
        }
    }
}
