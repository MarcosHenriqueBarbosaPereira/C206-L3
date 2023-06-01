package view;

import java.util.*;
import model.*;
import controller.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        boolean loop = true;

        System.out.println("Sistema de gerenciamento de dados do corpo docente:");
        
        do{
            System.out.println("\nSelecione a opção que deseja executar:");
            System.out.println("1 -> Inserir novo professor;");
            System.out.println("2 -> Deletar dados de um professor;");
            System.out.println("3 -> Listar informações dos professores;");
            System.out.println("9 -> Finalizar operações;\n");
            try{
                int aux=0;
                aux = entrada.nextInt();
                entrada.nextLine();
                switch(aux){
                    case 1:
                        System.out.println("Entre com os dados do professor:\n");
                        Professores p = new Professores();
                        boolean in = true;
                        
                        System.out.println("Nome:");
                        do{
                            try{
                                p.nome = entrada.nextLine();
                                in = false;
                            }catch(InputMismatchException e){
                                System.out.println("Dados de entrada inválido, tente novamente!");
                                entrada.nextLine();
                            }
                        }while(in==true);

                        System.out.println("CPF:");
                        in = true;
                        do{
                            try{
                                p.cpf = entrada.nextLine();
                                in = false;
                            }catch(InputMismatchException e){
                                System.out.println("Dados de entrada inválido, tente novamente!");
                                entrada.nextLine();
                            }
                        }while(in==true);

                        System.out.println("Matéria:");
                        in = true;
                        do{
                            try{
                                p.materia = entrada.nextLine();
                                in = false;
                            }catch(InputMismatchException e){
                                System.out.println("Dados de entrada inválido, tente novamente!");
                                entrada.nextLine();
                            }
                        }while(in==true);

                        Arquivo.escrever(p);

                        break;

                    case 2:
                        System.out.println("Entre com o CPF do professor que queira deletar:");
                        boolean del = true;
                        String cpfAux = "";
                        do{
                            try{
                                cpfAux = entrada.nextLine();
                                del = false;
                            }catch(InputMismatchException e){
                                System.out.println("Dados de entrada inválido, tente novamente!");
                                entrada.nextLine();
                            }
                        }while(del==true);

                        Arquivo.remover(cpfAux);

                        break;

                    case 3:
                        Arquivo.mostraDados();
                        break;

                    case 9:
                        loop = false;
                        break;

                    default:
                        System.out.println("Não há operações para a opção selecionada!\n");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Erro na seleção de operações! Entre com um número inteiro por favor!\n");
                entrada.nextLine();
            }

        }while(loop==true);


        entrada.close();
        
    }
}