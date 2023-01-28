package com.project1;

/**
 * @author WebleyR
 *
 */


import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BasicUserInput {    /**
 * Variable declaration
 *
 */
private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;


    public static void main(String[] args) {
        BasicUserInput userInput = new BasicUserInput(); // Instance of BasicUserInput class
        Scanner scannerObject = new Scanner(System.in); // declaration of Scanner

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("LLLL dd yyyy");

        System.out.print("Please enter first name: "); // Prompting user
        userInput.firstName = scannerObject.next(); // Accepting user input

        System.out.print("Please enter your last name: "); // Prompting user
        userInput.lastName = scannerObject.next(); // Accepting user input

        System.out.print("Please enter your gender: "); // Prompting user
        userInput.gender = scannerObject.next(); // Accepting user input

        System.out.print("Please enter your Date of birth (YYYY-MM-DD): ");
        userInput.dateOfBirth = scannerObject.next();

        LocalDate dob = LocalDate.parse(userInput.dateOfBirth);
        LocalDate currentDate = LocalDate.now(); // get the current date
        Period period = Period.between(dob, currentDate);

        System.out.println("Welcome " + userInput.firstName +" "
                + userInput.lastName +","
                + " you are " + period.getYears()+" years old"
                + " and today's date is " + currentDate.format(dateFormat));

        scannerObject.close(); //close scanner object to prevent memory leakage
    }


}
