package controller;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciaBD extends Database{

    public boolean auth(String username, String password){

        boolean aux = true;
        connect();
        String sql = "SELECT * from contas_gerencia WHERE username=? AND senha=?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            result = pst.executeQuery();

            while(result.next()){
                aux = false;
            }
        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                pst.close();
                result.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return aux;
    }

    public void funcoes(){
        Scanner entrada = new Scanner(System.in);
        int aux;
        boolean loop = true;

        System.out.println("Selecione sua operação gerenciamento:\n");

        System.out.println("1 - Verificar pagamentos em aberto;\n2 - Verificar autorizações dos entregadores;\n3 - Verificar contas pagas/Total recebido;\n4 - Finalizar operações;");

        while(loop){
            try{
                aux = entrada.nextInt();
                entrada.nextLine();
                switch(aux){
                    case 1:
                        verificarAbertos();
                        loop = false;
                        break;

                    case 2:
                        verificarPermissao();
                        loop = false;
                        break;

                    case 3:
                        verificarRecebimento();
                        loop = false;
                        break;

                    case 4:
                        loop = false;
                        break;

                    default:
                        System.out.println("Opção selecionada não existente. Tente novamente!");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Dados de entrada inválidos. Tente novamente!");
                entrada.nextLine();
            }
        }
        entrada.close();
    }

    public void verificarAbertos(){
        connect();
        String sql = "SELECT p.codigo, p.valor_total, p.COMPRAS_codigo, c.CONTAS_CLIENTES_username FROM pagamentos AS p, compras AS c WHERE c.codigo=p.COMPRAS_codigo AND p.pago=0";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            boolean aux = false;
            System.out.println();
            while(result.next()){
                System.out.println(result.getInt("codigo") + " - R$" + result.getFloat("valor_total") + " - Compra: " + result.getInt("COMPRAS_codigo") + " - Cliente: " + result.getString("CONTAS_CLIENTES_username"));
                aux = true;
            }
            if(!aux)
                System.out.println("Não há pagamentos em aberto. Encerrando consulta...");
        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally{
            try{
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public void verificarPermissao(){
        connect();
        String sql = "SELECT a.VEICULOS_ENTREGA_placa, a.ENTREGADORES_id, e.nome FROM autorizacao_uso_veiculo AS a, entregadores AS e, veiculos_entrega as V WHERE a.VEICULOS_ENTREGA_placa=v.placa AND e.id=a.ENTREGADORES_id";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            System.out.println();
            while(result.next()){
                System.out.println(result.getString("ENTREGADORES_id") + " - " + result.getString("nome") + " - Veículo: " + result.getString("VEICULOS_ENTREGA_placa") + ";");
            }
        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally{
            try{
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public void verificarRecebimento(){
        connect();
        String sql = "SELECT p.codigo, p.valor_total, p.COMPRAS_codigo, c.CONTAS_CLIENTES_username FROM pagamentos AS p, compras AS c WHERE c.codigo=p.COMPRAS_codigo AND p.pago=1";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            float totalRecebido = 0;
            boolean aux = false;
            System.out.println();
            while(result.next()){
                System.out.println(result.getInt("codigo") + " - R$" + result.getFloat("valor_total") + " - Compra: " + result.getInt("COMPRAS_codigo") + " - Cliente: " + result.getString("CONTAS_CLIENTES_username"));
                totalRecebido += result.getFloat("valor_total");
                aux = true;
            }
            if(!aux)
                System.out.println("\nNão há pagamentos fechados. Encerrando consulta...");
            else
                System.out.println("\nValor Final recebido: R$" + totalRecebido);
        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally{
            try{
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
