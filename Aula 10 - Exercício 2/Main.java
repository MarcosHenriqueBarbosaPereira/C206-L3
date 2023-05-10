import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Conta conta = new Conta(123, "Josival", 400, 1000);

        Scanner entrada = new Scanner(System.in);
        int op = 0;
        boolean aux = false;

        System.out.println("Bem vindo(a) ao atendimento do banco Uati.\n");

        do {
            System.out.println("Selecione a operação que deseja executar:");
            System.out.println(
                    "1 - Verificar dados da conta;\n2 - Verificar saldo atual;\n3 - Realizar um deposito;\n4 - Realizar um saque;\n5 - Finalizar o atendimento;\n");

            try {
                op = entrada.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Dados da conta:");
                        System.out.println(" - Número: " + conta.getNumero());
                        System.out.println(" - Cliente: " + conta.getNome());
                        System.out.println(" - Limite de Saque: R$" + conta.getLimite() + "\n");
                        break;
                    case 2:
                        System.out.println("Saldo atual da conta: R$" + conta.getSaldo() + "\n");
                        break;
                    case 3:
                        System.out.println("Entre com o valor que queira depositar:");
                        try {
                            conta.depositar(entrada.nextDouble());
                        } catch (InputMismatchException e) {
                            System.out.println("Dados de entrada inválidos!\nTente novamente!\n");
                            entrada.nextLine();
                        }
                        break;
                    case 4:
                        System.out.println("Entre com o valor que queira sacar:");
                        try {
                            conta.sacar(entrada.nextDouble());
                            System.out.println();
                        } catch (InputMismatchException e) {
                            System.out.println("Dados de entrada inválidos!\nTente novamente!\n");
                            entrada.nextLine();
                        } catch (SemLimite e) {
                            System.out.println("Limite insuficiente!\n");
                            entrada.nextLine();
                        } catch (SemSaldo e) {
                            System.out.println("Saldo insuficiente!\n");
                            entrada.nextLine();
                        }
                        break;
                    case 5:
                        System.out.println("Atendimento Finalizado");
                        aux = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor de entrada não valido, por favor tente novamente!\n");
                entrada.nextLine();
            }
        } while (aux == false);

        entrada.close();
    }

}