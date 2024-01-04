package DataStructures.BTree;

import java.util.ArrayList; 

public class BTree<T> {
    BTreeNode<T> root;

    public BTree (BTreeNode<T> a) {
        root = a;
    }

    public BTreeNode<T> getRoot() {
        return root;
    }
    //adds a node to the tree given its parent
    public void add(BTreeNode<T> root, BTreeNode<T> a) {
        if(root.child1 == null) {
            root.child1 = a;
            a.parent = root;
            return;
        }
        if(root.child2 == null) {
            root.child2 = a;
            a.parent = root;
            return;
        }
        else {
            throw new IllegalArgumentException("Already has 2 children");
        }
    }
    //prints the pre-order traversal
    public void prDTrav(BTreeNode<T> a) {    
        if(a != null) {
            System.out.println(a);
            poDTrav(a.child1);
            poDTrav(a.child2);
        }
    }
    //prints the post-order depth traversal
    public void poDTrav(BTreeNode<T> a) {    
        if(a != null) {
            prDTrav(a.child1);
            prDTrav(a.child2);
            System.out.println(a);
        }
    }
    //prints the in-order traversal
    public void ioTrav(BTreeNode<T> a) {
        if(a != null) {
            ioTrav(a.child1);
            System.out.println(a);
            ioTrav(a.child2);
        }
    }

    public static <T> boolean isIsomorphic(BTreeNode<T> a, BTreeNode<T> b) {
        if(a.child1.child1 == null && b.child1.child1 == null) {
            if((a.child1.equals(b.child1) && a.child2.equals(b.child2)) || (a.child1.equals(b.child2) && a.child2.equals(b.child1))) {
                return true;
            }
            else {
                return false;
            }
        }
        return isIsomorphic(a.child1, b.child1) && isIsomorphic(a.child2, b.child2);
    }
    
    /* public static void main(String []args) {
        BTreeNode<Integer> n1 = new BTreeNode<>(1);
        BTreeNode<Integer> n2 = new BTreeNode<>(1);
        BTree<Integer> a = new BTree<>(n1);
        BTree<Integer> b = new BTree<>(n2);
        BTreeNode<Integer> n3 =  new BTreeNode<Integer>(2);
        BTreeNode<Integer> n4 =  new BTreeNode<Integer>(3);
        BTreeNode<Integer> n6 =  new BTreeNode<Integer>(2);
        BTreeNode<Integer> n5 =  new BTreeNode<Integer>(3);
        BTreeNode<Integer> n7 =  new BTreeNode<Integer>(4);
        BTreeNode<Integer> n8 =  new BTreeNode<Integer>(5);
        BTreeNode<Integer> n9 =  new BTreeNode<Integer>(5);
        BTreeNode<Integer> n10 =  new BTreeNode<Integer>(4);
        a.add(n1, n3);
        a.add(n1, n4);
        b.add(n2, n5);
        b.add(n2, n6);
        a.add(n3, n7);
        a.add(n3, n8);
        b.add(n5, n10);
        b.add(n5, n9);
        a.ioTrav(a.getRoot());
        System.out.println();
        b.ioTrav(b.getRoot());
        System.out.println(BTree.isIsomorphic(a.root, b.root));
    }*/

}


