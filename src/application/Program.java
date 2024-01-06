package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double salaryTax = 0.0;
        double deduction = 0.0;

        System.out.print("Renda anual com salário: ");
        double salaryIncome = sc.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        double jobIncome = sc.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        double capitalGainsIncome = sc.nextDouble();
        System.out.print("Gastos médicos: ");
        double medicalExpenses = sc.nextDouble();
        System.out.print("Gastos educacionais: ");
        double educationalExpenses = sc.nextDouble();
        System.out.println();
        System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
        System.out.println();

        System.out.println("CONSOLIDADO DE RENDA:");
        double monthlyIncome = salaryIncome / 12.0;
        if (monthlyIncome < 3000.0) {
            salaryTax = 0.0;
        } else if (monthlyIncome <= 5000.0) {
            salaryTax += salaryIncome * 10.0 / 100;

        } else {
            salaryTax += salaryIncome * 20.0 / 100;

        }
        System.out.printf("Imposto sobre salário: %.2f%n", salaryTax);

        double serviceTax = jobIncome * 15.0 / 100;
        System.out.printf("Imposto sobre serviços: %.2f%n", serviceTax);

        double capitalGainsTax = capitalGainsIncome * 20.0 / 100;
        System.out.printf("Imposto sobre ganho de capital: %.2f%n", capitalGainsTax);

        System.out.println();
        System.out.println("DEDUÇÕES:");

        double grossTotal = salaryTax + serviceTax + capitalGainsTax;

        double maximumDeductible = grossTotal * 30.0 / 100;
        System.out.printf("Máximo dedutível: %.2f%n", maximumDeductible);

        double deductibleExpenses = medicalExpenses + educationalExpenses;
        if (deductibleExpenses > maximumDeductible){
            deduction += maximumDeductible;
        }
        else{
            deduction += deductibleExpenses;
        }
        System.out.printf("Gastos dedutíveis: %.2f%n", deductibleExpenses);

        double NetTotal = grossTotal - deduction;

        System.out.println();
        System.out.println("RESUMO:");
        System.out.printf("Imposto bruto total: %.2f%n", grossTotal);
        System.out.printf("Abatimento: %.2f%n",deduction);
        System.out.printf("Abatimento %.2f%n",NetTotal);



        sc.close();
    }
}
