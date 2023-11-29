package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);

      List<TaxPayer> taxPayers = new ArrayList<>();

      System.out.print("Quantos contribuintes você vai digitar? ");
      int n = sc.nextInt();

      for (int i = 1; i <= n; i++) {
         System.out.println("\nDigite os dados do " + i + "o contribuinte:");
         System.out.print("Renda anual com salário: ");
         double salaryIncome = sc.nextDouble();
         System.out.print("Renda anual com prestação de serviço: ");
         double servicesIncome = sc.nextDouble();
         System.out.print("Renda anual com ganho de capital: ");
         double capitalIncome = sc.nextDouble();
         System.out.print("Gastos médicos: ");
         double healthSpending = sc.nextDouble();
         System.out.print("Gastos educacionais: ");
         double educationSpending = sc.nextDouble();

         taxPayers.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
      }

      int count = 1;
      for (TaxPayer tax : taxPayers) {
         System.out.println("\nResumo do " + (count++) + "o contribuinte:");
         System.out.println(tax);
      }

      sc.close();
   }
}
