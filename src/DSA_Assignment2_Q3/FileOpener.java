/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSA_Assignment2_Q3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Jakob
 */
public class FileOpener {
    //initialises variables
    public Maze maze;
    public void readFile(String fileName)   {        
        try {
            //creates a reader object to read the file
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            //reads the first line of the maze file
            String Firstline = br.readLine();
            //splits the line into three parts 
            String[] split = Firstline.split(",");
            //creates new maze object with the parameters 
            maze = new Maze(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[0]));

            //reads next line in the file
            String line = br.readLine();
            //keeps reading lines untill the line that returns is null meaning that the file has not more lines
            while (line != null) {
                //splits the line into four parts 
                split = line.split(",");
                //creates new node and adds it to the maze object
                Node newNode = new Node(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3], split[4]);
                maze.addNode(newNode);
                //reads new line
                line = br.readLine();
            }
            //closes the buffered reader
            br.close();

            //method to find the adjacency matrix of the maze
            int[][] adjacencyMatrix = new int[maze.nodes.size()][maze.nodes.size()];
            for (int i = 0; i < maze.nodes.size(); i++) {
                for (int j = 0; j < maze.nodes.size(); j++) {
                    adjacencyMatrix[i][j] = 0;
                }
                int result = ((int) maze.nodes.get(i).nextNode1.charAt(0)) - 65;
                int result2 = ((int) maze.nodes.get(i).nextNode2.charAt(0)) - 65;
                adjacencyMatrix[i][result] = 1;
                adjacencyMatrix[i][result2] = 1;
            }
            //is not utilised further

        } catch (Exception e) {
            System.out.println("File reader failure");
        }
    }

}
