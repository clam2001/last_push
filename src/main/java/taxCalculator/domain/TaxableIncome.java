package taxCalculator.domain;

import taxCalculator.domain.TaxPayer;

public class TaxableIncome {
    //constants
    private static double INTEREST_RECEIVED_EXEMPTION = 23800.00;
    private static double CAPITAL_GAINS_EXEMPTION = 40000.00;
    private static double CAPITAL_GAINS_INCLUDED_RATE = 0.40;
    private static double MAXIMUM_RETIREMENT_FUND_AMOUNT = 350000.00;
    private static double MAXIMUM_RETIREMENT_FUND_PERCENTAGE = 0.275;

    //Attributes
    public static double taxableIncome;

    public static double calculateTaxableIncome(TaxPayer taxPayer){
        //calculate the taxable income
        taxableIncome = 0;

        taxableIncome += taxPayer.getSalary();

        System.out.println("taxableIncome = " + taxableIncome);

        taxableIncome += taxPayer.getBonuses();

        System.out.println("taxableIncome = " + taxableIncome);

        if (taxPayer.getInterestReceived() > INTEREST_RECEIVED_EXEMPTION){
            taxableIncome += taxPayer.getInterestReceived() - INTEREST_RECEIVED_EXEMPTION;

            System.out.println("taxableIncome = " + taxableIncome);
        }

        if (taxPayer.getTotalCapitalGain() > CAPITAL_GAINS_EXEMPTION){
            taxableIncome += (taxPayer.getTotalCapitalGain() - CAPITAL_GAINS_EXEMPTION) * CAPITAL_GAINS_INCLUDED_RATE;

            System.out.println("taxableIncome = " + taxableIncome);
        }
        System.out.println("Your taxable income is: R" + taxableIncome);
        return taxableIncome;


    }
}
