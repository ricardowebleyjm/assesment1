package com.program5;

/*Write a program that allows a user to insert a date (in years) and displays
 back to the user whether the date is a leap year or not.
 */

/**
 * @author WebleyR
 *
 */

import java.time.LocalDate;
import java.util.Scanner;


public class LeapYear {

    /**
     * Verifies if the year that was passed in is a Leap Year.
     * To determine whether a year is a leap year:
     * <ul>
     *     <li>If the year is evenly divisible by 4</li>
     *     <li>If the year is evenly divisible by 100</li>
     *     <li>If the year is evenly divisible by 400</li>
     * </ul>
     * @param year
     * @return boolean
     */
    public static boolean leapYearChecker(int year){

        if( ((year % 4 == 0 ) && (year % 400 == 0))// Check If the year is evenly divisible by 4 and 400
                || (year % 100 != 0) ) // Check If the year is not evenly divisible by 100
            {
                return true;
            }
        return false; // return false if none of the conditions were met

    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String date; // declaration of the year variable. Will be used to store the date of user input
        String year;
        System.out.print("Enter a date to check if the year is a leap year (YYYY-MM-DD): "); // Prompting for the Date
        date = input.next(); //Accepting the user input

        LocalDate localDate = LocalDate.parse(date); //converting the year to a LocalDate object
        year = String.valueOf(localDate.getYear()); // retrieving the year for the parsed date as a String

        /*
        * Storing the return value of the leapYearChecker method in isLeapYear
        * Convert the year to type int since it was collected as a String
        **/
        boolean isLeapYear = LeapYear.leapYearChecker(Integer.parseInt(year));

        if(isLeapYear){ // Checks to verify if isLeapYear evaluates to true
            System.out.println("The year " + year + " is a leap year from the date you provided");
        }else{ // Informs the user that the year is not leap year
            System.out.println(year + " is not a leap year");
        }

    }
}
