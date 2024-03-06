package DataStructures.BTree;
import java.util.*;

class AVLNode {
    int element;
    int height;
    AVLNode left;
    AVLNode right;
    AVLNode(int elem) {
        this.element = elem;
        height = 0;
        left = null;
        right = null;
    }
    public String toString() {
        return ((Integer) element).toString();
    }
}
public class AVL {
    AVLNode root;
    public AVL(int i) {
        root = new AVLNode(i);
    } 
    public void add(int i) {
        add(i, root);
    }
    public void add(int i, AVLNode root) {
        add(i, root, 0);
    }
    public void add(int i, AVLNode root, int height) {
        if(root.left == null && i < root.element) {
            root.left = new AVLNode(i);
            return;
        } 
        if(root.right == null && i > root.element) {
            root.right = new AVLNode(i);
            return;
        }
        if(i > root.element) {
            add(i, root.right, height++);
        }
        else {
            add(i, root.left, height++);
        }
    }
    public boolean search(AVLNode root, int i) {
        if(root.element == i) {
            return true;
        } 
        if(i < root.element) {
            return search(root.left, i);
        }
        if(i >= root.element) {
            return search(root.right, i);
        }
        return false;
    }
    public void rightRotate(AVLNode root) {
        if(root.left == null) {
            return;
        }
        AVLNode newRight = root;
        AVLNode newLeft = root.left.right;
        root = root.left;
        root.right = newRight;
        root.right.left = newLeft;
    }
    public AVLNode leftRotate(AVLNode root) {
        AVLNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        return newRoot;
    }
    public String toString() {
        ArrayList<AVLNode> arr = new ArrayList<AVLNode>();
        Queue<AVLNode> bfs = new LinkedList<AVLNode>();
        arr.add(null);
        bfs.add(root);
        while(!bfs.isEmpty()) {
            AVLNode temp = bfs.remove();
            arr.add(temp);
            if(temp != null) {
                bfs.add(temp.left);
                bfs.add(temp.right);
            }
        }
        return arr.toString();
        
    }
    public static void main(String []args) {
        AVL test = new AVL(4);
        test.add(5);
        test.add(3);
        test.add(6);
        test.add(2);
        test.add(8);
        test.add(1);
        test.add(9);
        System.out.println(test);
        test.rightRotate(test.root);
        System.out.println(test);
    }
}
