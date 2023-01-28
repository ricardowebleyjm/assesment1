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
        this.exchangeRateList.put("Jamaican Dollars", 1.50);
        this.exchangeRateList.put("Cayman Dollars", 0.93);
        this.exchangeRateList.put("Eastern Caribbean Dollars", 1.66);
        this.exchangeRateList.put("US Dollars", 1.01);
        this.exchangeRateList.put("British Pounds", 6.36);
        this.exchangeRateList.put("Euros", 5.99);
    }

    /**
     * This method calculates currencies in the existing exchangeRateList. Then,
     * prints the conversion rate of each currency
     * @param amount
     */
    public  void convertCurrencies(double amount) {
        for(Map.Entry<String, Double> exchangeRateList: exchangeRateList.entrySet()){ // loop through the exchangeRateList to get the keys and values
            String currencyName = exchangeRateList.getKey(); // retrieving the keys from the exchangeRateList
            double currencyRate = exchangeRateList.getValue(); // retrieving the values from the exchangeRateList
            double total = amount * currencyRate; // multiplying amount that was passed int by the existing rate
            System.out.format("%.2f " + "converted to " + currencyName +" "+ "is %.2f " , amount, total);
            System.out.println();
        }

    }
    public static void main(String[] args){
        Scanner scannerObject = new Scanner(System.in);
        double amount;
        System.out.print("Enter the amount you want to convert: ");
        amount = scannerObject.nextDouble(); // saving the user input value

        CurrencyConverter converter = new CurrencyConverter(); // create a new instance of CurrencyConverter
        converter.convertCurrencies(amount); // passing the user value to the convertCurrencies method
        System.out.println();

        main(null); //Calling the main method, the program runs to until user terminates the program
    }

}
