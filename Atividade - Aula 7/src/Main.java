public class Main {
    public static void main(String[] args) {

        Notebook p1 = new Notebook();
        Camiseta p2 = new Camiseta();

        p1.nome = "Acer";
        p1.preco = 4199.99;
        p1.armazenamento = 1;
        p1.processador = "INTEL CORE i5";
        p1.gpu = "Geforce GTX 1650";

        p2.nome = "Gucci";
        p2.preco = 249.99;
        p2.cor = "Rosa";
        p2.tamanho = "GG";

        System.out.println("----------------------------------------\nEtiqueta produto 1:\n" + p1.etiquetaPreco());
        System.out.println("----------------------------------------\nEtiqueta produto 2:\n" + p2.etiquetaPreco());
    }
}