/*
Answers to Question 2 questions
Is quick sort the best way of finding median? Why?
No not for an array of this size for arrays that are small like the one we sorted It is better to use a different method to find the median. Quick sort works better on larger arrays.

What is another good way of finding median? Please provide your explanation.
you could use insertion sort to sort the array as insertion sort works much better than quick sort at lower array lengths.
*/


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSA_Assignment2_Q2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jakob
 */
public class SortableArray<E extends Comparable> {

    //initialises variables 
    public E[] array;
    public ArrayList<Object> sortedArray;

    //sets the array and initialises object
    public void setArray(E[] array) {
        this.array = array;
    }

    //quick sort method
    public void quickSort() {

        //makes three seperate arrays for the middle left and right
        ArrayList<Object> left = new ArrayList<>();
        ArrayList<Object> right = new ArrayList<>();
        ArrayList<Object> middle = new ArrayList<>();

        //adds the last object in the array to middle array
        middle.add(this.array[this.array.length - 1]);

        //compares the middle to every variable in array
        for (int i = 0; i < this.array.length - 1; i++) {
            //if less than middle adds it to the left array
            if (this.array[i].compareTo(this.array[this.array.length - 1]) < 0) {
                left.add(this.array[i]);
                //if more adds it to the right array
            } else if (this.array[i].compareTo(this.array[this.array.length - 1]) > 0) {
                right.add(this.array[i]);
                //if it is the same as the middle adds it to the middle array
            } else if (this.array[i].compareTo(this.array[this.array.length - 1]) == 0) {
                middle.add(this.array[i]);
            }

        }
        //initialises the return array
        ArrayList<Object> returnArray = new ArrayList<>();
        //checks if there are variables in the left array
        if (!left.isEmpty()) {
            //if there are call quick sort private function and returns the sorted left array
            ArrayList<Object> returned = quickSort(left);
            //adds all variables to the return array
            for (int i = 0; i < returned.size(); i++) {
                returnArray.add(returned.get(i));
            }
        }
        //adds all middle variables to the return array
        for (int i = 0; i < middle.size(); i++) {
            returnArray.add(middle.get(i));
        }
        //checks if theere are variables in the right array
        if (!right.isEmpty()) {
            //if there are call quick sort private function and returns the sorted right array
            ArrayList<Object> returned = quickSort(right);
            //adds all variables to the return array
            for (int i = 0; i < returned.size(); i++) {
                returnArray.add(returned.get(i));
            }
        }
        //this.array = (E[]) returnArray.toArray();

        //sets the sorted array to the return array
        this.sortedArray = returnArray;

    }

    //quick sort method to handle the array divided into smaller chunks
    private ArrayList<Object> quickSort(ArrayList<Object> array) {
        //if the array size is one the array has been sorted already so is returned
        if (array.size() == 1) {
            return array;
        }

        //makes three seperate arrays for the middle left and right
        ArrayList<Object> left = new ArrayList<>();
        ArrayList<Object> right = new ArrayList<>();
        ArrayList<Object> middle = new ArrayList<>();

        //adds the last object in the array to middle array
        middle.add(array.get(array.size() - 1));

        //compares the middle to every variable in current array
        for (int i = 0; i < array.size() - 1; i++) {
            //if less than middle adds it to the left array
            if (((E) array.get(i)).compareTo(((E) array.get(array.size() - 1))) < 0) {
                left.add(array.get(i));
                //if more than middle adds it to the right array
            } else if (((E) array.get(i)).compareTo(((E) array.get(array.size() - 1))) > 0) {
                right.add(array.get(i));
                //if the same as the middle adds it to the middle array
            } else if (((E) array.get(i)).compareTo(((E) array.get(array.size() - 1))) == 0) {
                middle.add(array.get(i));
            }
        }
        
        //initialises the return array
        ArrayList<Object> returnArray = new ArrayList<>();
        
        //checks if there are variables in the left array
        if (!left.isEmpty()) {
            //if there are call quick sort private function and returns the sorted left array
            ArrayList<Object> returned = quickSort(left);
            //adds all variables to the return array
            for (int i = 0; i < returned.size(); i++) {
                returnArray.add(returned.get(i));
            }
        }
        //adds all variables to the return array
        for (int i = 0; i < middle.size(); i++) {
            returnArray.add(middle.get(i));
        }
         //checks if there are variables in the left array
        if (!right.isEmpty()) {
             //if there are call quick sort private function and returns the sorted right array
            ArrayList<Object> returned = quickSort(right);
            //adds all variables to the return array
            for (int i = 0; i < returned.size(); i++) {
                returnArray.add(returned.get(i));
            }

        }
        //returns the return array
        return returnArray;

    }
}
