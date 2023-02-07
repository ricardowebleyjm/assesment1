package com.program2;
/*
* Create a program with a selection of 3 user options to calculate the following:
 The sum of 2 whole numbers
 Conversion of user input, rounded to 2 decimal points
 Accepts 5 different user input values and can print/display the following:
    o Sum of all values
    o The average value
    o The minimum value
    o The maximum value
    o The square root of the maximum value
* */

/**
 * @author WebleyR
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class SimpleMath {

    private static final Scanner scannerObject = new Scanner(System.in);

    /* This method displays a menu to the user when called */
    public void display() {
        System.out.println();System.out.println("Welcome, Please select a choice below: ");
        System.out.println("1. Calculate the sum of two numbers ");
        System.out.println("2. Convert a number to two decimal points ");
        System.out.println("3. Perform calculation of Ave, Min, Max SQRT and Sum ");
        System.out.println("");
        System.out.print("Please select your choice.....: ");
    }

    /**
     * Perform sum of the numbers passed to the method.
     * @param firstNumber
     * @param secondNumber
     * @return the sum of the passed in numbers
     */
    public int sumOfTwoNumbers(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    /**
     * Converts a number to two(2) decimal points.
     * @param number
     * @return  the number converted to two(2) decimal points
     */
    public double convertToDecimal(double number) {
        return Math.round(number * 100) / 100D;
    }

    /**
    * Performs calculation and prints results.
    */
    public void calculateFiveNumbers(){
       //Local variable declaration
        ArrayList<Integer> numberList = new ArrayList<>();
        int sum = 0;
        double average =0;
        int minimum = 0;
        int maximum =0;
        double squareRoot = 0;

        // This block prompts the user to enter five(5) numbers.
        System.out.println("Please enter 5 numbers to be calculated: ");
        for (int i = 0; i < 5; i++){
            int count = i + 1;
            System.out.print("Enter number " + count + ": ");
            numberList.add(scannerObject.nextInt());
            sum += numberList.get(i); // calculation the sum of the number in the list
        }

        average = (double)sum / numberList.size(); // calculating the average of all numbers in the numberList
        minimum = Collections.min(numberList); // retrieving the Minimum number from numberList
        maximum = Collections.max(numberList); // retrieving the Maximum number from numberList
        squareRoot = Math.sqrt(maximum); // calculating the SQRT of the maximum number

        /* This block prints/display the results after calculations are finished. */
        System.out.println("The sum of all the numbers is: " + sum);
        System.out.format("The average of all the numbers is: %.2f \n", average);
        System.out.println("The minimum of all the numbers is: " + minimum);
        System.out.println("The maximum of all the numbers is: " + maximum);
        System.out.println("The Square root of the maximum number is: " + squareRoot);
    }

    public static void main(String[] args){
        SimpleMath simpleMath = new SimpleMath(); // New instance of SimpleMath class
        simpleMath.display(); // calls the display method from SimpleMath class
        int choice = scannerObject.nextInt(); // Accept user choice

        /* switch block call appropriate method based on the choice the user selected.  */
        switch(choice){
            case 1:
                System.out.print("Please the first number: ");
                int firstNumber = scannerObject.nextInt();

                System.out.print("Please the second number: ");
                int secondNumber = scannerObject.nextInt();

                System.out.println("The sum of the numbers are: " +
                        simpleMath.sumOfTwoNumbers(firstNumber, secondNumber) );
                break;
            case 2:
                System.out.print("Please enter a number to be rounded to 2 decimal places: ");
                double numberToBeRounded = scannerObject.nextDouble();

                System.out.println("The number you entered converted to 2 decimal place is: "+
                        simpleMath.convertToDecimal(numberToBeRounded)); // converting and return the user input
                break;
            case 3:
                simpleMath.calculateFiveNumbers();
                break;
            default:
                System.out.println("Invalid choice");
                System.exit(0); // end the program in the user enters an invalid choice.
        }
    }

}
