public class Main {
    public static void main(String[] args) {
        
        Guarda guarda = new Guarda("Joana", 27, 43, 121);
        Cavaleiro cavaleiro = new Cavaleiro("Dom Quixote", 32, 51, "Rosa", "Sancho");
        Lorde lorde = new Lorde("Voldemort", 71, 5, "Sonserina", 1000);

        Arma a1 = new Arma("Espada");
        Arma a2 = new Arma("Arco e flecha");

        Montaria m = new Montaria("Pé de pano");

        guarda.arma = a1;
        cavaleiro.arma = a2;
        cavaleiro.montaria = m;

        Pessoa[] pessoas = new Pessoa[5];

        pessoas[0] = guarda;
        pessoas[1] = cavaleiro;
        pessoas[2] = lorde;

        for(Pessoa aux : pessoas){
            if(aux != null){
                if(aux instanceof Guarda){
                    aux.orar();
                    ((Guarda) aux).fazerPatrulha();
                    aux.mostraInfo();
                }
                else if(aux instanceof Cavaleiro){
                    aux.orar();
                    ((Cavaleiro) aux).fazerPatrulha();
                    ((Cavaleiro) aux).consagrarCavaleiro();
                    aux.mostraInfo();
                }
                else if(aux instanceof Lorde){
                    aux.orar();
                    ((Lorde) aux).consagrarCavaleiro();
                    aux.mostraInfo();
                }
            }
        }

    }
}