package br.com.bytebank.banco.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapperInteger {

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<Integer>();

        int idade = 29;
        numeros.add(idade);

        Integer idadeRef = Integer.valueOf(30);
        numeros.add(idadeRef);

        System.out.println(idadeRef.intValue());
        System.out.println(idadeRef.doubleValue());

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.SIZE);
        System.out.println(Integer.BYTES);

        String s = args[0];
        //Integer numero = Integer.valueOf(s);
        int numero = Integer.parseInt(s);
        System.out.println(numero);

    }
}
