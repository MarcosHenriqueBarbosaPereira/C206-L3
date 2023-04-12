public class Camiseta extends Produto{

    String cor;
    String tamanho;

    @Override
    String etiquetaPreco(){
        return (this.nome + " - " + this.preco + "R$\nCor: " + this.cor + "\nTamanho: " + this.tamanho);
    }

}
