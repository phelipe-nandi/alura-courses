package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaDeAulas {

    public static void main(String[] args) {

        Aula a1 = new Aula("Revisitando as ArrayLists", 21);
        Aula a2 = new Aula("Listas de Objetos", 15);
        Aula a3 = new Aula("Relacionamento de listas e objetos", 15);

        ArrayList<Aula> listaDeAulas = new ArrayList<Aula>();
        listaDeAulas.add(a1);
        listaDeAulas.add(a2);
        listaDeAulas.add(a3);

        Collections.sort(listaDeAulas);
        listaDeAulas.forEach(aula -> System.out.println("Aula: " + aula.toString()));

        System.out.println();

        Collections.sort(listaDeAulas, Comparator.comparing(Aula::getTempo));
        //ou
        listaDeAulas.sort(Comparator.comparing(Aula::getTempo));
        listaDeAulas.forEach(aula -> System.out.println("Aula: " + aula.toString()));

    }
}
