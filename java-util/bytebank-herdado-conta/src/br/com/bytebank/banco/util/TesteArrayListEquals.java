package br.com.bytebank.banco.util;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

import java.util.ArrayList;

public class TesteArrayListEquals {

    public static void main(String[] args) {

        //generics
        ArrayList<Conta> lista = new ArrayList<Conta>();

        ContaCorrente cc1 = new ContaCorrente(111, 222);
        lista.add(cc1);
        ContaCorrente cc2 = new ContaCorrente(333, 444);
        lista.add(cc2);
        ContaCorrente cc3 = new ContaCorrente(333, 444);

        System.out.println(lista.contains(cc3));

        for (Conta conta: lista){
            System.out.println(conta);
        }
    }
}
