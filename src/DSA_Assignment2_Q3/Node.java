/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSA_Assignment2_Q3;

/**
 *
 * @author Jakob
 */
public class Node {

    //name to store the name of the node
    String name;
    //stores the x and y coordinate of the node
    int x;
    int y;
    //stores the nodes that this node has a path towards 
    String nextNode1;
    String nextNode2;
    //stores if the path is taken by the path finding algorithm
    boolean next1;
    boolean next2;

    //constructor
    public Node(String name, int x, int y, String nextNode1, String nextNode2) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.nextNode1 = nextNode1;
        this.nextNode2 = nextNode2;
        //currently set as false as the path finder algorithm hasn't been run
        this.next1 = false;
        this.next2 = false;
    }
}
