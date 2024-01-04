package DataStructures.Tree;

import java.util.*;


public class Tree <T> {
    TreeNode <T> root;
    int length;
    public Tree (TreeNode<T> r) {
        r.parent = null;
        root = r;
        length = 1;
    }
    public void add(TreeNode<T> parent, TreeNode<T> elem) {
        parent.children.add(elem);
        elem.parent = parent;
    }
    public int getDepth(TreeNode<T> d) {
        if(d.parent == null) {
            return 0;
        }
        return 1 + getDepth(d.parent);
    }
    public int getHeight(TreeNode<T> d) {
        if(d == null) {
            return 0;
        }
        if(d.children.isEmpty()) {
            return 0;
        }
        TreeNode <T> max = null;
        for(int i = 0; i < d.children.size(); i++) {
            if(getHeight(d) > getHeight(max)) {
                max = d;
            }
        }
        return 1 + getHeight(max);
    }
    /* public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(0);
        Tree<Integer> t = new Tree<Integer>(root);
        TreeNode<Integer> c1 = new TreeNode<Integer>(1);
        t.add(root, c1);
        System.out.println(t);
    } */
}
