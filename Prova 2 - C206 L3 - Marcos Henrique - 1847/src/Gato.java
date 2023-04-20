public class Gato extends Animal implements Alimentacao{

    private String raca;

    public Gato(){
        super();
    }

    public void correr(){
        System.out.println("O gato " + this.nome + " está correndo.");
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Espécie: Gato;");
        System.out.println("Raça: " + this.raca + ";");
    }

    @Override
    public String barulho(){
        return "Miau! Tome cuidado Alice! Miau!";
    }

    @Override
    public void comendo() {
        System.out.println("O Gato " + this.nome + " está comendo.");
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }
}
