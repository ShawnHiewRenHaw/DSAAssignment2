package Question1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author shawn
 * @param <E>
 */
public class Node<E extends Comparable> implements Comparable<Node> {

    private E data;
    private Node left;
    private Node right;

    public Node(E data) {
        this.data = data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node node) {
        if (node.data == this.data) {
            return 0;
        }
        if (node.data instanceof Integer) {
            return (Integer) node.data - (Integer) this.data;
        }
        if (node.data instanceof String) {
            return node.data.compareTo(this.data);
        }
        return 0;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
