public class Faculdade {

    String nome;
    String cnpj;
    Aluno[] alunos;

    public Faculdade(String addNome, String addCnpj){
        this.nome = addNome;
        this.cnpj = addCnpj;
    }

    void exibirInfos(){
        System.out.println("Seguem dados sobre a faculdade e de seus alunos: \n");
        System.out.println("Nome da faculdade: " + nome);
        System.out.println("CNPJ da faculdade: " + cnpj + "\n");
        System.out.println("Alunos:");
        for(Aluno aluno: alunos){
            if(aluno != null){
                System.out.println("Dados do(a) aluno(a) " + aluno.nome + ":");
                System.out.println("Matrícula: " + aluno.matricula);
                System.out.println("Curso: " + aluno.curso);
                if(aluno.materias[0] != null){
                    System.out.println("Matérias matriculadas:");
                    for(Materia aux: aluno.materias){
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
    }
}
