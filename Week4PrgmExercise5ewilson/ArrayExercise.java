/**
 * Program: Array Exercise 
 * File: ArrayExercise.java 
 * Summary: Reads text from an input file, and plugs it into a 2d 20 x 45 array, 
 * and displays on screen in Column-Major order.
 * Author: Evan W Wilson 
 * Date: October 28, 2017
 **/

//import classes
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayExercise {

    public static void main(String[] args) {
        //begin main method

        char[] array; //creates array to store string as char elements
        char[][] multiArray = new char[20][45]; //creates 2D array to fill from char[] array
        String output = ""; //declare output string that will be final output to console

        //invoke the method here
        String file = readFile("ArrayExercise.txt"); //invokes readFile to store to String file
        array = file.toCharArray(); //string to char[] array

        //used to fill entire char[][] multiArray with '@'
        for (int i = 0; i < multiArray.length - 1; i++) {
            for (int j = 0; j < multiArray[i].length - 1; j++) {
                multiArray[i][j] = '@';
            }
        }
        
        //loop to overwrite '@' in multiArray with elements from array in row-major order
        int count = 0;
        for (int row = 0; row < multiArray.length - 1; row++) {
            for (int column = 0; column < multiArray[row].length - 1; column++) {
                if (count == array.length) {
                    break;
                }
                multiArray[row][column] = array[count];
                count++;

            }
        }

        //loop to extract multiArray to output string in column-row major
        for (int column = 0; column < multiArray[0].length - 1; column++) {
            for (int row = 0; row < multiArray.length - 1; row++) {
                output = Character.toString(multiArray[row][column]);
                System.out.print(output);
            }
            
            //displays output string to console in multiple lines instead of one long line
            System.out.println(output); 
        }

    }

    public static String readFile(String file) {
        //begin readFile method
        String text = ""; //declare string to store contents of file
        try { //try and catch exception within the method
            Scanner scanner = new Scanner(new File(file));
            //used File class and Scanner to create file instance, then read it
            while (scanner.hasNext()) {
                text = text + scanner.nextLine() + " ";
                //process file word by word, adding it to the text string
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            //prints to console if file is not found
        }
        return text; //returns results of text string
    }
}
