package Question1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shawn
 */
public class BinaryTree<E extends Comparable> {

    private int size;
    private Node root;

    public BinaryTree(int size, Node root) {
        this.size = size;
        this.root = root;
    }

    //Adding new data into the tree
    public void add(E data) {
        //Checks if root is empty
        if (root == null) {
            root = new Node(data);
        } else {
            //Adds newNode into the tree
            Node newNode = new Node(data);
            add(root, newNode);
            ++this.size;
        }
    }

    public void add(Node root, Node newNode) {
        if (root.compareTo(newNode) > 0) {
            if (root.getLeft() != null) {
                add(root.getLeft(), newNode);
            } else {
                root.setLeft(newNode);
            }
        } else {
            if (root.getRight() != null) {
                add(root.getRight(), newNode);
            } else {
                root.setRight(newNode);
            }
        }
    }

    //Finding Node in a Binary Tree
    public E findNode(E data) {
        if (root == null) {
            return null;
        } else {
            return findNode(data, root);
        }
    }

    //Finds node using recursion
    public E findNode(E data, Node root) {
        //Returns data if current Node data equals data we're looking for
        if (root.getData().equals(data)) {
            return data;
        }
        //Goes to left branch if data has not been found and left node is not null
        if (root.getLeft() != null) {
            traversal(root.getLeft());
        }
        //Goes to right branch if data has not been found and left node is not null
        if (root.getRight() != null) {
            traversal(root.getRight());
        }
        return null;
    }

    //Dont forget to comment
    public void reverseOrder() {
        //If right is not null continue going down right
        if (root.getRight() != null) {
            traversal(root.getRight());
        }
        System.out.println(root);
        //If left is not null continue going down left
        if (root.getLeft() != null) {
            traversal(root.getLeft());
        }
    }

    //Traversal method
    public void traversal() {
        //Calls recursion traversal method that uses root
        traversal(root);
    }

    //Recursion traversal method
    public void traversal(Node root) {
        //If left is not null continue going down left
        if (root.getLeft() != null) {
            traversal(root.getLeft());
        }
        System.out.println(root);
        //If right is not null continue going down right
        if (root.getRight() != null) {
            traversal(root.getRight());
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
