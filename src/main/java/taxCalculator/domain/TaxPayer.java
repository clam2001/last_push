package taxCalculator.domain;

public class TaxPayer {

    //Tax Payer Attributes
    private int number;
    private String name;
    private String surname;
    private int age;
    private double salary;
    private double bonuses;
    private double interestReceived;
    private double dividends;
    private double totalCapitalGain;
    private double retirementFunding;
    private double travelAllowance;

    public TaxPayer(int number, String name, String surname, int age) {
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setBonuses(double bonuses) {
        this.bonuses = bonuses;
    }

    public double getBonuses() {
        return bonuses;
    }

    public void setInterestReceived(double interestReceived) {
        this.interestReceived = interestReceived;
    }

    public double getInterestReceived() {
        return interestReceived;
    }

    public void setDividends(double dividends) {
        this.dividends = dividends;
    }

    public double getDividends() {
        return dividends;
    }

    public void setTotalCapitalGain(double totalCapitalGain) {
        this.totalCapitalGain = totalCapitalGain;
    }

    public double getTotalCapitalGain() {
        return totalCapitalGain;
    }

    public void setRetirementFunding(double retirementFunding) {
        this.retirementFunding = retirementFunding;
    }

    public double getRetirementFunding() {
        return retirementFunding;
    }

    public void setTravelAllowance(double travelAllowance) {
        this.travelAllowance = travelAllowance;
    }

    public double getTravelAllowance() {
        return travelAllowance;
    }
}

