package DataStructures.LinkedList;
public class Node <T> {
        T value;
        Node<T> next;
        Node<T> prev;
        public Node(T v, Node<T> n) {
            value = v;
            next = n;
        }
        public Node(T v, Node<T> n, Node<T> p) {
            this(v, n);
            prev = p;
        }
        public Node(T v) {
            this(v, null);
        }
        public T getValue() {
            return value;
        }
        public String toString() {
            return "" + value.toString();
        } 
}