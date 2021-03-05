package br.com.alura;

public class TestaCursoComAluno {

    public static void main(String[] args) {

        Curso javaColecoes = new Curso("Dominando as colecoes do Java", "Phelipe Nandi");

        javaColecoes.adiciona(new Aula("Revisitando as ArrayLists", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com Colecoes", 22));

        Aluno a1 = new Aluno("Rodrigo Turini", 32547);
        Aluno a2 = new Aluno("Paulo Silveira", 56724);
        Aluno a3 = new Aluno("Mauricio Aniche", 24839);

        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);

        javaColecoes.getAlunos().forEach(aluno -> System.out.println("Todos os alunos matriculados nesse curso: " + aluno.toString()));
    }
}
