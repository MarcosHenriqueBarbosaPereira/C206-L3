public class Restaurante {
    
    public String cnpj;
    public String endereco;
    public String nome;
    public Fornecedor[] fornecedores = new Fornecedor[5];
    
    public Restaurante(String cnpj, String endereco, String nome) {
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.nome = nome;
    }

    public void exibirInfos(){
        System.out.println("Dados do Restaurante:");
        System.out.println("Nome: " + this.nome);
        System.out.println("CNPJ: " + this.cnpj);
        System.out.println("Endereco: " + this.endereco);
        System.out.println("\nLista de contatos de negócios:");
        for(Fornecedor aux : fornecedores){
            if(aux != null){
                System.out.println("\n - " + aux.tipo);
                System.out.println(" - " + aux.quantidade);
            }
            else break;
        }
    }

}
