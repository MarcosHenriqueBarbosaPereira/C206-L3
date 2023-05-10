import interfaces.Consagra;

public class Lorde extends Pessoa implements Consagra{

    private String casa;
    private int qtdVassalos;
    
    public Lorde(String nome, int idade, int honra, String casa, int qtdVassalos) {
        super(nome, idade, honra);
        this.casa = casa;
        this.qtdVassalos = qtdVassalos;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public int getQtdVassalos() {
        return qtdVassalos;
    }

    public void setQtdVassalos(int qtdVassalos) {
        this.qtdVassalos = qtdVassalos;
    }

    @Override
    public void orar(){
        System.out.println(this.nome + " fez uma oração aos sete deuses.");
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Casa: " + this.casa + ";");
        System.out.println("Quantidade de Vassalos: " + this.qtdVassalos + ";\n");
    }

    @Override
    public void consagrarCavaleiro() {
        System.out.println(this.nome + " consagrou um novo cavaleiro");
        this.qtdVassalos += 1;
    }
    
}
