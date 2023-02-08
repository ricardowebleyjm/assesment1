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
     *     <li>If the year is evenly divisible by 4 using the modulus operator</li>
     *     <li>If the year is evenly divisible by 100 using the modulus operator</li>
     *     <li>If the year is evenly divisible by 400 using the modulus operator</li>
     * </ul>
     * @param year
     * @return boolean
     */
    public static boolean leapYearChecker(int year){
        if(year % 4 == 0){ // check if the year directly dividable by 4 == 0 (modulus)
            if(year % 100 !=0){ // is the previous if block passes, the check if year mod 100
                return true;
            }
        } else if (year % 400 == 0) {// check if the year directly dividable by 400 == 0 (modulus)
            return true;
        }
        return false; // return false is none of the conditions were met.
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String date; // declaration of the year variable. Will be used to store the date of user input
        String year;
        System.out.print("Enter a date to check if the year is a leap year (YYYY-MM-DD): "); // Prompting for the Date
        date = input.next(); //Accepting the user input

        LocalDate localDate = LocalDate.parse(date); //converting the year to a LocalDate object
        year = String.valueOf(localDate.getYear()); // retrieving the year for the parsed date as a String

        // Checks to verify if isLeapYear evaluates to true
        if(LeapYear.leapYearChecker(Integer.parseInt(year))){
            System.out.println("The year " + year + " is a leap year from the date you provided");
        }else{
            System.out.println(year + " is not a leap year"); // Informs the user that the year is not leap year
        }

    }
}