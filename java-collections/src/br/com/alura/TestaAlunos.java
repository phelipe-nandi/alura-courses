package br.com.alura;

import java.util.HashSet;
import java.util.Set;

public class TestaAlunos {

    public static void main(String[] args) {

        Set<String> alunos = new HashSet<>();
        alunos.add("Phelipe Nandi");
        alunos.add("Richard Figueiredo");
        alunos.add("Nico Steppat");
        alunos.add("Paulo Silveira");
        alunos.add("Renan Saggio");
        alunos.add("Gabriel Pfluck");
        alunos.add("Gabriel Pfluck");

        System.out.println(alunos.size());

        System.out.println(alunos);

        alunos.forEach(s -> System.out.println(s));

        boolean phelipeEstaMatriculado = alunos.contains("Phelipe Nandi");
        System.out.println(phelipeEstaMatriculado);

        alunos.remove("Renan Saggio");
        System.out.println(alunos.contains("Renan Saggio"));
    }
}
