public class Main {

    public static void main(String[] args) {
        
        Contato c1 = new Contato("João", "joao@email.com", "99999-9999", "01/01/1991");
        Contato c2 = new Contato("Ana", "ana@email.com", "98888-8888", "02/02/1992");
        Contato c3 = new Contato("Maria", "maria@email.com", "97777-7777", "03/03/1993");
        Contato c4 = new Contato("Cléber", "cleber@email.com", "96666-6666", "04/04/1994");
        Contato c5 = new Contato("Adilson", "adilson@email.com", "95555-5555", "05/05/1995");

        Empresa empresa = new Empresa("1234567890", "Rua: Mesquita de Sobrado; Número: 321; Santa Rita do Sapucaí - MG;");

        empresa.contatos[0] = c1;
        empresa.contatos[1] = c2;
        empresa.contatos[2] = c3;
        empresa.contatos[3] = c4;
        empresa.contatos[4] = c5;

        empresa.exibirInfos();
    }

}