public class Produto implements Comparable<Produto>{
    
    private String nome;
    private double preco;
    
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public int compareTo(Produto o) {
        if(this.preco < o.preco)
            return -1;
        if(this.preco > o.preco)
            return 1;
        return 0;
    }

    //Ordem Alfabética
    /*@Override
    public int compareTo(Produto o) {
        if(this.nome < o.nome)
            return -1;
        if(this.nome > o.nome)
            return 1;
        return 0;
    }*/

    //Ordem decrescente de preco
    /*@Override
    public int compareTo(Produto o) {
        if(this.preco < o.preco)
            return 1;
        if(this.preco > o.preco)
            return -1;
        return 0;
    }*/

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

}
