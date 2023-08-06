/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSA_Assignment2_Q1;

/**
 *
 * @author Jakob
 * @param <E>
 */
public class Node <E extends Comparable>  implements Comparable <Node>  {
    //initialises variables 
    public E data;
    public Node left;
    public Node right;
    //sets the nodes data
    public Node(E data){
        this.data = data;
    }
    //compares the data in the node with other node
    @Override
    public int compareTo(Node o) {
        return data.compareTo(o.data);
    }
    
}
