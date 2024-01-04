package DataStructures.LinkedList;
import java.util.Arrays;
import java.util.Iterator;

public class SLinkedList<T> implements Iterable<Node<T>>{
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public SLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
public class SLinkedIt implements Iterator<Node<T>> {
        Node<T> cur;
        public SLinkedIt(SLinkedList<T> a) {
            cur = a.head;
        }
        public Node<T> next() {
            Node<T> temp = cur;
            cur = cur.next;
            return temp;
        }
        public boolean hasNext() {
            return cur != null;
        }
    }
    public Iterator<Node<T>> iterator() {
       return new SLinkedIt(this) ;
    }
    public void add(int index, Node<T> n) throws IndexOutOfBoundsException {
        if(index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            if(head == null) {
                head = n;
                tail = null;
                size++;
                return;
            }
            n.next = head;
            head = n;
            size++;
        }
        Node<T> temp = head;
        for(int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<T> temp2 = temp.next;
        temp.next = n;
        n.next = temp2;
        size++;
        if(index == size - 1) {
            tail = n;
        }
    }
    public void add(Node<T> n) {
        if(size == 0) {
            head = n;
            size++;
            return;
        }
        if(tail == null) {
            Node<T> temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            tail = n;
            size++;
            return;
        }
        tail.next =  n;
        tail = n;
        size++;
    }
    public Node<T> remove(int index) throws IndexOutOfBoundsException {
        if(index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            Node<T> temp = head;
            head = head.next;
            size--;
            return temp;
        }
        Node<T> temp = head;
        for(int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<T> temp2 = temp.next;
        temp.next = temp.next.next;
        if(index == size - 1) {
            tail = temp;
        }
        size--;
        return temp2;
    }
    public void swap(int i, int j) {
        Node<T> a = this.head;
        Node<T> b = this.head;
        for(int in = 0; in < i; in++) {
            a = a.next;
        }
        for(int in = 0; in < j; in++) {
            b = b.next;
        }
        
        Node<T> temp = a.next.next;
        a.next.next = b.next.next;
        b.next.next = temp<T>;
        temp = a.next;
        a.next = b.next;
        b.next = temp;
    }
    public Node<T> get(int i) {
        Node<T> temp = head;
        for(int j = 0; j < i; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public int getSize() {
        return size;
    }
    public Node<T> getHead() {
        return head;
    }
    public Node<T> getTail() {
        return tail;
    }
    public String toString() {
        String s = "[";
        Node<T> temp = head;
        while (temp != null) {
            s += temp + ", ";
            temp = temp.next;
        }
        return s + "]";
    }
    /* public static void main(String[] args) {
        SLinkedList list = new SLinkedList();
        for(int i = 0; i < 50; i++) {
            Node n = new Node(i);
            list.add(n);
        }
        System.out.println(list);
        Iterator<Node> a = list.iterator();
        for(Node b : list) {
            System.out.print(b.value + ", ");
        }
    } */
}