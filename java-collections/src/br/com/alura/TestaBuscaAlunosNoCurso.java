package br.com.alura;

public class TestaBuscaAlunosNoCurso {

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

        System.out.println("Quem é o aluno com mátricula 56724?");
        Aluno aluno = javaColecoes.buscaMatricula(56724);
        System.out.println("Aluno: " + aluno);
    }
}
