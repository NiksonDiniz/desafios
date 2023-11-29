import java.util.List;

public class Atleta {
   private String nome;
   private char sexo;
   private double altura;
   private double peso;

   public Atleta() {
   }

   public Atleta(String nome, char sexo, double altura, double peso) {
      this.nome = nome;
      this.sexo = sexo;
      this.altura = altura;
      this.peso = peso;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public char getSexo() {
      return sexo;
   }

   public void setSexo(char sexo) {
      this.sexo = sexo;
   }

   public double getAltura() {
      return altura;
   }

   public void setAltura(double altura) {
      this.altura = altura;
   }

   public double getPeso() {
      return peso;
   }

   public void setPeso(double peso) {
      this.peso = peso;
   }

}
