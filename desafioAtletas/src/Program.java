import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);

      System.out.print("Qual a quantidade de atletas? ");
      int n = sc.nextInt();

      List<Atleta> atletas = new ArrayList<>();

      for (int i = 1; i <= n; i++) {
         System.out.println("Digite os dados do atleta numero " + i + ":");
         System.out.print("Nome: ");
         sc.nextLine();
         String nome = sc.nextLine();
         System.out.print("Sexo: ");
         char sexo = sc.next().charAt(0);
         while (sexo != 'F' && sexo != 'M') {
            System.out.print("Valor invalido! Favor digitar F ou M: ");
            sexo = sc.next().charAt(0);
         }

         System.out.print("Altura: ");
         double altura = sc.nextDouble();
         while (altura <= 0) {
            System.out.print("Valor invalido! Favor digitar um valor positivo: ");
            altura = sc.nextDouble();
         }
         System.out.print("Peso: ");
         double peso = sc.nextDouble();
         while (peso <= 0) {
            System.out.print("Valor invalido! Favor digitar um valor positivo: ");
            peso = sc.nextDouble();
         }

         atletas.add(new Atleta(nome, sexo, altura, peso));
      }


      System.out.println("\nRELATÓRIO: ");
      System.out.printf("Peso médio dos atletas: %.2f%n", calcularMediaPeso(atletas));
      System.out.println("Atleta mais alto: " + obterAlturaMaior(atletas).getNome());
      System.out.printf("Porcentagem de homens: %.2f %%%n", obterPorcentagemHomem(atletas));

      if (calcularAlturaMediaMulher(atletas) == 0.0) {
         System.out.println("Não há mulheres cadastradas");
      } else {
         System.out.printf("Altura média das mulheres: %.2f%n", calcularAlturaMediaMulher(atletas));
      }

      sc.close();
   }

   public static double calcularMediaPeso(List<Atleta> lista) {
      double somaPeso = 0.0;
      for (Atleta atleta : lista) {
         somaPeso += atleta.getPeso();
      }
      return somaPeso / lista.size();
   }

   public static Atleta obterAlturaMaior(List<Atleta> lista) {
      double maior = 0.0;
      Atleta atletaAlto = null;

      for (Atleta at : lista) {
         if (at.getAltura() > maior) {
            maior = at.getAltura();
            atletaAlto = at;
         }
      }

      return atletaAlto;
   }

   public static double obterPorcentagemHomem(List<Atleta> lista) {
      int femenino = 0;
      int masculino = 0;

      for (Atleta at : lista) {
         if (at.getSexo() == 'F') {
            femenino++;
         } else {
            masculino++;
         }
      }

      double total = femenino + masculino;
      double percentHomens = 0.0;
      if (masculino > 0) {
         percentHomens = masculino / total * 100.0;
      }

      return percentHomens;
   }

   public static double calcularAlturaMediaMulher(List<Atleta> lista) {
      int femenino = 0;
      double somaAltura = 0.0;

      for (Atleta at : lista) {
         if (at.getSexo() == 'F') {
            femenino++;
            somaAltura += at.getAltura();
         }
      }

      if (femenino == 0) {
         return 0.0;
      } else {
         return somaAltura / femenino;
      }
   }
}

