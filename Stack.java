package DataStructures;

import DataStructures.LinkedList.Node;
import DataStructures.LinkedList.SLinkedList;

public class Stack {
    SLinkedList stack;
    int size;
    public Stack() {
        stack = new SLinkedList();
        size = stack.getSize();
    }
    public void push(int i) {
        Node n = new Node(i);
        stack.add(0, n);
    }
    public int pop() {
        size--;
        return stack.remove(0).value;
    }
    
    public String toString() {
       return stack.toString();
    }
    /* public static void main(String[] args) {
        Stack a = new Stack();
        a.push(1);
        a.push(2);
        a.push(3);

        a.push(4);
        a.push(5);
        System.out.println(a);
    } */
}