package view;

import controller.ClienteBD;
import controller.GerenciaBD;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema de compras do mercado Herrah Store!\n");

        System.out.println("Como deseja acessar nosso sistema?\n");
        System.out.println("1 - Acesso de gerência;\n2 - Acesso de cliente;\n3 - Fechar acesso;");

        int aux;
        boolean loopAcesso = true;
        while(loopAcesso){
            try{
                aux = entrada.nextInt();
                entrada.nextLine();
                switch(aux){

                    case 1:
                        GerenciaBD gerencia = new GerenciaBD();
                        System.out.println("\nEntre com suas credenciais de gerência:");
                        boolean gerAcesso = true;
                        while(gerAcesso) {
                            String username = "";
                            String password = "";
                            while (gerAcesso) {
                                try {
                                    username = entrada.nextLine();
                                    gerAcesso = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("\nDados de entrada inválidos. Tente novamente!");
                                    entrada.nextLine();
                                }
                            }
                            gerAcesso = true;
                            while (gerAcesso) {
                                try {
                                    password = entrada.nextLine();
                                    gerAcesso = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("\nDados de entrada inválidos. Tente novamente!");
                                    entrada.nextLine();
                                }
                            }
                            gerAcesso = gerencia.auth(username,password);
                            if(gerAcesso){
                                System.out.println("\nSenha ou usuário incorretos. Tente novamente!");
                            }
                            else{
                                gerencia.funcoes();
                            }
                        }
                        loopAcesso = false;
                        break;

                    case 2:
                        ClienteBD cliente = new ClienteBD();
                        System.out.println("\nEntre com suas credenciais de cliente:");
                        boolean cliAcesso = true;
                        while(cliAcesso) {
                            String username = "";
                            String password = "";
                            while (cliAcesso) {
                                try {
                                    username = entrada.nextLine();
                                    cliAcesso = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("\nDados de entrada inválidos. Tente novamente!");
                                    entrada.nextLine();
                                }
                            }
                            cliAcesso = true;
                            while (cliAcesso) {
                                try {
                                    password = entrada.nextLine();
                                    cliAcesso = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("\nDados de entrada inválidos. Tente novamente!");
                                    entrada.nextLine();
                                }
                            }
                            cliAcesso = cliente.auth(username,password);
                            if(cliAcesso){
                                System.out.println("\nSenha ou usuário incorretos. Tente novamente!");
                            }
                            else{
                                cliente.funcoes(username);
                            }
                        }
                        loopAcesso = false;
                        break;

                    case 3:
                        loopAcesso = false;
                        System.out.println("\nAgradecemos por utilizar nossos serviços. Tenha um bom dia!");
                        break;

                    default:
                        System.out.println("\nNão há opções correspondentes a essa entrada. Tente novamente!");
                }
            }catch(InputMismatchException e){
                System.out.println("\nDados de entrada inválidos. Tente novamente!");
                entrada.nextLine();
            }
        }

        entrada.close();

    }
}