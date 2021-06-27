package com.company;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Account
{
    //instance variables
    public int balance;
    public int previousTransaction;
    public String customerName;
    public String customerID;

    /**
     * The constructor for the Account class.
     * @param customerName The name of the customer who holds this account.
     * @param customerID The ID of the customer that holds this account.
     */
    public Account(String customerName, String customerID) {
        customerName = this.customerName;
        customerID = this.customerID;
    }

    /**
     * Function for depositing money into your account.
     * @param amount The amount of money that has been deposited.
     */
    public void deposit(int amount)
    {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    /**
     * Function for withdrawing money from your account.
     * @param amount The amount of money that has been deposited.
     */
    public void withdraw(int amount)
    {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    /**
     * Function for withdrawing money from your account.
     */
    public void getPreviousTransaction()
    {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        }

        else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction occurred");
        }
    }

    /**
     * Function calculating interest of current funds after a number of years.
     * @param years number of years that the interest rate is calculated over.
     */
    public void calculateInterest(int years)
    {
        double interestRate = 0.0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, you balance will be: " + newBalance);
    }

    /**
     * Shows the menu to the user and processes the commands that the user intputs.
     */
    public void showMenu()
    {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {
                //Case A allows the user to check their account balance.
                case 'A':
                    System.out.println("========================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("========================================");
                    System.out.println();
                    break;
                //Case B allows the user to deposit money into their account using the user input.
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    //Case C allows the user to withdraw money into their account using the user input.
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                //Case d allows the user to view their most recent transaction.
                case 'D':
                    System.out.println("========================================");
                    getPreviousTransaction();
                    System.out.println("========================================");
                    System.out.println();
                    break;
                //Case E calculates the accrued interest on their account.
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                //Case F exits the user from their account.
                case 'F':
                    System.out.println("========================================");
                    break;
                //The default case let's the user know that they know that they entered an invalid command.
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, F");
                    break;
                }
            }
            while(option != 'F');
        System.out.println("Thank you for banking with us!");


    }

}
