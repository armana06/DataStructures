package DataStructures.LinkedList;
public class DLinkedList<T> {
    private int size;
    //uses dummy head and tail to make edgecases easier to deal with
    private Node<T> dhead = new Node(Integer.MIN_VALUE);
    private Node<T> dtail = new Node(Integer.MAX_VALUE);

    public DLinkedList(Node<T> head) {
        size = 1;
        dhead.next = head;
        head.next = dtail;
        dtail.prev = head;
    }

    public DLinkedList() {
        size = 0;
        dhead.next = dtail;
        dtail.prev = dhead;
    }

    public void addFirst(Node<T> a) {
        //deals with adding the head to the List
        if(size == 0) {
            dhead.next = a;
            a.prev = dhead;
            a.next = dtail;
            dtail.prev = a;
        }
        Node<T> temp = dhead.next;
        dhead.next = a;
        a.prev = dhead;
        a.next = temp;
        size++;
    }
    
    public void add(int i, Node<T> a) {
        Node<T> temp = dhead;
        //deals with adding the head
        if(size == 0) {
            dhead.next = a;
            a.prev = dhead;
            a.next = dtail;
            dtail.prev = a;
        }
        //will either index from the head or tail, whichever is shorter
        if(Math.abs(0 - i) < Math.abs(i - size)) {
            for(int j = 0; j < i; j++) {
                temp = temp.next;
            }
        }
        else {
            temp = dtail;
            for(int j = size; j >= i; j--) {
                temp = temp.prev;
            }
        }
        a.prev = temp;
        a.next = temp.next;
        temp.next = a;
        size++;
    }

    public void addLast(Node<T> a) {
        //deals with adding the head 
        if(size == 0) {
            dhead.next = a;
            a.prev = dhead;
            a.next = dtail;
            dtail.prev = a;
        }
        Node<T> temp = dtail.prev;
        dtail.prev = a;
        a.next = dtail;
        a.prev = temp;
        temp.next = a;
        size++;
    }
    
    public Node<T> removeFirst() {
        Node<T> temp = dhead.next;
        dhead.next = dhead.next.next;
        dhead.next.prev = dhead;
        size--;
        return temp;
    }

    public Node<T> removeLast() {
        Node<T> temp = dtail.prev;
        dtail.prev = null;
        size--;
        return temp;
    }

    public String toString() {
        String s = "[";
        Node<T> temp = dhead.next;
        while(temp != dtail.prev.prev) {
            s += temp + ", ";
            temp = temp.next;
        }
        return s + temp +  "]";
    }
   public static void main(String[] args) {
        Node<Integer> a = new Node(5);
        Node<Integer> b = new Node(6);
        Node<Integer> c = new Node(7);
        Node<Integer> d = new Node(8);
        DLinkedList<Integer> list = new DLinkedList();
        list.add(0, a);
        list.addLast(b);
        list.addLast(c);
        list.addLast(d);
        System.out.println(list);
        System.out.println(Math.sqrt(1/2));

    } 
} 