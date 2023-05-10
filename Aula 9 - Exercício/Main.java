import java.util.Collections;

public class Main {
    
    public static void main(String[] args) {
        
        Carrinho car = new Carrinho();

        Produto p1 = new Produto("Sabonete", 5);
        Produto p2 = new Produto("Tênis", 119.99);
        Produto p3 = new Produto("Chiclete", 2.50);

        car.addProduto(p1);
        car.addProduto(p2);
        car.addProduto(p3);

        Collections.sort(car.getProdutos());

        System.out.println("Lista de produtos: ");
        for(Produto aux : car.getProdutos()){
            System.out.println("\n - Nome: " + aux.getNome());
            System.out.println(" - Preço: " + aux.getPreco());
        }
    }
}
