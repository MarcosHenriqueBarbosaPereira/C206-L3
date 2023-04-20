public class Coruja extends Animal implements Alimentacao{

    private String cor;

    public Coruja(){
        super();
    }

    public void voar(){
        System.out.println("A coruja " + this.nome + " está voando.");
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Espécie: Coruja;");
        System.out.println("Cor: " + this.cor + ";");
    }

    @Override
    public String barulho(){
        return "Hoo ooH, Hoo ooH";
    }

    @Override
    public void comendo() {
        System.out.println("A coruja " + this.nome + " está comendo.");
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }
}
