package Inheritance;

public class TaxCalculator2018 implements TaxCalculator{
    private double taxableIncome;

    public TaxCalculator2018(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }
    public void print() {
        System.out.println("Hello World");
    }

    @Override
    public double calculateTax(){
        return taxableIncome * 0.3;
    }
}
