public class Main {
    public static void main(String[] args) {

        Carrinho car = new Carrinho();

        Produto p1 = new Produto();
        Produto p2 = new Produto();
        Produto p3 = new Produto();

        p1.nome = "Amaciante";
        p1.descricao = "Limpeza";
        p1.fabricante = "Matheus";
        p1.preco = 10.25;

        p2.nome = "Sabonete";
        p2.descricao = "Higiene";
        p2.fabricante = "Dove";
        p2.preco = 2.95;

        p3.nome = "Camisinha";
        p3.descricao = "Saúde";
        p3.fabricante = "Jontex";
        p3.preco = 17.20;

        car.produtos[0] = p1;
        car.produtos[1] = p2;
        car.produtos[2] = p3;

        car.exibirInfos();

        System.out.println("Total da compra: R$" + car.calculaTotal());

    }
}