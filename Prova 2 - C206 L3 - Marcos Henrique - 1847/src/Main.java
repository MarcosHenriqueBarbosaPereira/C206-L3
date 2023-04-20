public class Main {
    public static void main(String[] args) {

        Zoo zoo = new Zoo();
        zoo.setNome("Zoomumba");
        zoo.setEndereco("Rua Edge, Número 512");
        zoo.setCnpj(12345678900L);

        Leao l1 = new Leao();
        l1.setNome("Simba");
        l1.setIdade(10);
        l1.setPerigoso(true);
        l1.setTamanhoJuba(40);

        Leao l2 = new Leao();
        l2.setNome("Nala");
        l2.setIdade(11);
        l2.setPerigoso(true);
        l2.setTamanhoJuba(0);

        Coruja c = new Coruja();
        c.setNome("Edwige");
        c.setIdade(6);
        c.setPerigoso(false);
        c.setCor("Branco");

        Gato g = new Gato();
        g.setNome("Gato");
        g.setIdade(500);
        g.setPerigoso(false);
        g.setRaca("Azul listrado");

        System.out.println("Total de animais no zoológico: " + Animal.qntAnimais + ";\n");

        zoo.animais[0] = l1;
        zoo.animais[1] = l2;
        zoo.animais[2] = c;
        zoo.animais[3] = g;

        zoo.mostraInfo();
    }
}