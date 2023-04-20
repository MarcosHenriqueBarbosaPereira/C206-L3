public class Leao extends Animal{

    private float tamanhoJuba;

    public Leao(){
        super();
    }

    public void dormir(){
        System.out.println("O leão " + this.nome + " está dormindo.");
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Espécie: Leão;");
        System.out.println("Tamanho da Juba: " + this.tamanhoJuba + " cm;");
    }

    @Override
    public String barulho(){
        return "Raurrr";
    }

    public void setTamanhoJuba(float tamanhoJuba) {
        this.tamanhoJuba = tamanhoJuba;
    }

    public float getTamanhoJuba() {
        return tamanhoJuba;
    }
}
