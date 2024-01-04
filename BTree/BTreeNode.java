package DataStructures.BTree;
public class BTreeNode<T> {
    T element;
    BTreeNode<T> child1;
    BTreeNode<T> child2;
    BTreeNode<T> parent;
    public BTreeNode (T elem) {
        element = elem;
        child1 = null;
        child2 = null;
        parent = null;
    }
    public boolean equals(Object o) {
        if(o instanceof BTreeNode) {
            return ((BTreeNode) o).element.equals(this.element);
        }
        return false;
    }
    public String toString() {
        return element.toString();
    }
    public static void main(String[] args) {
        System.out.println("World");
    }
}
