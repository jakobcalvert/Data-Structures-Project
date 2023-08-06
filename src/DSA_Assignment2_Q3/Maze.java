/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSA_Assignment2_Q3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jakob
 */
public class Maze extends JPanel {

    //initialises variables
    int xSize;
    int ySize;
    int nLinkers;

    ArrayList<Node> nodes;

    //constructor to initialise the parameters of the maze
    public Maze(int x, int y, int nlink) {
        this.xSize = x;
        this.ySize = y;
        int nLinkers = nlink;
        this.nodes = new ArrayList<>();

        repaint();

    }

    //function to add node to nodes array
    public void addNode(Node node) {
        this.nodes.add(node);

    }

    //method to draw the maze onto the JPanel
    public void paint(Graphics g) {
        //loops through all of the nodes 
        for (Node element : this.nodes) {
            //loops through all of the nodes 
            for (Node element2 : this.nodes) {
                //checks if there is a path between element and element two
                if (element2.name.equals(element.nextNode1)) {
                    //if there is draws a line between the coordinates of node 1 (element) and node 2(element 2)
                    g.setColor(Color.orange);
                    g.drawLine((element.x + 1) * 50 + 10, (element.y + 1) * 50 + 10, (element2.x + 1) * 50 + 10, (element2.y + 1) * 50 + 10);
                    //if the next one variable is true it means that the path takes this path so it is drawn as green
                    if (element.next1) {
                        g.setColor(Color.green);
                        g.drawLine((element.x + 1) * 50 + 10, (element.y + 1) * 50 + 10, (element2.x + 1) * 50 + 10, (element2.y + 1) * 50 + 10);

                    }
                    //does the same process with the second path of the node
                } else if (element2.name.equals(element.nextNode2)) {
                    g.setColor(Color.orange);

                    g.drawLine((element.x + 1) * 50 + 10, (element.y + 1) * 50 + 10, (element2.x + 1) * 50 + 10, (element2.y + 1) * 50 + 10);
                    if (element.next2) {
                        g.setColor(Color.green);
                        g.drawLine((element.x + 1) * 50 + 10, (element.y + 1) * 50 + 10, (element2.x + 1) * 50 + 10, (element2.y + 1) * 50 + 10);

                    }

                }

            }
            //checks if the node links to the final node/exit 
            if (element.nextNode1.equals("W") || element.nextNode2.equals("W")) {
                g.setColor(Color.orange);
                g.drawLine((element.x + 1) * 50 + 10, (element.y + 1) * 50 + 10, (this.nodes.get(this.nodes.size() - 1).x + 1) * 50 + 10, (this.nodes.get(this.nodes.size() - 1).y + 1) * 50 + 10);

            }
        }
        for (Node element : this.nodes) {
            //draws all of the nodes onto the panel
            g.setColor(Color.blue);
            g.fillOval((element.x + 1) * 50, (element.y + 1) * 50, 20, 20);
            //draws the node names onto the frame
            g.setColor(Color.black);
            g.drawString(element.name, (element.x + 1) * 50, (element.y + 1) * 50);
            
        }
        
    }
}
