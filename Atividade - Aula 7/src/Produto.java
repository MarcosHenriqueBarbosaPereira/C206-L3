public class Produto {

    String nome;
    double preco;

    String etiquetaPreco(){
        return (this.nome + " - " + this.preco + "R$");
    }
}
