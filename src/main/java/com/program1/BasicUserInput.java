package com.program1;
/*Create a program that allows a user to input their names, date of birth and gender.
The program must print back to the user a welcome message with their names, age and the current date. For example:
 “Welcome Jane, you are 15 years old and today’s date is November 22 2021”
*/

/**
 * @author WebleyR
 *
 */


import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BasicUserInput {
 /**
 * Variable declaration
 *
 */
    private String lastName;
    private String gender;
    private String dateOfBirth;

    private String firstName;

    /*Accessors and Mutators */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public static void main(String[] args) {

        BasicUserInput userInput = new BasicUserInput(); // Instance of BasicUserInput class
        Scanner scannerObject = new Scanner(System.in); // declaration of Scanner

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("LLLL dd yyyy");

        System.out.print("Please enter your first name: "); // Prompting user
        userInput.setFirstName(scannerObject.next());; // Accepting user input

        System.out.print("Please enter your last name: "); // Prompting user
        userInput.setLastName(scannerObject.next()); // Accepting user input

        System.out.print("Please enter your gender: "); // Prompting user
        userInput.gender = scannerObject.next(); // Accepting user input

        System.out.print("Please enter your Date of birth (YYYY-MM-DD): ");
        userInput.setDateOfBirth(scannerObject.next());

        LocalDate dob = LocalDate.parse(userInput.getDateOfBirth()); //Retrieving the date of birth
        LocalDate currentDate = LocalDate.now(); // get the current date and assign value to currentDate
        Period period = Period.between(dob, currentDate); // calculates the time between the dob and currentDate

        System.out.println("Welcome " + userInput.getFirstName() +" "
                + userInput.getLastName() +","
                + " you are " + period.getYears()+" years old"
                + " and today's date is " + currentDate.format(dateFormat));
    }
}
