public class Carrinho {

    double total;
    Produto[] produtos = new Produto[52];

    void exibirInfos(){
        System.out.println("Seguem dados dos produtos no carrinho:");
        for(Produto aux : produtos){
            if(aux != null){
                System.out.println("Produto: " + aux.nome + "; Descrição: " + aux.descricao + "; Fabricante: " + aux.fabricante + "; Preço: " + aux.preco + ".");
            }
            else break;
        }
    }

    double calculaTotal(){
        double total = 0;
        for(Produto aux : produtos){
            if(aux != null){
                total += aux.preco;
            }
            else break;
        }
        return total;
    }
}
