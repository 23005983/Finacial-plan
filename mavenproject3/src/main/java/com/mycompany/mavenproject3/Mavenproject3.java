/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject3;


      import java.util.Scanner;

public class Mavenproject3{

    public static void main(String[] args) {
        Scanner mulalo = new Scanner(System.in);

        // Step 1: Input gross monthly income and deductions
        System.out.println("Enter your gross monthly income:");
        double grossIncome = mulalo.nextDouble();

        System.out.println("Enter estimated monthly tax deducted:");
        double taxDeducted = mulalo.nextDouble();

        // Step 2: Input monthly expenditures
        System.out.println("Enter estimated monthly expenditure for Groceries:");
        double groceries = mulalo.nextDouble();

        System.out.println("Enter estimated monthly expenditure for Water and Lights:");
        double waterAndLights = mulalo.nextDouble();

        System.out.println("Enter estimated monthly expenditure for Travel Costs:");
        double travelCosts = mulalo.nextDouble();

        System.out.println("Enter estimated monthly expenditure for Cell phone and Telephone:");
        double cellPhone = mulalo.nextDouble();

        System.out.println("Enter estimated monthly expenditure for Other expenses:");
        double otherExpenses = mulalo.nextDouble();

        // Step 3: Renting or buying decision
        System.out.println("Do you want to rent or buy a property? (Enter 'rent' or 'buy')");
        String choice = mulalo.next().toLowerCase();

        double accommodationCost = 0.0;

        if (choice.equals("rent")) {
            System.out.println("Enter your monthly rental amount:");
            accommodationCost = mulalo.nextDouble();
        } else if (choice.equals("buy")) {
            // Step 4: Enter home loan details
            System.out.println("Enter the purchase price of the property:");
            double purchasePrice = mulalo.nextDouble();

            System.out.println("Enter the total deposit:");
            double deposit = mulalo.nextDouble();

            System.out.println("Enter the annual interest rate (percentage):");
            double annualInterestRate = mulalo.nextDouble();

            System.out.println("Enter the number of months to repay the loan (between 240 and 360):");
            int monthsToRepay = mulalo.nextInt();

            // Step 5: Calculate loan amount and monthly home loan repayment
            double loanAmount = purchasePrice - deposit;
            double monthlyInterestRate = (annualInterestRate / 100) / 12;

            double monthlyRepayment = calculateMonthlyRepayment(loanAmount, monthlyInterestRate, monthsToRepay);
            accommodationCost = monthlyRepayment;

            System.out.printf("Your monthly home loan repayment is: %.2f\n", accommodationCost);

            // Step 6: Check if monthly home loan is more than a third of the gross monthly income
            if (accommodationCost > grossIncome / 3) {
                System.out.println("Warning: The monthly home loan repayment exceeds a third of your gross monthly income. Approval of the loan is unlikely.");
            }
        } else {
            System.out.println("Invalid choice. Please restart the program and enter 'rent' or 'buy'.");
            return;
        }

        // Step 7: Calculate total expenditures and remaining income
        double totalExpenditures = taxDeducted + groceries + waterAndLights + travelCosts + cellPhone + otherExpenses + accommodationCost;
        double remainingIncome = grossIncome - totalExpenditures;

        System.out.println("Your total monthly expenditures are: "+ totalExpenditures);
        System.out.println("Your remaining income after expenditures is:"+ remainingIncome);
    }

    // Method to calculate the monthly home loan repayment
    public static double calculateMonthlyRepayment(double loanAmount, double monthlyInterestRate, int months) {
        return (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) / 
               (Math.pow(1 + monthlyInterestRate, months) - 1);
    }
}