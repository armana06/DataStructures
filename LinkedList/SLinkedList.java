package DataStructures.LinkedList;
import java.util.Arrays;
import java.util.Iterator;

public class SLinkedList<T> implements Iterable<Node<T>>{
    //declaring our basic fields
    private Node<T> head;
    private Node<T> tail;
    private int size;
    //constructor
    public SLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    //This is our iterator class, don't worry about it if you've not learned about it just yet
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
    //Once again this is just for the interator interface, don't worry about it if you've not learned this just yet
    public Iterator<Node<T>> iterator() {
       return new SLinkedIt(this) ;
    }
   //Now down to the meat and potatoes, this adds an element at index n. Time complexity: O(index) 
    public void add(int index, T elem) throws IndexOutOfBoundsException {
        Node<T> n = new Node<T>(elem);
        //makes sure we can't try to put in an element past the length of the list
        if(index > size) {
            throw new IndexOutOfBoundsException();
        }
        //deals with the edge case of adding an element at the beginning
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
        //indexes through the list until we get to index - 1
        for(int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        //inserting the element, restoring the list properly
        Node<T> temp2 = temp.next;
        temp.next = n;
        n.next = temp2;
        size++;
        //updating the tail if needed
        if(index == size - 1) {
            tail = n;
        }
    }
    //adds an element to the end of the list. Time complexity: O(1)
    public void add(T elem) {
        Node<T> n =  new Node<T>(elem);
        //deals with adding to an empty list
        if(size == 0) {
            head = n;
            size++;
            return;
        }
        //deals with adding to a list of size 1
        if(tail == null) {
            head.next = n;
            tail = n;
            size++;
            return;
        }
        tail.next =  n;
        tail = n;
        size++;
    }
    //removes and returns the element at index, works pretty simiarly to add(). Time complexity: O(index)
    public T remove(int index) throws IndexOutOfBoundsException {
        if(index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            Node<T> temp = head;
            head = head.next;
            size--;
            return temp.value;
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
        return temp2.value;
    }
    //removes the first instance of elem from the list. Time complexity: O(n)
    public T remove(T elem) throws IllegalArgumentException  {
        Node<T> temp = head;
        for(int i = 0; i < size; i++) {
            if(elem.equals(temp.next.value)) {
                Node<T> temp2 = temp.next;
                temp.next =  temp.next.next;
                if(i == size - 1) {
                    tail = temp;
                }
                return temp2.value;
            } 
            temp = temp.next;
        }
        throw new IllegalArgumentException("Element not in the list");
    }
    //returns the value at index i. Time complexity: O(i)
    public T get(int i) {
        Node<T> temp = head;
        for(int j = 0; j < i; j++) {
            temp = temp.next;
        }
        return temp.value;
    }
    //returns the node at index i
    public Node<T> getNode(int i) {
        Node<T> temp = head;
        for(int j = 0; j < i; j++) {
            temp = temp.next;
        }
        return temp;
    }

    public int getSize() {
        return size;
    }
    //These are here in case we would like to index through the list without an iterator
    public Node<T> getHeadNode() {
        return head;
    }
    public Node<T> getTailNode() {
        return tail;
    }
    //returns the value of the head or tail
    public T getHeadValue() {
        return head.value;
    }
    public T getTailValue() {
        return tail.value;
    }

    public String toString() {
        String s = "[";
        Node<T> temp = head;
        while (temp != null) {
            if(temp.next == null) {
                s +=  temp;
            }
            else {
                s += temp + ", ";
            }
            temp = temp.next;
        }
        return s + "]";
    }
}