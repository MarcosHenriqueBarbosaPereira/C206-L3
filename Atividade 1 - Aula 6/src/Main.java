import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double raio;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Insira o raio da sua esfera (em centímetros):");
        raio = entrada.nextDouble();

        System.out.println("\nCircunferência da esfera: " + Calculadora.circunferencia(raio) + " cm^2");
        System.out.println("\nVolume da esfera: " + Calculadora.volume(raio) + " cm^3");
    }
}