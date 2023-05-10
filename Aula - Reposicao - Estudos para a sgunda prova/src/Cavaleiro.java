public class Cavaleiro extends Pessoa{

    private String casa;
    private String nomeEscudeiro;

    public Montaria montaria;

    public Cavaleiro(String nome, int idade, int honra, String casa, String nomeEscudeiro){
        super(nome, idade, honra);
        this.casa = casa;
        this.nomeEscudeiro = nomeEscudeiro;
    }

    public void orar() {
        System.out.println(this.nome + "fez uma oração ao deus do fogo");
    }

    @Override
    public void mostraInfo() {
        super.mostraInfo();
        System.out.println("Casa: " + this.casa + ";");
        System.out.println("Escudeiro: " + this.nomeEscudeiro + ";");
        if(montaria != null)
            System.out.println("Montaria: " + montaria.getNome() + ";");
        else System.out.println("Este Cavaleiro não possui montaria.");
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getCasa() {
        return casa;
    }

    public void setNomeEscudeiro(String nomeEscudeiro) {
        this.nomeEscudeiro = nomeEscudeiro;
    }

    public String getNomeEscudeiro() {
        return nomeEscudeiro;
    }
}
