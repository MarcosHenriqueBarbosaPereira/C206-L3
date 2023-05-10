public abstract class Pessoa {

    public static int qtdPessoa=0;
    protected String nome;
    protected int idade;
    protected int honra;
    public Arma arma;

    public Pessoa(String nome, int idade, int honra){
        this.nome = nome;
        this.idade = idade;
        this.honra = honra;
        qtdPessoa++;
    }

    public void mostraInfo(){
        System.out.println("Informações sobre o indivíduo: " + this.nome + ";");
        System.out.println("Idade: " + this.idade + ";");
        System.out.println("Honra: " + this.honra + ";");
        if(arma != null)
            System.out.println("Tipo de arma: " + arma.getTipo() + ";");
        else System.out.println("Não possui arma.");
    }

    public abstract void orar();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHonra(int honra) {
        this.honra = honra;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getHonra() {
        return honra;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }
}
