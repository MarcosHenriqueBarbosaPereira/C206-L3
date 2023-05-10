public class Main {

    public static void main(String[] args) {
        
        Fornecedor f1 = new Fornecedor("Carnes", 100);
        Fornecedor f2 = new Fornecedor("Álcool", 50);
        Fornecedor f3 = new Fornecedor("Sucos", 30);
        Fornecedor f4 = new Fornecedor("Talheres", 25);
        Fornecedor f5 = new Fornecedor("Guardanapos", 15);

        Restaurante restaurante = new Restaurante("12345678900", "Rua Euclides; Número 300;", "Serra Azul");

        restaurante.fornecedores[0] = f1;
        restaurante.fornecedores[1] = f2;
        restaurante.fornecedores[2] = f3;
        restaurante.fornecedores[3] = f4;
        restaurante.fornecedores[4] = f5;

        restaurante.exibirInfos();
    }
    
}
