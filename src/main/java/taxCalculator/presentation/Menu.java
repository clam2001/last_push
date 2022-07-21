package taxCalculator.presentation;

import javafx.application.Application;
import taxCalculator.domain.TaxPayer;
import taxCalculator.domain.TaxTable;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private TaxCalculatorController taxCalculatorController = new TaxCalculatorController();

    public void displayWelcome() {

        System.out.println("WELCOME TO TAX CALCULATOR :)");
        System.out.println("We help you calculate tax :)");
        System.out.println();
        System.out.println("What is your tax number? We might have you in our database...");

        int taxPayerNumber = scanner.nextInt();
        System.out.println("Thank you");
        System.out.println("Searching database for Tax Number " + taxPayerNumber);
        System.out.println();

        if (taxCalculatorController.isInDatabase(taxPayerNumber)){
            System.out.println("Great!!! Looks like we have you in our database...");
            System.out.println("Would like to UPDATE your details or CALCULATE your net tax payable?");
            System.out.println("Type 'U' for UPDATE or 'C' for CALCULATE");

            TaxPayer taxPayer = taxCalculatorController.retrieveTaxPayer(taxPayerNumber);

            String action = scanner.nextLine();

            if (action.equals("U")){
                displayTaxPayer(taxPayer);
                updateTaxPayer(taxPayer);
            }
        }
        else {
            System.out.println("\n Oops.... Looks like we do not have you in our database.");
            System.out.println("Would you like to register");
            System.out.print("Type 'Y' for YES and 'N' for NO");

            String response = scanner.nextLine();

            if (response.equals("N")){
                System.exit(0);
            }
            else if (response.equals("Y")){
                inputTaxPayerInfo();

            }
        }


    }

    private void inputTaxPayerInfo(){
        System.out.println("\n Let's get you started...");
        System.out.println("We are going to need a few details...");
        System.out.print("What is your name? ");
        String name = scanner.nextLine();
        System.out.print("What is your surname? ");
        String surname = scanner.nextLine();
        System.out.println("(: Nice to meet you there, " + name + " " + surname + " :)");
        System.out.print("What is your Tax Number");
        String taxNumber = scanner.nextLine();
        System.out.print("How old are you?");
        String age = scanner.nextLine();
        System.out.println("You are half way there... \n Let's take a look at your Income Items between March 2021 and February 2022");
        System.out.print("How much were your salary?");
        String salary = scanner.nextLine();
        System.out.print("How much were your bonuses?");
        String bonuses = scanner.nextLine();
        System.out.print("How much interest did your receive?");
        String interestReceived = scanner.nextLine();
        System.out.print("How much were your dividends?");
        String dividends = scanner.nextLine();
        System.out.print("How much were your capital gains");
        String totalCapitalGains = scanner.nextLine();
        System.out.print("How much is your retirement funding?");
        String retirementFunding = scanner.nextLine();
        System.out.print("How much is your travel allowance?");
        String travelAllowance = scanner.nextLine();
        System.out.println();


    }



    private void updateTaxPayer(TaxPayer taxPayer){
        System.out.println("\n What would you like to update? Type in the exact Income or Expense Item i.e. 'salary'");
        String updateKey = scanner.nextLine();
        System.out.println("What value would you like to replace "+ updateKey + " with?");
        String updateKeyValue = scanner.nextLine();
        System.out.println("Updating....");

        taxCalculatorController.updateTaxPayer(taxPayer, updateKey, updateKeyValue);

        System.out.println("Would you like to update more information?");
        System.out.print("Type 'Y' for YES and 'N' for NO");
        String continueResponse = scanner.nextLine();

        if (continueResponse.equals("Y")){
            updateTaxPayer(taxPayer);
        }
        else if (continueResponse.equals("N")){
            System.out.println("View your updated information");
            displayTaxPayer(taxPayer);
            System.out.println("Would you like to EXIT or CALCULATE your tax?");
            System.out.print("Type 'E' for EXIT and 'C' for CALCULATE");
            String exitResponse = scanner.nextLine();

            if (exitResponse.equals("E")){
                System.exit(0);
            }
            else if (exitResponse.equals("C")){
                calculateNetTaxPayabale(taxPayer);
                System.out.println("Would you like to EXIT or UPDATE your information");
                System.out.print("Type 'E' for EXIT and 'U' for UPDATE");

                String finalResponse = scanner.nextLine();

                if (finalResponse.equals("E")){
                    System.exit(0);
                }
                else if (finalResponse.equals("U")) {
                    updateTaxPayer(taxPayer);
                }
            }
        }
    }

    private void calculateNetTaxPayabale(TaxPayer taxPayer){
        double netTaxPayable = taxCalculatorController.calculateNetTaxPayable(taxPayer);
        System.out.println("Your Net Tax Payable is " + netTaxPayable);
    }

    private void displayTaxPayer(TaxPayer taxPayer){
        System.out.println("\n" + "---------------------------------------------------");

        System.out.println("YOUR TAXPAYER DETAILS ARE......");

        System.out.println("\n" + "PERSONAL DETAILS");
        System.out.println("tax_payer_id : " + taxPayer.getNumber());
        System.out.println("name : " + taxPayer.getName());
        System.out.println("surname : " + taxPayer.getSurname());

        System.out.println("\n" + "INCOME ITEMS");
        System.out.println("salary : " + taxPayer.getSalary());
        System.out.println("bonuses : " + taxPayer.getBonuses());
        System.out.println("interest_received : " + taxPayer.getInterestReceived());
        System.out.println("dividends : " + taxPayer.getDividends());
        System.out.println("total_capital_gains : " + taxPayer.getTotalCapitalGain());

        System.out.println("\n" + "EXPENSE ITEMS");
        System.out.println("retirement_funding : " + taxPayer.getRetirementFunding());
        System.out.println("travel_allowance : " + taxPayer.getTravelAllowance());

        System.out.println("\n" + "---------------------------------------------------");

    }
}
