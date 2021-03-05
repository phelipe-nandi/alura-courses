package br.com.alura;

import java.util.List;

public class TestaCursos {

    public static void main(String[] args) {

        Curso javaColecoes = new Curso("Dominando as colecoes do Java", "Phelipe Nandi");

        javaColecoes.adiciona(new Aula("Revisitando as ArrayLists", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com Colecoes", 22));

        System.out.println(javaColecoes.getAulas());
    }
}
