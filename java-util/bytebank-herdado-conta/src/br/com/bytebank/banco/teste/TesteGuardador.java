package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeContas;
import br.com.bytebank.banco.modelo.GuardadorDeObjects;

public class TesteGuardador {

    public static void main(String[] args) {

        GuardadorDeContas guardadorDeContas = new GuardadorDeContas();
        GuardadorDeObjects guardadorDeObjects = new GuardadorDeObjects();

        ContaCorrente cc1 = new ContaCorrente(111, 222);
        guardadorDeContas.adiciona(cc1);
        guardadorDeObjects.adiciona(cc1);
        ContaCorrente cc2 = new ContaCorrente(333, 444);
        guardadorDeContas.adiciona(cc2);
        guardadorDeObjects.adiciona(cc2);

        int tamanhoContas = guardadorDeContas.getQuantidadeDeElementos();
        int tamanhoObjects = guardadorDeObjects.getQuantidadeDeElementos();
        System.out.println(tamanhoContas + " - " + tamanhoObjects);

        Conta refConta = guardadorDeContas.getReferencia(0);
        Conta refObject = (Conta) guardadorDeObjects.getReferencia(0);
        System.out.println(refConta.getNumero() + " - " + refObject.getNumero());
    }
}
