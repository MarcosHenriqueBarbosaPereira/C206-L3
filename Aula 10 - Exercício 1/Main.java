import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        double x=0;
        double y=0;
        double resultado=0;
        boolean aux;
        int operacao;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Entre com o primeiro valor: ");

        do{
            try{
                x=entrada.nextDouble();
                aux = true;
            }catch(InputMismatchException e){
                System.out.println("Entrada de valor inválida. (" + e + ")");
                aux = false;
                entrada = new Scanner(System.in);
            }
        }while(aux==false);

        System.out.println("\nEntre com o segundo valor: ");

        do{
            try{
                y=entrada.nextDouble();
                aux = true;
            }catch(InputMismatchException e){
                System.out.println("Entrada de valor inválida. (" + e + ")");
                aux = false;
                entrada = new Scanner(System.in);
            }
        }while(aux==false);

        System.out.println("\nSelecione o tipo de operação entre os valores: \n 1 = +\n 2 = -\n 3 = *\n 4 = /\n");

        do{
            try{
                operacao=entrada.nextInt();
                switch(operacao){
                    case 1:
                        resultado = x+y;
                        aux = true;
                        break;
                    case 2:
                        resultado = x-y;
                        aux = true;
                        break;
                    case 3:
                        resultado = x*y;
                        aux = true;
                        break;
                    case 4:
                        try{
                            resultado = x/y;
                            aux = true;
                        }catch(ArithmeticException e){
                            System.out.println("Operação inválida. (" + e + ")");
                            aux = false;
                            entrada = new Scanner(System.in);
                        }
                        break;
                    default:
                        System.out.println("Opção Inválida.");
                        aux = false;
                }
            }catch(InputMismatchException e){
                System.out.println("Entrada de valor inválida. (" + e + ")");
                aux = false;
                entrada = new Scanner(System.in);
            }
        }while(aux==false);

        System.out.println("\nResultado da operação: " + resultado);

        entrada.close();
    }
    
}
