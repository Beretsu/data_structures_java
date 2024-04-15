
import java.util.Stack;

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
        DoublyLinkedLinkedList<Integer> doubly = new DoublyLinkedLinkedList();
        doubly.addHead(1);
        doubly.addHead(2);
        doubly.addHead(3);
        doubly.addTail(4);
        doubly.addHead(9);
        doubly.addTail(8);
        doubly.addAt(5, doubly.size()-1);
        doubly.reverse();
        System.out.println("el tamaño es: " + doubly.size());
//        System.out.println(doubly.get(1));
        for (int i = 0; i < doubly.size(); i++) {
            System.out.println(doubly.get(i));
        }
    }
}
