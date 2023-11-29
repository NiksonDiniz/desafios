import java.util.Locale;
import java.util.Scanner;

public class Program {
   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);

      System.out.print("Renda anual com salário: ");
      double salarioAnual = sc.nextDouble();
      System.out.print("Renda anual com prestação de serviço: ");
      double servicoAnual = sc.nextDouble();
      System.out.print("Renda anual com ganho capital: ");
      double capitalAnual = sc.nextDouble();
      System.out.print("Gastos médicos: ");
      double gastoMedico = sc.nextDouble();
      System.out.print("Gastos educacionais: ");
      double gastoEducacional = sc.nextDouble();


      System.out.println("\nRELATÓRIO DE IMPOSTO DE RENDA");

      System.out.println("\nCONSOLIDADO DE RENDA:");
      System.out.printf("Imposto sobre salário: %.2f%n", CalcularImpostoSalario(salarioAnual));
      System.out.printf("Imposto sobre serviço: %.2f%n", ObterImpostoServico(servicoAnual));
      System.out.printf("Imposto sobre ganho de capital: %.2f%n", ObterImpostoCapital(capitalAnual));

      double impostoBruto = CalcularImpostoSalario(salarioAnual)
              + ObterImpostoServico(servicoAnual)
              + ObterImpostoCapital(capitalAnual);

      double dedutiveis = gastoEducacional + gastoMedico;
      double abatimentos = impostoBruto - CalcularAbatimento(dedutiveis, impostoBruto);

      System.out.println("\nDEDUÇÕES: ");
      System.out.printf("Máximo dedutível: %.2f%n", ObterMaximoDedutivel(impostoBruto));
      System.out.printf("Gastos dedutíveis: %.2f%n", dedutiveis);

      System.out.println("\nRESUMO: ");
      System.out.printf("Imposto bruto total: %.2f%n", impostoBruto);
      System.out.printf("Abatimento: %.2f%n", CalcularAbatimento(dedutiveis, impostoBruto));
      System.out.printf("Imposto devido: %.2f%n", abatimentos);

      sc.close();
   }

   public static double CalcularImpostoSalario(double rendaAnual) {
      double rendaMes = rendaAnual / 12.0;
      if (rendaMes < 3000.0) {
         return 0.0;
      } else if (rendaMes >= 3000.0 && rendaMes <= 5000.0) {
         return rendaAnual * 0.1;
      } else {
         return rendaAnual * 0.2;
      }
   }

   public static double ObterImpostoServico(double valorServico) {
      return valorServico * 0.15;
   }

   public static double ObterImpostoCapital(double valorCapital) {
      return valorCapital * 0.2;
   }

   public static double ObterMaximoDedutivel(double impostoBruto) {
      return impostoBruto * 0.3;
   }

   public static double CalcularAbatimento(double dedutivel, double impostoBruto) {
      if (dedutivel < impostoBruto) {
         return dedutivel;
      } else {
         return impostoBruto * 0.3;
      }
   }
}