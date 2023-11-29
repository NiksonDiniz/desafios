package entities;

import java.text.DecimalFormat;

public class TaxPayer {
   private Double salaryIncome;
   private Double servicesIncome;
   private Double capitalIncome;
   private Double healthSpending;
   private Double educationSpending;

   public TaxPayer() {
   }

   public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
      this.salaryIncome = salaryIncome;
      this.servicesIncome = servicesIncome;
      this.capitalIncome = capitalIncome;
      this.healthSpending = healthSpending;
      this.educationSpending = educationSpending;
   }

   public Double getSalaryIncome() {
      return salaryIncome;
   }

   public void setSalaryIncome(Double salaryIncome) {
      this.salaryIncome = salaryIncome;
   }

   public Double getServicesIncome() {
      return servicesIncome;
   }

   public void setServicesIncome(Double servicesIncome) {
      this.servicesIncome = servicesIncome;
   }

   public Double getCapitalIncome() {
      return capitalIncome;
   }

   public void setCapitalIncome(Double capitalIncome) {
      this.capitalIncome = capitalIncome;
   }

   public Double getHealthSpending() {
      return healthSpending;
   }

   public void setHealthSpending(Double healthSpending) {
      this.healthSpending = healthSpending;
   }

   public Double getEducationSpending() {
      return educationSpending;
   }

   public void setEducationSpending(Double educationSpending) {
      this.educationSpending = educationSpending;
   }

   public double salaryTax() {
      double salary = salaryIncome / 12.0;
      if (salary < 3000.0) {
         return 0.0;
      } else if (salary >= 3000.0 && salary <= 5000.0) {
         return 0.1;
      } else {
         return 0.2;
      }
   }

   public double servicesTax() {
      if (servicesIncome != 0.0) {
         return 0.15;
      } else {
         return 0.0;
      }
   }

   public double capitalTax() {
      if (capitalIncome != 0.0) {
         return 0.2;
      } else {
         return 0.0;
      }
   }

   public double grossTax() {
      return (salaryIncome * salaryTax())
              + (servicesIncome * servicesTax())
              + (capitalIncome * capitalTax());
   }

   public double taxRebate() {
      double rebate = healthSpending + educationSpending;
      if (rebate < grossTax()) {
         return rebate;
      } else {
         return grossTax() * 0.3;
      }
   }

   public double netTax() {
      return grossTax() - taxRebate();
   }

   @Override
   public String toString() {
      DecimalFormat formatter = new DecimalFormat("####.00");
      StringBuilder sb = new StringBuilder();
      sb.append("Imposto bruto total: " + formatter.format(grossTax()));
      sb.append("\nAbatimento: " + formatter.format(taxRebate()));
      sb.append("\nImposto devido: " + formatter.format(netTax()));
      return sb.toString();
   }
}
