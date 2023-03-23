public class Aluno {

    String nome;
    int matricula;
    String curso;
    Materia[] materias = new Materia[10];

    int totalCreditos(){
        int creTotal = 0;
        for(Materia aux: materias){
            if(aux != null)
                creTotal += aux.creditos;
            else break;
        }
        return creTotal;
    }
    void exibirInfos(){
        System.out.println("Dados do(a) aluno(a) " + nome + ":");
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
        if(materias[0] != null){
            System.out.println("Matérias matriculadas:");
            for(Materia aux: materias){
                if(aux != null){
                    System.out.println(" - " + aux.sigla + " - " + aux.nome);
                }
                else break;
            }
        }
        else System.out.println("Este(a) aluno(a) não está matriculado(a) em nenhuma matéria.");
        System.out.println(" ");
    }
}
