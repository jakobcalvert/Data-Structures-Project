/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSA_Assignment2_Q3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Jakob
 */
public class Main {

    //initialises variables
    public static JFrame frame;

    public static void main(String[] args) throws FileNotFoundException {

        try {
            //creates a file chooser object prompts user to select a file to read
            JFileChooser textFileChooser = new JFileChooser(new File("."));
            int stateImageFileChooser = textFileChooser.showOpenDialog(null);

            if (stateImageFileChooser == JFileChooser.APPROVE_OPTION) {
                String fileName = textFileChooser.getSelectedFile().getPath();

                //read the file using file opener object
                

                //creates new jframe and sets the size and settings
                frame = new JFrame("Maze");
                FileOpener file = new FileOpener();
                file.readFile(fileName);
                frame.add(file.maze);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(450, 450);
                frame.setVisible(true);

            }
        } catch (Exception E) {
            System.out.println("File read error");
        }

    }
}
