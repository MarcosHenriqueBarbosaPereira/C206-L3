package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;

public class ClienteBD extends Database{

    public boolean auth(String username, String password){

        boolean aux = true;
        connect();
        String sql = "SELECT * from contas_clientes  WHERE username=? AND senha=?";

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

    public void funcoes(String username){
        Scanner entrada = new Scanner(System.in);
        int aux;
        boolean loop = true;

        System.out.println("Selecione sua operação de atendimento ao cliente:\n");

        System.out.println("1 - Realizar nova compra;\n2 - Verificar contas abertas;\n3 - Finalizar operações;");

        while(loop){
            try{
                aux = entrada.nextInt();
                entrada.nextLine();
                switch(aux){
                    case 1:
                        comprar(username);
                        loop = false;
                        break;

                    case 2:
                        verificarAbertos(username);
                        loop = false;
                        break;

                    case 3:
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

    public ArrayList<Produto> buscaProdutos(){
        connect();
        ArrayList<Produto> aux = new ArrayList<>();
        String sql = "SELECT DISTINCT(nome), preco, TIPO_PRODUTO_id from produtos";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Produto p = new Produto();
                p.nome = result.getString("nome");
                p.preco = result.getFloat("preco");
                p.tipo = result.getInt("TIPO_PRODUTO_id");

                aux.add(p);
            }
        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }

        return aux;
    }

    public ArrayList<Entregador> buscaEntregador(){
        connect();
        ArrayList<Entregador> entregadores = new ArrayList<>();
        String sql = "SELECT * from entregadores";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Entregador aux = new Entregador();
                aux.nome = result.getString("nome");
                aux.id = result.getInt("id");
                entregadores.add(aux);
            }
        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return entregadores;
    }

    public boolean deletaProduto(String nomeProduto){
        connect();
        String sql = "DELETE FROM produtos where nome = ? limit 1";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,nomeProduto);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public void updateTipo(int idTipo){
        connect();
        String sql = "UPDATE tipo_produto SET qnt_produtos=qnt_produtos-1 WHERE id = ?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idTipo);
            pst.execute();
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public void finalizarCompra(Carrinho kart, String username){
        boolean check;
        float precoTotal = 0;

        for(Produto p : kart.produtos){
            check = deletaProduto(p.nome);
            if(check) {
                precoTotal += p.preco;
                updateTipo(p.tipo);
            }
            else
                System.out.println("\nProduto " + p.nome + " indisponível! Removendo do carrinho!\n");
        }

        System.out.println("\nCompra final no valor de R$" + precoTotal);

        Scanner entrada = new Scanner(System.in);
        boolean loop = true;
        System.out.println("\nSelecione o entregador: \n");
        Entregador escolha = new Entregador();
        ArrayList<Entregador> aux = buscaEntregador();
        int i = 1;
        for(Entregador e : aux){
            System.out.println(i + " - " + e.nome + ";");
            i++;
        }
        System.out.println();
        while(loop){
            try{
                int ent;
                ent = entrada.nextInt();
                entrada.nextLine();
                if(ent >=1 && ent<i){
                    escolha = aux.get(ent - 1);
                    loop = false;
                }
                else
                    System.out.println("Escolha de entregador não válida. Tente novamente!\n");
            }catch(InputMismatchException e){
                System.out.println("Dados de entrada inválidos. Tente novamente!\n");
                entrada.nextLine();
            }
        }

        //-----------------------------------------------------------------------------------------

        connect();
        String sql = "INSERT INTO compras(valor_total,CONTAS_CLIENTES_username,ENTREGADORES_id) VALUES (?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setFloat(1, precoTotal);
            pst.setString(2, username);
            pst.setInt(3, escolha.id);
            pst.execute();
        }
        catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }

        //----------------------------------------------------------------------------------------

        connect();
        sql = "SELECT MAX(codigo) from compras WHERE CONTAS_CLIENTES_username=?";
        int codigo = 0;

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, username);
            result = pst.executeQuery();

            while(result.next()){
                codigo = result.getInt(1);
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

        //-------------------------------------------------------------------------------------

        String payment = "";
        System.out.println("Escolha a forma de pagamento:\n");
        System.out.println("1 - À Vista (Cartão de crédito / Débito / PIX);\n2 - Marcação (Pagamento Posterior);\n");
        loop = true;
        while(loop){
            try{
                int ent;
                ent = entrada.nextInt();
                entrada.nextLine();
                if(ent == 1) {
                    payment = "A Vista";
                    loop = false;
                }
                else if(ent == 2){
                    payment = "Marcação";
                    loop = false;
                }
                else
                    System.out.println("Escolha de produto não válida. Tente novamente!\n");
            }catch(InputMismatchException e){
                System.out.println("Dados de entrada inválidos. Tente novamente!\n");
                entrada.nextLine();
            }
        }

        //-------------------------------------------------------------------------------------

        connect();
        sql = "INSERT INTO pagamentos(valor_total,forma,pago,COMPRAS_codigo) VALUES (?,?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setFloat(1, precoTotal);
            pst.setString(2, payment);
            if(payment.equals("Marcação")){
                pst.setBoolean(3, false);
            }
            else if(payment.equals("A Vista")){
                pst.setBoolean(3, true);
            }
            pst.setInt(4, codigo);
            pst.execute();
        }
        catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                pst.close();
                System.out.println("\nCompra finalizada. Agradecemos a preferência!");
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public void comprar(String username){

        ArrayList<Produto> aux = buscaProdutos();
        Carrinho kart = new Carrinho();

        int i = 1;
        System.out.println("Selecione os produtos para adicionar ao carrinho:\n");
        for(Produto p : aux){
            System.out.println(i + " - " + p.nome + " - R$" + p.preco + ";");
            i++;
        }
        System.out.println("0 - Finalizar compra;\n");

        Scanner entrada = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            try{
                int ent;
                ent = entrada.nextInt();
                entrada.nextLine();
                if(ent == 0) {
                    finalizarCompra(kart, username);
                    loop = false;
                }
                else if(ent >= 1 && ent<i)
                    kart.produtos.add(aux.get(ent-1));
                else
                    System.out.println("Escolha de produto não válida. Tente novamente!\n");
            }catch(InputMismatchException e){
                System.out.println("Dados de entrada inválidos. Tente novamente!\n");
                entrada.nextLine();
            }
        }
    }

    public void verificarAbertos(String username){
        connect();
        ArrayList<Integer> pagamentos = new ArrayList<>();
        String sql = "SELECT p.codigo, p.valor_total, p.COMPRAS_codigo FROM pagamentos AS p, compras AS c WHERE c.CONTAS_CLIENTES_username=? AND c.codigo=p.COMPRAS_codigo AND p.pago=0";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, username);
            result = pst.executeQuery();

            boolean aux = false;
            int i = 1;
            System.out.println();
            while(result.next()){
                pagamentos.add(result.getInt("codigo"));
                System.out.println(i + " - R$" + result.getFloat("valor_total") + " - Compra: " + result.getInt("COMPRAS_codigo"));
                i++;
                aux = true;
            }
            if(aux){
                System.out.println("\nSe deseja pagar alguma conta em aberto, entre com o número dela. Caso contrário, entre com o valor 0 para encerrar a consulta:\n");
                while(aux){
                    Scanner entrada = new Scanner(System.in);
                    try{
                        int ent;
                        ent = entrada.nextInt();
                        entrada.nextLine();
                        if(ent == 0) {
                            aux = false;
                        }
                        else if(ent >= 1 && ent<i) {
                            updatePagamento(pagamentos.get(ent - 1));
                            System.out.println("\nPagamento realizado com sucesso!");
                            aux = false;
                        }
                        else
                            System.out.println("Escolha de operação não válida. Tente novamente!\n");
                    }catch(InputMismatchException e){
                        System.out.println("Dados de entrada inválidos. Tente novamente!\n");
                        entrada.nextLine();
                    }
                }
            }
            else
                System.out.println("Não há contas em aberto para seu nome. \nEncerrando consulta...");

        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally{
            try{
                connection.close();
                pst.close();
                result.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
    public void updatePagamento(int codigo){
        connect();
        String sql = "UPDATE pagamentos set pago=1 where codigo=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,codigo);
            pst.execute();
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
