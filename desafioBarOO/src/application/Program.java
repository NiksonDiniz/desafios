package application;

import entities.Bill;

import java.util.Locale;
import java.util.Scanner;

public class Program {
   public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner sc = new Scanner(System.in);

      System.out.print("Sexo: ");
      char gender = sc.next().charAt(0);
      while (gender != 'F' && gender != 'M') {
         System.out.print("Sexo (F ou M): ");
         gender = sc.next().charAt(0);
      }

      System.out.print("Quantidade de cervejas: ");
      int beer = sc.nextInt();
      System.out.print("Quantidade de refrigerantes: ");
      int softDrink = sc.nextInt();
      System.out.print("Quantidade de espetinhos: ");
      int barbecue = sc.nextInt();

      Bill bill = new Bill(gender, beer, barbecue, softDrink);

      System.out.println("\nRELATÓRIO: ");
      System.out.printf("Consumo = R$ %.2f%n", bill.feeding());

      if (bill.cover() > 0.0) {
         System.out.printf("Couvert = R$ %.2f%n", bill.cover());
      } else {
         System.out.println("Isento de Couvert");
      }

      System.out.printf("Ingresso = R$ %.2f%n", bill.ticket());
      System.out.printf("\nValor a pagar = R$ %.2f%n", bill.total());

      sc.close();
   }
}
