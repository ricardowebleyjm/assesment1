package com.program3;

/*
* Create a currency converter that allows the user to convert an input amount
* to a range of different currencies. The user should be able to continue
* conversion tasks without exiting the program
* */

/*
 * @author WebleyR
 *
 */

import java.text.DecimalFormat;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    /*
    * Creates an instance of a HashMap
    * */
    private Map<String, Double> exchangeRateList = new HashMap<>();
    private DecimalFormat decimalFormat;
        /*
        * Constructor initialize the exchangeRateList currencies and corresponding
        * values into the HashMap.
        * */

        public CurrencyConverter(){
        // Setting initial currencies and values to be used in the conversion
        exchangeRateList.put("JMD", 101.50);
        exchangeRateList.put("USD", 12.01);
        exchangeRateList.put("GBP", 06.36);
        exchangeRateList.put("EURO", 05.99);
        decimalFormat = new DecimalFormat("#.##");
    }

    /**
     * This method calculates currencies in the existing exchangeRateList. Then,
     * returns the converted value.
     * @param toCurrency
     * @param fromCurrency
     * @param amount
     */
    public  double convertCurrency(String toCurrency, String fromCurrency, double amount) {
        double toCurrencyValue = exchangeRateList.get(toCurrency); // retrieve the value of the key that was passed in
        double fromCurrencyValue = exchangeRateList.get(fromCurrency);
        double convertedAmount = 0.0;

        if(fromCurrency.equals("JMD")){ //  if fromCurrency is JMD, then execute this block
            switch (toCurrency){
                case "USD":
                    convertedAmount = amount * toCurrencyValue;
                    break;
                case "GBP":
                    convertedAmount = amount * toCurrencyValue;
                    break;
                case "EURO":
                    convertedAmount = amount * toCurrencyValue;
                    break;
                default:
                    System.out.println("There was an error converting. Please try back later");
                    break;

            }
        }
        if(fromCurrency.equals("USD")){ //  if fromCurrency is USD, then execute this block
            switch (toCurrency){
                case "JMD":
                    convertedAmount = amount / toCurrencyValue;
                    break;
                case "GPB":
                    convertedAmount = amount / toCurrencyValue;
                    break;
                case "EURO":
                    convertedAmount = amount / toCurrencyValue;
                    break;
                default:
                    System.out.println("There was an error converting. Please try back later");
                    break;

            }
        }

        if(fromCurrency.equals("GBP")){ //  if fromCurrency is GBP, then execute this block
            switch (toCurrency){
                case "JMD":
                    convertedAmount = amount * toCurrencyValue;
                    break;
                case "USD":
                    convertedAmount = amount / toCurrencyValue;
                    break;
                case "EURO":
                    convertedAmount = amount * toCurrencyValue;
                    break;
                default:
                    System.out.println("There was an error converting. Please try back later");
                    break;

            }
        }
        if(fromCurrency.equals("EURO")){ //  if fromCurrency is EURO, then execute this block
            switch (toCurrency){
                case "JMD":
                    convertedAmount = amount * toCurrencyValue;
                    break;
                case "USD":
                    convertedAmount = amount / toCurrencyValue;
                    break;
                case "GBP":
                    convertedAmount = amount * toCurrencyValue;
                    break;
                default:
                    System.out.println("There was an error converting. Please try back later");
                    break;

            }
        }

        return  Double.parseDouble(decimalFormat.format(convertedAmount)); // returning the converted amount to 2  Decimal Points
    }

    public static void main(String[] args){
        Scanner scannerObject = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter(); // create a new instance of CurrencyConverter

        while (true) { // while true allow the program to execute until the user terminates the program

            System.out.println("---------------CURRENCY LIST------------------");
            for (String shortName : converter.exchangeRateList.keySet()) { // loop through the exchangeRateList to get the currency short name
                System.out.print("\t" + shortName + " " );
            }
            System.out.println("\n--------------------------------------------\n");


            System.out.print("Enter the amount you want to convert: ");
            double amount = scannerObject.nextDouble(); // saving the user input value

            System.out.print("Enter the currency from which you wish to convert from: ");
            String fromCurrency = scannerObject.next().toUpperCase(); // accepting the user input and convert to uppercase

            System.out.print("Enter the currency short name, which you would like to convert to ");
            String toCurrency = scannerObject.next().toUpperCase(); // accepting the user input and convert to uppercase
            System.out.println();

            // This if block checks the both currencies are available in the exchangeRateList
            if (converter.exchangeRateList.containsKey(fromCurrency) && converter.exchangeRateList.containsKey(toCurrency)) {
                System.out.println( fromCurrency + " " + amount + " converted to " + toCurrency + " is: "
                        + converter.convertCurrency(toCurrency, fromCurrency, amount)); // passing the user value to the convertCurrencies method
                System.out.println();
            } else {
                System.out.println("Currency not in list at the moment. Please try another currency. \n");
                System.out.println();
            }

            // Prompting the user for an input if they want to continue executing the program
            System.out.print("Do you want yo continue? Y/N: ");
            String userChoice = scannerObject.next().toUpperCase();
            if(userChoice.equals("N")){
                System.exit(0);
            }
        }

    }

}
