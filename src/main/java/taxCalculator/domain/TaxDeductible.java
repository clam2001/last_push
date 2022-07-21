package taxCalculator.domain;

import taxCalculator.domain.TaxPayer;

public class TaxDeductible {

    public static double calculateTaxDeductible(TaxPayer taxPayer){
        double taxDeductible = 0;
        taxDeductible += taxPayer.getTravelAllowance();
        //Add code for Retirement Funding here
        double taxPayerRetirementMaxAllowed;

        if (0.275 * (taxPayer.getSalary() + taxPayer.getBonuses()) > 350000.00){
            taxPayerRetirementMaxAllowed = 350000.00;
        }
        else {
            taxPayerRetirementMaxAllowed = 0.275 * (taxPayer.getSalary() + taxPayer.getBonuses());
        }

        if (taxPayer.getRetirementFunding() < taxPayerRetirementMaxAllowed){
            taxDeductible += taxPayer.getRetirementFunding();
        }
        else {
            taxDeductible += taxPayerRetirementMaxAllowed;
        }
        System.out.println("Your tax deductable is R" + taxDeductible);
        return taxDeductible;
    }
}
