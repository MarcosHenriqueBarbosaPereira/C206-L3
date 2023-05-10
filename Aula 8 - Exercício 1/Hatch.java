public class Hatch extends Carro{
    
    private int portas;

    public Hatch(double valor, String cor, int ano, int portas) {
        super(valor, cor, ano);
        this.portas = portas;
    }
 
    @Override
    public void mostrarInfo(){
        System.out.println("\nDados da Hatch:");
        System.out.println("-Valor: R$" + this.valor);
        System.out.println("-Cor: " + this.cor);
        System.out.println("-Ano de fabricação: " + this.ano);
        System.out.println("-Portas: " + this.portas);
    }

    @Override
    public void taxa(){
        System.out.println("\nTaxa de IPVA da Hatch: " + ((this.valor*0.04)/100));
    }
}
