package br.com.bytebank.banco.util;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

import java.util.LinkedList;
import java.util.List;

public class TesteLinkedList {

    public static void main(String[] args) {

        LinkedList<Conta> lista = new LinkedList<Conta>();

        ContaCorrente cc1 = new ContaCorrente(111, 222);
        lista.add(cc1);
        ContaCorrente cc2 = new ContaCorrente(333, 444);
        lista.add(cc2);

        System.out.println(lista.getFirst());
        System.out.println(lista.getLast());

        System.out.println("Tamanho: " + lista.size());

        Conta ref = lista.get(0);
        System.out.println(ref.getNumero());

        System.out.println(lista.remove(0));
        System.out.println("Tamanho: " + lista.size());

        ContaCorrente cc3 = new ContaCorrente(555, 666);
        lista.add(cc3);
        ContaCorrente cc4 = new ContaCorrente(777, 888);
        lista.add(cc4);

        System.out.println("-----------------");

        for (int i = 0; i < lista.size(); i++) {
            Conta conta = lista.get(i);
            System.out.println(conta);
        }

        System.out.println("-----------------");

        for (Conta conta: lista){
            System.out.println(conta);
        }
    }
}
