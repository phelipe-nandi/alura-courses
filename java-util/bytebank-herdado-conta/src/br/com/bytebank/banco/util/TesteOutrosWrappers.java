package br.com.bytebank.banco.util;

import java.util.ArrayList;

public class TesteOutrosWrappers {

    public static void main(String[] args) {

        Integer idadeRef = Integer.valueOf(30); //autoboxing
        System.out.println(idadeRef.intValue()); //unboxing

        Double dRef = Double.valueOf(3.2); //autoboxing
        System.out.println(dRef.doubleValue()); //unboxing

        Boolean bRef = Boolean.TRUE; //autoboxing
        System.out.println(bRef.booleanValue()); //unboxing

        Number refNumero = Float.valueOf(39.9f); //autoboxing
        System.out.println(refNumero.floatValue());  //unboxing

        ArrayList<Number> numeros = new ArrayList<Number>();
        numeros.add(10);
        numeros.add(10.5);
        numeros.add(10.5f);
    }
}
