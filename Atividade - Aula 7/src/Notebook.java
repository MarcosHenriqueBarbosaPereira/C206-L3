public class Notebook extends Produto{

    double armazenamento;
    String gpu;
    String processador;

    @Override
    String etiquetaPreco(){
        return (this.nome + " - " + this.preco + "R$\n" + this.armazenamento + "GB\nProcessador: " + this.processador + "\nGPU: " + this.gpu);
    }

}
