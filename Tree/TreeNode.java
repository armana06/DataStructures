package DataStructures.Tree;

import java.util.ArrayList;

public class TreeNode <T> {
    T element;
    ArrayList<TreeNode<T>> children;
    TreeNode<T> parent;
    public TreeNode (T elem) {
        element = elem;
        children = new ArrayList<>();
        parent = null;
    }
    public boolean equals(Object o) {
        if(o instanceof TreeNode) {
            return ((TreeNode) o).element.equals(this.element);
        }
        return false;
    }
    public String toString() {
        return element.toString();
    }

}
