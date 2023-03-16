public class Main {
    public static void main(String[] args) {

        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        produto1.codigoSerie = 987;
        produto1.codigoProduto = "4ABC5D";
        produto1.nome = "Amaciante";
        produto1.categoria = "Produto de Limpeza";
        produto1.quantidade = 2;

        produto2.codigoSerie = 143;
        produto2.codigoProduto = "C0NTR4";
        produto2.nome = "Contrafilé";
        produto2.categoria = "Frios";
        produto2.quantidade = 5;


        produto1.mostraInfo();
        produto2.mostraInfo();
    }
}