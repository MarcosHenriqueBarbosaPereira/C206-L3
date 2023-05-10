public class SUV extends Carro {

    private String tracao;

    public SUV(double valor, String cor, int ano, String tracao) {
        super(valor, cor, ano);
        this.tracao = tracao;
    }
 
    @Override
    public void mostrarInfo(){
        System.out.println("\nDados da SUV:");
        System.out.println("-Valor: R$" + this.valor);
        System.out.println("-Cor: " + this.cor);
        System.out.println("-Ano de fabricação: " + this.ano);
        System.out.println("-Tração: " + this.tracao);
    }

    @Override
    public void taxa(){
        System.out.println("\nTaxa de IPVA da SUV: " + ((this.valor*0.04)/100));
    }
    
}
