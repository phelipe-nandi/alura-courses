package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

    public static void main(String[] args) {

        String aula1 = "Conhecendo mais de listas";
        String aula2 = "Modelando a classe Aula";
        String aula3 = "Trabalhando com Cursos e Sets";

        ArrayList<String> listaDeAulas = new ArrayList<String>();
        listaDeAulas.add(aula1);
        listaDeAulas.add(aula2);
        listaDeAulas.add(aula3);

        System.out.println(listaDeAulas);

        listaDeAulas.remove(0);

        System.out.println(listaDeAulas);

        listaDeAulas.forEach(aula -> System.out.println("Aula: " + aula));

        String primeiraAula = listaDeAulas.get(0);
        System.out.println("A primeira aula: " + primeiraAula);

        for (int i = 0; i < listaDeAulas.size(); i++) {
            System.out.println("Aula: " + listaDeAulas.get(i));
        }

        for (String aula: listaDeAulas) {
            System.out.println("Aula: " + aula);
        }

        listaDeAulas.add("Aumentando nosso conhecimento");
        System.out.println("Antes da ordenação");
        System.out.println(listaDeAulas);
        Collections.sort(listaDeAulas);
        System.out.println("Depois da ordenação");
        System.out.println(listaDeAulas);
    }
}
