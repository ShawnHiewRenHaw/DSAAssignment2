/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question3;

/**
 *
 * @author shawn
 */
public class Node {

    String name;
    int xPos;
    int yPos;
    Node left;
    Node right;

    public Node(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void setXPos(int x) {
        xPos = x;
    }

    public void setYPos(int y) {
        yPos = y;
    }
}
