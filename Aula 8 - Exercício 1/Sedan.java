public class Sedan extends Carro{

    private int portaMalas;

    public Sedan(double valor, String cor, int ano, int portaMalas) {
        super(valor, cor, ano);
        this.portaMalas = portaMalas;
    }
 
    @Override
    public void mostrarInfo(){
        System.out.println("\nDados da Sedan:");
        System.out.println("-Valor: R$" + this.valor);
        System.out.println("-Cor: " + this.cor);
        System.out.println("-Ano de fabricação: " + this.ano);
        System.out.println("-Porta Malas: " + this.portaMalas);
    }

    @Override
    public void taxa(){
        System.out.println("\nTaxa de IPVA da Sedan: " + ((this.valor*0.04)/100));
    }

}