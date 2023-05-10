public class Empresa {
    
    public String cnpj;
    public String endereco;
    public Contato[] contatos = new Contato[10];

    public Empresa(String cnpj, String endereco) {
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public void exibirInfos(){
        System.out.println("Dados da empresa:");
        System.out.println("CNPJ: " + this.cnpj);
        System.out.println("Endereco: " + this.endereco);
        System.out.println("\nLista de contatos de negócios:");
        for(Contato aux : contatos){
            if(aux != null){
                System.out.println("\n - " + aux.nome);
                System.out.println(" - " + aux.email);
                System.out.println(" - " + aux.telefone);
                System.out.println(" - " + aux.dataNascimento);
            }
            else break;
        }
    }
}
