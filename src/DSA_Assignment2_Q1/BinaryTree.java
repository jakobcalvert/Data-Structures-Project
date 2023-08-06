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
public class BinaryTree<E extends Comparable> {

    //initialises variables
    public int size;
    Node root;

    public BinaryTree() {

    }

    //function to add a node
    public void addNode(E data) {
        //creates the new node with the data given
        Node<E> dataNode = new Node<E>(data);
        
        //checks if there is a node at the root of the tree if not sets the node to the root
        if (this.root == null) {
            this.root = dataNode;
            this.size++;
            
        //checks if the new node is less than the root node if so then send the node to be compared with the left node
        } else if (this.root.compareTo(dataNode) > 0) {
            if (addNode(dataNode, this.root.left)) {
                this.root.left = dataNode;

            }

       //checks if the new node is greater than the root node if so then send the node to be compared with the right node
        } else if (this.root.compareTo(dataNode) < 0) {
            if (addNode(dataNode, this.root.right)) {
                this.root.right = dataNode;
            }
        }
    }

    //method to compare node to other nodes in the tree
    private boolean addNode(Node data, Node currentNode) {
        //if the node is empty returns true to tell function above to set the current node to the node we are adding
        if (currentNode == null) {
            this.size++;
            return true;
        //if the node is less than the current node sends it to be compared with the left node
        } else if (currentNode.compareTo(data) > 0) {

            if (addNode(data, currentNode.left)) {
                currentNode.left = data;
            }
        //if the node is greater than the current node sends it to be compared with the right node
        } else if (currentNode.compareTo(data) < 0) {

            if (addNode(data, currentNode.right)) {
                currentNode.right = data;
            }
        }
        //returns false if node has been added or is equal to the current node
        return false;
    }

    //Function to find a node in a binary tree
    public E findNode(E data) {
        //if the root is null the data is not contained in the tree
        if (this.root == null) {
            return null;
            
        //checks if the root node is greater than the data node 
        } else if (this.root.data.compareTo(data) > 0) {
            return findNode(data, this.root.left);
        //checks if the root node is less than the data node
        } else if (this.root.data.compareTo(data) < 0) {
            return findNode(data, this.root.right);
        }
        //if neigher of these were true than the root node is the node and the root node is returned
        return (E) this.root.data;

    }

    //method to find the node in lower parts of the tree than the root
    private E findNode(E data, Node currentNode) {
        //checks if the current node is null if it is the tree does not contain the node
        if (currentNode == null) {
            return null;
        //checks if the node to be found is less than the current node
        } else if (currentNode.data.compareTo(data) > 0) {
            return findNode(data, currentNode.left);
        //checks if the node to be found is greater than the current node
        } else if (currentNode.data.compareTo(data) < 0) {
            return findNode(data, currentNode.right);
        }
        //if neigher are true the current node is the node and the current node is returned
        return (E) currentNode.data;
    }

    //reverse order swaps the order of the nodes
    public void reverseOrder() {
        //if the root is not null that the object refferences for the left and right node are swaped
        if (this.root != null) {
            Node swap = this.root.left;
            this.root.left = this.root.right;
            this.root.right = swap;
            //the program then performs the same process down the tree
            reverseOrder(this.root.left);
            reverseOrder(this.root.right);
        }
    }

    //reverses the order of each node
    private void reverseOrder(Node node) {
        //if the node is not null then swaps the refferences for the left and right nodes
        if (node != null) {
            Node swap = node.left;
            node.left = node.right;
            node.right = swap;
            //repeats process down tree
            reverseOrder(node.left);
            reverseOrder(node.right);
        }
    }

    //traversal function prints out all of the elements in order from the lowest to the highest
    public void traversal() {
        //checks if root is null if not traverses to the left of the tree untill it hits the end of the line
        if (this.root != null) {
            //if all of the left nodes have been printed than starts printing the right nodes
            if (traversal(this.root.left)) {
                System.out.println(this.root.data.toString());
                traversal(this.root.right);
            }
        }

    }

    //traversal function to print out all of the elements in order
    private boolean traversal(Node current) {
        //checks if the current node is equal to null
        if (current != null) {
            //if not equal to null traverses to the left node untill there are no more left node and then prints all of the left node going up
            if (traversal(current.left)) {
               //once all of the left nodes have been  printed prints the right node
                System.out.println(current.data.toString());
                traversal(current.right);
                return true;
            }
        }
        //returns true if node has been completed
        return true;
    }
}
