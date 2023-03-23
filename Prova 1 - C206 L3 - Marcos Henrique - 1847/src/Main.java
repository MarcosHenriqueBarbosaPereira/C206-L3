public class Main {
    public static void main(String[] args) {

        //Criando a faculdade ------------------------------------------------------------------------------------------
        Faculdade facul = new Faculdade("Inatel", "123456789");
        facul.alunos = new Aluno[100];

        //Criando as matérias ------------------------------------------------------------------------------------------
        Materia materia1 = new Materia();
        Materia materia2 = new Materia();
        Materia materia3 = new Materia();
        Materia materia4 = new Materia();
        Materia materia5 = new Materia();

        materia1.sigla = "C201";
        materia1.nome = "Introdução à Engenharia";
        materia1.creditos = 2;

        materia2.sigla = "M001";
        materia2.nome = "Matemática";
        materia2.creditos = 4;

        materia3.sigla = "M002";
        materia3.nome = "Álgebra";
        materia3.creditos = 4;

        materia4.sigla = "M003";
        materia4.nome = "Cálculo I";
        materia4.creditos = 4;

        materia5.sigla = "F201";
        materia5.nome = "Física I";
        materia5.creditos = 6;

        //Criando os alunos --------------------------------------------------------------------------------------------
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();
        Aluno aluno3 = new Aluno();

        //Aluno 1
        aluno1.nome = "Marcos";
        aluno1.matricula = 1847;
        aluno1.curso = "Engenharia de Computação";
        aluno1.materias[0] = materia1;
        aluno1.materias[1] = materia2;
        aluno1.materias[2] = materia3;

        facul.alunos[0] = aluno1;
        facul.alunos[0].exibirInfos();
        System.out.println("Total de créditos do aluno " + facul.alunos[0].nome + ": " + facul.alunos[0].totalCreditos());
        System.out.println(" ");

        //Aluno 2
        aluno2.nome = "João";
        aluno2.matricula = 666;
        aluno2.curso = "Engenharia de Automação";
        aluno2.materias[0] = materia4;
        aluno2.materias[1] = materia5;

        facul.alunos[1] = aluno2;
        facul.alunos[1].exibirInfos();
        System.out.println("Total de créditos do aluno " + facul.alunos[1].nome + ": " + facul.alunos[1].totalCreditos());
        System.out.println(" ");

        //Aluno 3
        aluno3.nome = "Felipe";
        aluno3.matricula = 888;
        aluno3.curso = "Engenharia de Software";

        facul.alunos[2] = aluno3;
        facul.alunos[2].exibirInfos();
        System.out.println("Total de créditos do aluno " + facul.alunos[2].nome + ": " + facul.alunos[2].totalCreditos());
        System.out.println(" ");

        //Utilizando exibirInfos da faculdade --------------------------------------------------------------------------
        facul.exibirInfos();
    }
}