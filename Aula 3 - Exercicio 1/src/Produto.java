public class Produto {

    int codigoSerie;
    String codigoProduto;
    String nome;
    String categoria;
    int quantidade;

    void mostraInfo(){

        System.out.println("Serão vendidas " + quantidade + " unidades do produto " + nome + " da secao de " + categoria + ", contem codigo " + codigoProduto + " e serie " + codigoSerie);

    }
}
