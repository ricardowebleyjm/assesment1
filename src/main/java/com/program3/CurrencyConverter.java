package com.program3;
/*
* Create a currency converter that allows the user to convert an input amount
* to a range of different currencies. The user should be able to continue
* conversion tasks without exiting the program
* */

/**
 * @author WebleyR
 *
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    /*
    * Creates an instance of a HashMap
    * */
    private Map<String, Double> exchangeRateList = new HashMap<>();
        /*
        * Constructor initialize the exchangeRateList currencies and corresponding
        * values into the HashMap.
        * */

        public CurrencyConverter(){
        this.exchangeRateList.put("JMD", 1.50);
        this.exchangeRateList.put("KYD", 0.93);
        this.exchangeRateList.put("ECD", 1.66);
        this.exchangeRateList.put("USD", 1.01);
        this.exchangeRateList.put("GBP", 6.36);
        this.exchangeRateList.put("EURO", 5.99);
    }

    /**
     * This method calculates currencies in the existing exchangeRateList. Then,
     * returns the converted value.
     * * @param key
     * @param value
     */
    public  double convertCurrency(String key, double value) {
        double keyValue = exchangeRateList.get(key);
        double convertedAmount = keyValue * value;
        return  convertedAmount;

    }
    public static void main(String[] args){
        Scanner scannerObject = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter(); // create a new instance of CurrencyConverter

        while (true) {

            System.out.println("---------------CURRENCY LIST-----------------");
            for (String shortName : converter.exchangeRateList.keySet()) {
                System.out.print("\t" + shortName + " " );
            }
            System.out.println("\n--------------------------------------------\n");


            System.out.print("Enter the amount you want to convert: ");
            double amount = scannerObject.nextDouble(); // saving the user input value

            System.out.print("Enter the currency short name, select one from above: ");
            String currencyShortName = scannerObject.next().toUpperCase();

            System.out.println();
            if (converter.exchangeRateList.containsKey(currencyShortName)) {
                System.out.println(amount + " converted to " + currencyShortName + " is: "
                        + converter.convertCurrency(currencyShortName, amount)); // passing the user value to the convertCurrencies method
                System.out.println();
            } else {
                System.out.println("Currency not in list at the moment. \n");
                System.out.println();
            }

        }

    }

}
