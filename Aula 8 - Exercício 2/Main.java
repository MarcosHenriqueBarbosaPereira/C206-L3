public class Main {
    
    public static void main(String[] args) {
        
        Fogao fogao = new Fogao(1, "Brasa", "Fogão + Forno", 3000, 6, "Automático");
        Geladeira geladeira = new Geladeira(2, "ColdBrisa", "Geladeira e Freezer de alta potência", 5000, 2, 2, "Freezer Inferior");

        System.out.println("Dados do Fogão: ");
        System.out.println(" - Código do produto: " + fogao.getCodigo());
        System.out.println(" - Fabricante: " + fogao.getFabricante());
        System.out.println(" - Descrição: " + fogao.getDescricao());
        System.out.println(" - Valor: R$" + fogao.getValor());
        System.out.println(" - Quantidade de Bocas: " + fogao.getQuantidadeBocas());
        System.out.println(" - Tipo de Acendimento; " + fogao.getTipoAcendimento());

        System.out.println();

        System.out.println("Dados da Geladeira: ");
        System.out.println(" - Código do produto: " + geladeira.getCodigo());
        System.out.println(" - Fabricante: " + geladeira.getFabricante());
        System.out.println(" - Descrição: " + geladeira.getDescricao());
        System.out.println(" - Valor: R$" + geladeira.getValor());
        System.out.println(" - Quantidade de Portas: " + geladeira.getQuantidadePortas());
        System.out.println(" - Tamanho; " + geladeira.getTamanho());
        System.out.println(" - Tipo: " + geladeira.getTipo());

    }
}
