package br.com.alura.loja;

import br.com.alura.loja.descontos.CalculadoraDeDescontos;
import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TestesDescontos {

    public static void main(String[] args) {

        Orcamento orcamentoPrimeiro = new Orcamento(new BigDecimal("200"), 6);
        CalculadoraDeDescontos calculadoraDeDescontos = new CalculadoraDeDescontos();
        System.out.println(calculadoraDeDescontos.calcular(orcamentoPrimeiro));

        Orcamento orcamentoSegundo = new Orcamento(new BigDecimal("1000"), 1);
        System.out.println(calculadoraDeDescontos.calcular(orcamentoSegundo));
    }
}