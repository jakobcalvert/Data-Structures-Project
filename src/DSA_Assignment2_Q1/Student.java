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
public class Student<E extends Comparable> implements Comparable<Student> {

    //initialises variables 
    public E key;
    public String name;
    public int mark;

    //creates object and sets the name and mark
    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    //sets the key of the object
    public void setKey(E key) {
        this.key = key;
    }

    //to string method returns a string represenation of the object
    public String toString() {
        return "Name: " + this.name + " Mark: " + this.mark;
    }

    //compares the student object to other student objects
    @Override
    public int compareTo(Student o) {
        return this.key.compareTo(o.key);
    }
    
}
