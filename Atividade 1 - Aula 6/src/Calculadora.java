public class Calculadora {

    public static double PI = 3.14;

    public static double circunferencia(double raio){
        return 2*PI*raio;
    }

    public static double volume(double raio){
        return Math.pow(raio,3)*PI*3/4;
    }

}
