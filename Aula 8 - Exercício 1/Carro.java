public abstract class Carro implements Controle{
    
    protected double valor;
    protected String cor;
    protected int ano;
    
    public Carro(double valor, String cor, int ano) {
        this.valor = valor;
        this.cor = cor;
        this.ano = ano;
    }

}
