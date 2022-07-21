package taxCalculator.service;

import taxCalculator.domain.TaxPayer;
import taxCalculator.domain.TaxTable;
import taxCalculator.resource.TaxCalculatorResource;

import java.util.Scanner;
public class TaxCalculatorService {

    TaxCalculatorResource taxCalculatorResource = new TaxCalculatorResource();

    public boolean isInDatabase(int taxPayerNo){
        return taxCalculatorResource.isInDatabase(taxPayerNo);
    }

    public TaxPayer retrieveTaxPayer(int taxPayerNo){
        return taxCalculatorResource.retrieveTaxPayer(taxPayerNo);
    }

    public void updateTaxPayer(TaxPayer taxPayer, String updateKey, String updateKeyValue){
        validate(updateKey, updateKeyValue);
        taxCalculatorResource.updateTaxPayer(taxPayer, updateKey, updateKeyValue);

    }

    private void validate(String updateKey, String updateKeyValue){

    }

    public double calculateNetTaxPayable(TaxPayer taxPayer){
        TaxTable taxTable = new TaxTable();
        return taxTable.calculateNetTaxPayable(taxPayer);
    }

    private void validateTaxPayer(String taxNumber, String name, String surname, String age, String salary, String bonuses, String interestReceived, String dividends, String totalCapitalGains, String retirementFunding, String travelAllowance){
        //validate here
    }

    public void register(String taxNumber, String name, String surname, String age, String salary, String bonuses, String interestReceived, String dividends, String totalCapitalGains, String retirementFunding, String travelAllowance){
        validateTaxPayer(taxNumber, name, surname, age, salary, bonuses, interestReceived, dividends, totalCapitalGains, retirementFunding, travelAllowance);

    }

}
