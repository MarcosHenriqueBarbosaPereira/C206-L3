public class Zoo {

    private String nome;
    private String endereco;
    private long cnpj;
    Animal[] animais = new Animal[10];

    public Zoo(){
    }

    public void mostraInfo(){
        System.out.println("Dados sobre o Zoológico " + this.nome + ":");
        System.out.println("Endereço: " + this.endereco + ";");
        System.out.println("CNPJ: " + this.cnpj + ";");
        System.out.println("Animais presentes no zoológico:\n");
        int l=0;
        int c=0;
        int g=0;
        for(int i = 0; i<animais.length; i++){
            if(animais[i] == null)
                break;
            else if(animais[i] instanceof Leao){
                l++;
                animais[i].mostraInfo();
                System.out.println("Este animal faz o seguinte barulho: " + animais[i].barulho());
                ((Leao) animais[i]).dormir();
                System.out.println();
            }
            else if(animais[i] instanceof Coruja){
                c++;
                animais[i].mostraInfo();
                System.out.println("Este animal faz o seguinte barulho: " + animais[i].barulho());
                ((Coruja) animais[i]).comendo();
                ((Coruja) animais[i]).voar();
                System.out.println();
            }
            else if(animais[i] instanceof Gato){
                g++;
                animais[i].mostraInfo();
                System.out.println("Este animal faz o seguinte barulho: " + animais[i].barulho() + ";");
                ((Gato) animais[i]).comendo();
                ((Gato) animais[i]).correr();
                System.out.println();
            }
        }
        System.out.println("Neste Zoológico há um total de " + Animal.qntAnimais + " animais;");
        System.out.println("Sendo eles : " + l + " Leão(ões), " + c + " Coruja(s) e " + g + " Gato(s);");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome(){
        return this.nome;
    }

    public long getCnpj() {
        return cnpj;
    }

    public String getEndereco() {
        return endereco;
    }
}
