package taxCalculator.presentation;

import taxCalculator.domain.TaxPayer;
import taxCalculator.service.TaxCalculatorService;

public class TaxCalculatorController {
    private TaxCalculatorService taxCalculatorService = new TaxCalculatorService();

    public boolean isInDatabase(int taxPayerNo){
        return taxCalculatorService.isInDatabase(taxPayerNo);
    }

    public TaxPayer retrieveTaxPayer(int taxPayerNo){
        return taxCalculatorService.retrieveTaxPayer(taxPayerNo);
    }

    public void updateTaxPayer(TaxPayer taxPayer, String updateKey, String updateKeyValue){
        taxCalculatorService.updateTaxPayer(taxPayer, updateKey, updateKeyValue);

        //update the taxpayer object in the menu
        if (updateKey.equals("tax_payer_id")){
            taxPayer.setNumber(Integer.parseInt(updateKeyValue));
        }
        else if (updateKey.equals("name")){
            taxPayer.setName(updateKeyValue);
        }
        else if (updateKey.equals("surname")){
            taxPayer.setName(updateKeyValue);
        }
        else if (updateKey.equals("salary")){
            taxPayer.setName(updateKeyValue);
        }
        else if (updateKey.equals("bonuses")){
            taxPayer.setName(updateKeyValue);
        }
        else if (updateKey.equals("interest_received")){
            taxPayer.setName(updateKeyValue);
        }
        else if (updateKey.equals("dividends")){
            taxPayer.setName(updateKeyValue);
        }
        else if (updateKey.equals("total_capital_gains")){
            taxPayer.setName(updateKeyValue);
        }
        else if (updateKey.equals("retirement_funding")){
            taxPayer.setName(updateKeyValue);
        }
        else if (updateKey.equals("travel_allowance")){
            taxPayer.setName(updateKeyValue);
        }
    }

    public double calculateNetTaxPayable(TaxPayer taxPayer){
        return taxCalculatorService.calculateNetTaxPayable(taxPayer);
    }

    public void registerTaxPayer(String taxNumber, String name, String surname, String age, String salary, String bonuses, String interestReceived, String dividends, String totalCapitalGains, String retirementFunding, String travelAllowance){

    }


}
