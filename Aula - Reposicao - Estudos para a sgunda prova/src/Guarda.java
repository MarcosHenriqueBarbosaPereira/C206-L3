import interfaces.Patrulha;

public class Guarda extends Pessoa implements Patrulha{

    private int coragem;

    public Guarda(String nome, int idade, int honra, int coragem){
        super(nome, idade, honra);
        this.coragem = coragem;
    }

    public int getCoragem() {
        return coragem;
    }

    public void setCoragem(int coragem) {
        this.coragem = coragem;
    }

    public void orar(){
        System.out.println(this.nome + " fez uma oração aos deuses antigos");
    }

    @Override
    public void mostraInfo() {
        super.mostraInfo();
        System.out.println("Coragem: " + this.coragem + ";\n");
    }

    @Override
    public void fazerPatrulha() {
        System.out.println(this.nome + " fez uma patrulha além da muralha");
    }
}
