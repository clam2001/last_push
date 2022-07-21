package taxCalculator.domain;

import taxCalculator.domain.TaxDeductible;
import taxCalculator.domain.TaxPayer;
import taxCalculator.domain.TaxableIncome;

public class TaxTable {
    final static int[] highBands = {216_200, 337_800, 467_500, 613_600, 782_200, 1_656_600, 1_000_000_000};
    final static int[] lowBands = {0, 216_201, 337_801, 467_501, 613_601, 782_201, 1_656_601};
    final static double[] bandPercentages = {0.18, 0.26, 0.31, 0.36, 0.39, 0.41, 0.45};
    private static double MEDICAL_CREDITS = 12000.00;
    private static double PRIMARY_REBATE = 15714.00;

    // NETT TAX TABLE
    private double netTaxPayable;


    public double calculateNetTaxPayable(TaxPayer taxPayer){
        double netTaxableIncome = calculateNetTaxableIncome(taxPayer);
        double bandRemainder = netTaxableIncome;

        for (int i = 0; i < highBands.length; i++){
            if (bandRemainder > 0){
                double bandDifference = highBands[i] - lowBands[i];
                if (bandDifference >= bandRemainder){
                    netTaxPayable += bandRemainder * bandPercentages[i];
                }
                else {
                    netTaxPayable += bandDifference * bandPercentages[i];
                }

                bandRemainder -= bandDifference;
            }
            else {
                break;
            }
        }

        //Deduct
        netTaxPayable -= MEDICAL_CREDITS;
        netTaxPayable -= PRIMARY_REBATE;

        return netTaxPayable;
    }

    private static double calculateNetTaxableIncome(TaxPayer taxPayer){
        return TaxableIncome.calculateTaxableIncome(taxPayer) - TaxDeductible.calculateTaxDeductible(taxPayer);
    }

}




