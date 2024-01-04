package DataStructures.Queue;
import java.util.Arrays;
public  class QueueArr {
    private int[]  queue;
    private int length;
    private int head;
    private int tail;
    public QueueArr() {
        queue = new int[5];
        length = 0;
        head =  0;
        tail  = -1;
    }
    public void enqueue(int a) {
        int indexNew = Math.abs((tail + 1)%queue.length);
        if(queue[indexNew] != 0) {
            resize();
        }
        indexNew = Math.abs((tail + 1)%queue.length);
        queue[indexNew] = a;
        tail = indexNew;
        length++;
    }
    public void resize() {
        int[] temp = new int[length * 2];
        int index = head;
        for(int i = 0; i < length; i++, index = (index + 1)%queue.length) {
            temp[i] = queue[index];
        }
        queue = temp;
    }
    public int dequeue() {
        int temp = queue[head];
        queue[head] = 0;
        length--;
        head =  Math.abs((head + 1)%queue.length);
        return temp;
    }
    public String  toString() {  
        return  Arrays.toString(queue) + " Head: "  +  head + " Tail: " + tail; 
    }
    /* public static void main(String[] args) {
        QueueArr a = new QueueArr();
        a.enqueue(1);
        System.out.println(a);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        System.out.println(a);
        a.dequeue();
        a.enqueue(6);
        a.dequeue();
        System.out.println(a);
        System.out.println(a.length);
    } */
}