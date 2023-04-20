public abstract class Animal {

    public static int qntAnimais=0;
    protected String nome;
    protected int idade;
    protected boolean perigoso;

    public Animal(){
        qntAnimais++;
    }

    public void mostraInfo(){
        System.out.println("Informações sobre o animal " + this.nome + ":");
        System.out.println("Idade: " + this.idade + ";");
        System.out.print("É perigoso?: ");
        if(this.perigoso)
            System.out.println("Sim;");
        else System.out.println("Não;");
    }

    public abstract String barulho();

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPerigoso(boolean perigoso) {
        this.perigoso = perigoso;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isPerigoso() {
        return perigoso;
    }
}
