package com.program4;

/*
Create a compound interest calculator that can calculate compound interest
upon a user-specified time (i.e. year, days or months)
*/

/*
 * @author WebleyR
 *
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class CompoundInterest {
    /* Variable declaration */
    private double principal;
    private double interestRate;
    private int timeInYears;

    private static final int DAILY = 365; // Constant variable, can not be modified during runtime
    private static final int MONTHLY = 12; // Constant variable, can not be modified during runtime
    DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Sets the formatting for decimal values

    public CompoundInterest() {} // Default constructor

    /**
     * Parameterized constructor initialize variables
     * @param principal
     * @param interestRate
     * @param timeInYears
     */
    public CompoundInterest(double principal, double interestRate, int timeInYears) {
        this.principal = principal;
        this.interestRate = interestRate/100;
        this.timeInYears = timeInYears;
    }

    /*Accessors and mutators */
    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTimeInYears() {
        return timeInYears;
    }

    public void setTimeInYears(int timeInYears) {
        this.timeInYears = timeInYears;
    }

    /**
     * This method calculates and return Daily Compound Interest
     * */
    public double dailyCompoundInterest(){
        double compoundAmount = this.principal * Math.pow((1 + this.interestRate / DAILY),
                (this.timeInYears * DAILY)) - this.principal; // performs daily CI calculation
        return Double.parseDouble(decimalFormat.format(compoundAmount)); // return the result
    }

    /**
     * This method calculates and return monthly Compound Interest
     * */
    public double monthlyCompoundInterest(){
        double compoundAmount = this.principal * Math.pow((1 + this.interestRate / MONTHLY),
                (MONTHLY * this.timeInYears)) - this.principal; // performs daily CI calculation
        return Double.parseDouble(decimalFormat.format(compoundAmount)); // return the result
    }

    /**
     * This method calculates and return Annual/Monthly Compound Interest
     * */
    private double yearlyCompoundInterest(){
        double compoundAmount = this.principal * Math.pow((1 + this.interestRate),
                this.timeInYears) - this.principal; // performs daily CI calculation
        return Double.parseDouble(decimalFormat.format(compoundAmount));// return the result
    }


    public static void main(String[] args){
        Scanner scannerInput = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Sets the formatting for decimal values


        // local variable declaration
        double principal, interestRate;
        int timeInYears, choice;

        System.out.println("************ Compound Interest Calculator **************\n");

        System.out.print("Please enter the principal amount: "); // prompting for user input
        principal = scannerInput.nextDouble(); // accepting user input

        System.out.print("Please enter the interest rate amount: "); // prompting for user input
        interestRate = scannerInput.nextDouble(); // accepting user input

        System.out.print("Please enter the amount of time in years: "); // prompting for user input
        timeInYears = scannerInput.nextInt(); // accepting user input

        CompoundInterest compoundInterest = new CompoundInterest(principal, interestRate, timeInYears); // create a new instancing of CompoundInterest with user input values
        System.out.println();

        System.out.println("Please select the method of calculation: \n1 for Daily  \n2 for Monthly \n3 for Yearly "); // prompting for user input
        choice = scannerInput.nextInt(); // accepting user input

        switch(choice){
            case 1:
                System.out.println("The compound interest  on the principal is: " +
                        compoundInterest.dailyCompoundInterest()); // printing the result of daily CI
                System.out.println("Total Amount after including Compound Interest: " +
                        Double.parseDouble(decimalFormat.format(compoundInterest.dailyCompoundInterest() + principal)));
                break;
            case 2:
                System.out.println("The compound interest on the principal is: " +
                        compoundInterest.monthlyCompoundInterest()); // printing the result of monthly CI
                System.out.println("Total Amount after including Compound Interest: " +
                        Double.parseDouble(decimalFormat.format(compoundInterest.monthlyCompoundInterest() + principal)));
                break;
            case 3:
                System.out.println("The compound interest on the principal is: " +
                        compoundInterest.yearlyCompoundInterest()); // printing the result of Annual/Yearly CI
                System.out.println("Total Amount after including Compound Interest: " +
                        Double.parseDouble(decimalFormat.format(compoundInterest.yearlyCompoundInterest() + principal)));
                break;
            default:
                System.exit(0);

        }
    }
}
